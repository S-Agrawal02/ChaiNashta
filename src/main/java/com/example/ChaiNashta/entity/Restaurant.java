package com.example.ChaiNashta.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="Restaurant")
public class Restaurant {
	@Id
	private Integer restaurantId;
	private String restaurantName;
	private Integer menuId;
	private String address;
	private String contactNumber;
	private List<Integer> marketIds;
	private RestaurantStatus restaurantStatus;

	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<Integer> getMarketIds() {
		return marketIds;
	}
	public void setMarketIds(List<Integer> marketIds) {
		this.marketIds = marketIds;
	}

	public RestaurantStatus getRestaurantStatus() {
		return restaurantStatus;
	}
	public void setRestaurantStatus(RestaurantStatus restaurantStatus) {
		this.restaurantStatus = restaurantStatus;
	}

}
