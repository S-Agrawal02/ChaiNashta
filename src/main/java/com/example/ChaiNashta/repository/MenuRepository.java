package com.example.ChaiNashta.repository;

import com.example.ChaiNashta.entity.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends MongoRepository<Menu,Integer> {
	Optional<Menu> findByRestaurantId(Integer restaurantId);
	Optional<Menu> findByMenuId(Integer menuId);

}
