package com.canteen.canteenms.model;

// ALl Order class binds the Order Table and Food Table
public class AllOrder {
	
	// Object of Order table data
	private OrderList orderList;
	
	// Object of Food Table data
	private FoodList foodlist;
	
	
	public AllOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllOrder(OrderList orderList, FoodList foodlist) {
		super();
		this.orderList = orderList;
		this.foodlist = foodlist;
	}
	public OrderList getOrderList() {
		return orderList;
	}
	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}
	public FoodList getFoodlist() {
		return foodlist;
	}
	public void setFoodlist(FoodList foodlist) {
		this.foodlist = foodlist;
	}

	public void tosString() {
		System.out.println(foodlist.getFoodId() + " " + orderList.getOrderId());
	}
	@Override
	public String toString() {
		return "AllOrder [ "+ orderList+" " + foodlist + "]";
	}
	
	
	

}
