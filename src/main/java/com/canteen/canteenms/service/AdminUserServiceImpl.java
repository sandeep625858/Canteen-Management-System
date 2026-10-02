package com.canteen.canteenms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.canteen.canteenms.dao.AdminFoodListDao;
import com.canteen.canteenms.dao.AdminOrderListDao;
import com.canteen.canteenms.dao.AdminUserListDao;
import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.UserList;

@Component
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	AdminUserListDao adminUserDao;
	
	@Autowired
	AdminFoodListDao adminFoodDao;

	public AdminUserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminUserServiceImpl(AdminUserListDao adminUserDao) {
		super();
		this.adminUserDao = adminUserDao;
	}


	@Override
	public List<UserList> getActiveORInactiveUser(String s) {
		List<UserList> u = adminUserDao.getAllActiveOrInactiveUsers(s);
		return u;
	}

	@Override
	public List<UserList> viewAllUser() {
		return adminUserDao.findAllroles();
	}

	@Override
	public UserList getUserById(long id) {
		Optional<UserList> optional = adminUserDao.findById(id);
		UserList user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException("User with id " + id + " not found.");
		}
		return user;
	}

	@Override
	public void addUser(UserList u) {
		adminUserDao.save(u);
	}

	@Override
	public FoodList getFoodbyId(long id) {
		Optional<FoodList> optional = adminFoodDao.findById(id);
		FoodList food = null;
		if (optional.isPresent()) {
			food = optional.get();
		} else {
			throw new RuntimeException("Food with id " + id + " not found.");
		}
		return food;
	}

}
