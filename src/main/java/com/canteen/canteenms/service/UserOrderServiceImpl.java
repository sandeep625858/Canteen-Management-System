package com.canteen.canteenms.service;

//Required Imports
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canteen.canteenms.dao.FoodListDao;
import com.canteen.canteenms.dao.UserListDao;
import com.canteen.canteenms.dao.UserOrderDao;
import com.canteen.canteenms.model.AllOrder;
import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.UserList;


//Service Class to interact between DAo Layer and Controller layer
@Service
public class UserOrderServiceImpl implements UserOrderService {
	
	//User order Database Connection
	@Autowired
	private UserOrderDao uod;
	
	
	//Food List Database Connection
	@Autowired
	private FoodListDao fod;
	
	//Users All Data Database Connection
	@Autowired
	private UserListDao uld;
	
	
	//Default Constructor
	public UserOrderServiceImpl() {
		
		super();
		
}

	
	//Method to retrive all the order data along with the its corresponding food data
	//Getting the Username from Spring Session
	
	@Override
	public List<AllOrder> getAllOrder(String userName){
		
		List<FoodList> foodList = new ArrayList();
		// Using the All Order Class for putting both the food list and order list into the same class
		List<AllOrder> allOrder = new ArrayList();
		//Retreiving all the data for Order
		List<OrderList> orderList = this.uod.findAllOrder();
		//Getting the User data from the session by username
		UserList userList = this.uld.findByUserEmail(userName);
		
		//Matching the order which has the given user id
		for(OrderList orl: orderList) {
			
			if(orl.getUserId()==userList.getUserId()) {
				
				//Putting all the fetched data into the list of all order Class
				allOrder.add(new AllOrder(orl,this.fod.getOne(orl.getFoodId())));
				
			}
		}
		
		return allOrder;
		
	
	}
	
	
	//Method Implementing canceling order
	// Basically sending the order id and updating the order status
	@Override
	public void cancelOrder(long orderId) {
		OrderList orderList = this.uod.getById(orderId);
		if(orderList.getPaymentStatus().equals("Paid")) {
			UserList user = this.uld.findById(orderList.getUserId()).get();
			double amount = user.getWalletBalance()+orderList.getTotalAmount();
			user.setWalletBalance(amount);
			this.uld.save(user);
			orderList.setPaymentStatus("Refunded");
		}
		orderList.setOrderStatus("Cancelled");
		this.uod.save(orderList);
	
		
		
	}

}
