package com.canteen.canteenms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//Order List Class Or Entity for Order Database 
@Entity
public class OrderList {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long orderId;
	private long userId;
	private long foodId;
	private String savetime;	// (dd-mm-yyyy)
	private int quantity;
	private double orderPrice;
	private String orderStatus;	// (cancelled,Placed,Delivered)
	private double totalAmount;
	private String paymentStatus;

	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderList(long orderId, long userId, long foodId, String savetime, int quantity, double orderPrice,
			String orderStatus, double totalAmount, String paymentStatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.foodId = foodId;
		this.savetime = savetime;
		this.quantity = quantity;
		this.orderPrice = orderPrice;
		this.orderStatus = orderStatus;
		this.totalAmount = totalAmount;
		this.paymentStatus = paymentStatus;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public String getSavetime() {
		return savetime;
	}

	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "OrderList [orderId=" + orderId + ", userId=" + userId + ", foodId=" + foodId + ", savetime=" + savetime
				+ ", quantity=" + quantity + ", orderPrice=" + orderPrice + ", orderStatus=" + orderStatus
				+ ", totalAmount=" + totalAmount + ", paymentStatus=" + paymentStatus + "]";
	}
	
	

}
