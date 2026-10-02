package com.canteen.canteenms.model;

import java.util.List;

public class OrderSelect {
	
	
	private List<Long> foodIdList;
	private String date;
	private List<Integer> quantity;
	private List<Double> orderPrice;
	public OrderSelect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderSelect(List<Long> foodIdList, String date, List<Integer> quantity, List<Double> orderPrice) {
		super();
		this.foodIdList = foodIdList;
		this.date = date;
		this.quantity = quantity;
		this.orderPrice = orderPrice;
	}
	public List<Long> getFoodIdList() {
		return foodIdList;
	}
	public void setFoodIdList(List<Long> foodIdList) {
		this.foodIdList = foodIdList;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Integer> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}
	public List<Double> getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(List<Double> orderPrice) {
		this.orderPrice = orderPrice;
	}
}
