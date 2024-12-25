package com.example.ChaiNashta.controller;

import com.example.ChaiNashta.entity.Restaurant;
import com.example.ChaiNashta.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@GetMapping("/getByRestaurantId")
	public Optional<Restaurant> getByRestaurantId(@RequestParam Integer restaurantId) {
		return restaurantService.findRestaurantByRestaurantId(restaurantId);
	}
	@GetMapping("/getAllRestaurants")
	public List<Restaurant> getAllRestaurants() {
		return restaurantService.findAllRestaurants();
	}

	@GetMapping("/getAllRestaurantsByIds")
	public List<Restaurant> getAllRestaurantsByIds(@RequestParam  List<Integer> restaurantIds) {
		return restaurantService.findAllRestaurantsByIds(restaurantIds);
	}
	@PutMapping("/saveRestaurant")
	public Restaurant save(@RequestBody Restaurant restaurant)
	{
		if(restaurant.getRestaurantId() == null)
			restaurant.setRestaurantId(restaurantService.findAllRestaurants().size()+1);
		restaurant.setMenuId(restaurant.getRestaurantId());
		restaurantService.save(restaurant);
		return restaurant;
	}

	@GetMapping("/getRestaurantsByMarketId")
	public List<Restaurant> getRestaurantsByMarketId(@RequestParam Integer marketId) {
		return restaurantService.findAllRestaurantsByMarketId(marketId);
	}

}
