package com.example.ChaiNashta.service;

import com.example.ChaiNashta.entity.Restaurant;
import com.example.ChaiNashta.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Optional<Restaurant> findRestaurantByRestaurantId(Integer restaurantId) {
        return restaurantRepository.findByRestaurantId(restaurantId);
    }
    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> findAllRestaurantsByIds(List<Integer> restaurantIds) {
        return restaurantRepository.findByRestaurantIdIn(restaurantIds);
    }

    public List<Restaurant> findAllRestaurantsByMarketId(Integer marketId) {
        return restaurantRepository.findByMarketIdsContaining(marketId);
    }
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

}
