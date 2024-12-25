package com.example.ChaiNashta.controller;

import com.example.ChaiNashta.entity.Menu;
import com.example.ChaiNashta.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants/menu")
public class MenuController {
	@Autowired
	MenuService menuService;

	@GetMapping("/getByRestaurantId")
	public Optional<Menu> getByRestaurantId(@RequestParam Integer restaurantId) {
		return menuService.findByRestaurantId(restaurantId);
	}

	@PutMapping("/saveMenu")
	public Menu save(@RequestBody Menu menu) {
		return menuService.save(menu);
	}

	@GetMapping("/getByMenuId")
	public Optional<Menu> getByMenuId(@RequestParam Integer menuId) {
		return menuService.findByMenuId(menuId);
	}
	@GetMapping("/getAllMenu")
	public List<Menu> getAllMenu() {
		return menuService.findAll();
	}

}
