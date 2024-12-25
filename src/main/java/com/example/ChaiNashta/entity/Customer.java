package com.example.ChaiNashta.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="Customer")
public class Customer {
	@Id
	private Integer customerId;
	private String password;
	private Integer marketId;
	private String shopName;
	private Integer shopNoFrom;
	private Integer shopNoTo;
	private Integer floorNo;
	private String block;
	private String customerName;
	private String contactNumber; // Length-10 and only numeric

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getMarketId() {
		return marketId;
	}
	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Integer getShopNoFrom() {
		return shopNoFrom;
	}
	public void setShopNoFrom(Integer shopNoFrom) {
		this.shopNoFrom = shopNoFrom;
	}

	public Integer getShopNoTo() {
		return shopNoTo;
	}
	public void setShopNoTo(Integer shopNoTo) {
		this.shopNoTo = shopNoTo;
	}
	public Integer getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(Integer floorNo) {
		this.floorNo = floorNo;
	}

	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
