package com.example.ChaiNashta.repository;

import com.example.ChaiNashta.entity.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,Integer> {
	Optional<Restaurant> findByRestaurantId(Integer restaurantId);

	List<Restaurant> findByRestaurantIdIn(List<Integer> restaurantIds);
	List<Restaurant> findByMarketIdsContaining(Integer marketId);

	// update restaurant
	List<Restaurant> findByMenuId(int menuId);
}
