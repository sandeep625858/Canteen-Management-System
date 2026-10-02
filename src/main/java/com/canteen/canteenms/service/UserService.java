package com.canteen.canteenms.service;

import java.util.List;

import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.UserList;

public interface UserService {
	
	public List<FoodList> getAllUserMenu(String currentMonth, int currentYear);
	public void addOrder(String date,List<Long> list,List<Integer> quantity,List<Double> orderPrice, long userId);
	public void optOut(String date, long userId);
	public UserList getUserDetails(long userId);
	public UserList updateProfile(UserList user);
	public List<OrderList> findAllUnPaid(long UserId);
	public FoodList findById(long foodId);
	public OrderList findByorderId(long orderId); 
	public OrderList saveOrder(OrderList order);
	public void updateAllOrder(long userId);
	public UserList getUserDetailsByEmail(String name);

}
