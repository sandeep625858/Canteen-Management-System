package com.canteen.canteenms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.UserList;

@Service
public interface AdminUserService {
	
	
	
	List<UserList> getActiveORInactiveUser(String s);
	
	List<UserList> viewAllUser();
	
	UserList getUserById(long id);
	
	void addUser(UserList u);
	
	FoodList getFoodbyId(long id);	
	
}
