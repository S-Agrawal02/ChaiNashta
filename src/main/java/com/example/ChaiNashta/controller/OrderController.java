package com.example.ChaiNashta.controller;

import com.example.ChaiNashta.entity.Order;
import com.example.ChaiNashta.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;

	@PutMapping("/saveOrder")
	public Order saveOrder(@RequestBody Order order) {
		return orderService.save(order);
	}

	@PutMapping("/updateAllOrderStatus")
	public ResponseEntity<String> updateOrderStatusByOrderId(
			@RequestParam List<Integer> orderIds,
			@RequestBody Order order) {
		return orderService.updateOrderStatusByOrderId(orderIds, order.getOrderStatus());
	}

	@PutMapping("/updateOrder")
	public Optional<Order> updateOrderByOrderId(
			@RequestParam Integer orderId,
			@RequestBody Order order,
			@RequestParam Integer timeToDeliver) {
		return orderService.updateOrder(orderId, order, timeToDeliver);
	}

	@GetMapping("/getOrdersByRestaurantIdAndOrderStatus")
	public List<Order> findByRestaurantIdAndOrderStatus(
			@RequestParam Integer restaurantId,
			@RequestBody Order order) {
		return orderService.findByRestaurantIdAndOrderStatus(restaurantId, order.getOrderStatus());
	}

	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders() {
		return orderService.findAll();
	}

}
