package com.example.ChaiNashta.service;

import com.example.ChaiNashta.entity.Menu;
import com.example.ChaiNashta.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    public Optional<Menu> findByRestaurantId(Integer restaurantId) {
        return menuRepository.findByRestaurantId(restaurantId);
    }

    public Optional<Menu> findByMenuId(Integer menuId) {
        return menuRepository.findByMenuId(menuId);
    }

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

}
