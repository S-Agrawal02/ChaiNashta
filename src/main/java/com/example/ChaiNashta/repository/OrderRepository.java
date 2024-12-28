package com.example.ChaiNashta.repository;

import com.example.ChaiNashta.entity.Order;
import com.example.ChaiNashta.entity.OrderStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {

	Order save(Order order);
	List<Order> findByRestaurantIdAndOrderStatus(Integer restaurantId, OrderStatus orderStatus);
	@Query("{ 'orderId': ?0 }")
	void updateMultipleFields(Integer orderId, Update update);

}