package com.example.ChaiNashta.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class ProductPrice {
	private String productName;
	private Integer productPrice;
	private Boolean available;

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}

}
