package com.example.ChaiNashta.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection="Market")
public class Market {
	@Id
	private Integer marketId;
	private String marketName;
	private List<Integer> restaurantIds;
	private String marketAddress;
	private String marketCity;

	public Integer getMarketId() {
		return marketId;
	}
	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public List<Integer> getRestaurantIds() {
		return restaurantIds;
	}
	public void setRestaurantIds(List<Integer> restaurantIds) {
		this.restaurantIds = restaurantIds;
	}

	public String getMarketAddress() {
		return marketAddress;
	}
	public void setMarketAddress(String marketAddress) {
		this.marketAddress = marketAddress;
	}

	public String getMarketCity() {
		return marketCity;
	}
	public void setMarketCity(String marketCity) {
		this.marketCity = marketCity;
	}

}
