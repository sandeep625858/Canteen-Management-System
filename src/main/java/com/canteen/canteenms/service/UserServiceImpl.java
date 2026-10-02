package com.canteen.canteenms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canteen.canteenms.dao.MenuDao;
import com.canteen.canteenms.dao.OrderDao;
import com.canteen.canteenms.dao.UserDao;
import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.UserList;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private MenuDao mDao;
	
	@Autowired
	private OrderDao oDao;
	
	private OrderList order;
	
	@Autowired
	private UserDao uDao;
	
	
	
	
	@Override
	public List<FoodList> getAllUserMenu(String month,int year) {
		return this.mDao.findAllAvailiable(month,year);
	}


	@Override
	public void addOrder(String date, List<Long> list,List<Integer> quantity,List<Double> orderPrice,long UserId) {
		// TODO Auto-generated method stub
		for (int i=0;i<quantity.size();i++) {
			order= new OrderList(0,UserId,list.get(i),date,quantity.get(i),orderPrice.get(i),"Placed",orderPrice.get(i)*quantity.get(i),"Pending");
			this.oDao.save(order);
		}
	}


	@Override
	public void optOut(String date,long UserId) {
		// TODO Auto-generated method stub
			order= new OrderList(0,UserId,0,date,0,0,"OptOut",0,"OptOut");
			this.oDao.save(order);
	}


	@Override
	public UserList getUserDetails(long userId) {
		
//		System.out.println(this.uDao.getById(userId));
		return this.uDao.findById(userId).get();
		
	}


	@Override
	public UserList updateProfile(UserList user) {
		
		return this.uDao.save(user);
		
	}
	
	@Override
	public List<OrderList> findAllUnPaid(long UserId){
		return this.oDao.findAllUnpaid(UserId);
	}
	
	@Override
	public FoodList findById(long foodId) {
		return this.mDao.findById(foodId).get();
	}


	@Override
	public OrderList findByorderId(long orderId) {
		return this.oDao.findById(orderId).get();
	}
	
	@Override
	public OrderList saveOrder(OrderList order) {
		this.oDao.save(order);
		return order;
	}


	@Override
	public void updateAllOrder(long userId) {
		this.oDao.updateAllOrder(userId);
		
	}


	

	@Override
	public UserList getUserDetailsByEmail(String name) {
		return this.uDao.findByUserEmail(name);
		
	}

	
	
}
