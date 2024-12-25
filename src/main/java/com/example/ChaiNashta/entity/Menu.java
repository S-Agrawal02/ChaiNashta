package com.example.ChaiNashta.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="Menu")
public class Menu {

	@Id
	private Integer menuId;
	private Integer restaurantId;
	private List<ProductPrice> productList;
	private String otherItems;

	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public List<ProductPrice> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductPrice> productList) {
		this.productList = productList;
	}

	public String getOtherItems() {
		return otherItems;
	}
	public void setOtherItems(String otherItems) {
		this.otherItems = otherItems;
	}
}
