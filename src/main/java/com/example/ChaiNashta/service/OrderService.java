package com.example.ChaiNashta.service;

import com.example.ChaiNashta.entity.Order;
import com.example.ChaiNashta.entity.OrderStatus;
import com.example.ChaiNashta.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
//    @Autowired
//    private OrderKafkaProducer orderKafkaProducer;

    public Order save(Order order) {
        order.setOrderId(orderRepository.findAll().size()+1);
        order.setOrderStatus(OrderStatus.NEW);
        order.setOrderTime(new Date());
        // Write to Kafka
//        orderKafkaProducer.sendNewOrder(order);
        orderRepository.save(order);
        return order;
    }

    public ResponseEntity<String> updateOrderStatusByOrderId(List<Integer> orderIds, OrderStatus orderStatus) {
        Update update = new Update();
        update.set("orderStatus", orderStatus);
        CompletableFuture.runAsync(() ->
                orderIds.stream().forEach(a ->
                orderRepository.updateMultipleFields(a,update))
        );
        return new ResponseEntity<>("Request sent successfully", HttpStatus.ACCEPTED);
    }

    public Optional<Order> updateOrder(Integer orderId, Order order, Integer timeToDeliver) { // Prepare or Send
        order.setExpectedDeliveryTime(timeToDeliver);
        var updatedOrder = orderRepository.findById(orderId);
        updatedOrder.get().setOrderStatus(order.getOrderStatus());
        updatedOrder.get().setDeliveryBoy(order.getDeliveryBoy());
        updatedOrder.get().setExpectedDeliveryTime(timeToDeliver);
        CompletableFuture.runAsync(()-> {
            Update update = new Update();
            update.set("orderStatus", order.getOrderStatus());
            update.set("deliveryBoy", order.getDeliveryBoy());
            update.set("expectedDeliveryTime", updatedOrder.get().getExpectedDeliveryTime());
            orderRepository.updateMultipleFields(orderId, update);
        });
        return updatedOrder;
    }

    public List<Order> findByRestaurantIdAndOrderStatus(Integer restaurantId, OrderStatus orderStatus) {
        List<Order> orders = orderRepository.findByRestaurantIdAndOrderStatus(restaurantId, orderStatus);
        CompletableFuture.runAsync(() -> {
                    if (orderStatus.equals(OrderStatus.NEW)) {
                        Update update = new Update();
                        update.set("orderStatus", OrderStatus.RECEIVED);
                        orders.stream().forEach(a -> orderRepository.updateMultipleFields(a.getOrderId(),update));
                    }
                }
        );
        return orders;
    }
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

}
