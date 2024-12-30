package com.example.ChaiNashta.service;

import com.example.ChaiNashta.entity.Order;
import com.example.ChaiNashta.entity.OrderStatus;
import com.example.ChaiNashta.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderKafkaConsumer {
    @Autowired
    private OrderRepository orderRepository;
    @KafkaListener(topics = "${spring.kafka.order-topic.name}", groupId = "${spring.kafka.order-consumer.group-id}")
    public void consume(String orderJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Deserialize JSON string to Order object
            Order order = objectMapper.readValue(orderJson, Order.class);
            if(order.getOrderStatus().equals(OrderStatus.NEW)) {
                orderRepository.save(order);
                System.out.println("New Order received: " + order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
