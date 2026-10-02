package com.canteen.canteenms.service;

import java.util.List;

import com.canteen.canteenms.model.OrderList;

public interface AdminOrderService {

	List<OrderList> getOrderByStatus(String s);

	void addOrder(OrderList o);

	OrderList getOrderById(long id);

	List<OrderList> getAllOrders();

}
