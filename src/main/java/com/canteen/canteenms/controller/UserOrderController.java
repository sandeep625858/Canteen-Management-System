package com.canteen.canteenms.controller;
//Required Imports


import java.security.Principal;
//Collection Framework Imports
import java.util.ArrayList;
import java.util.List;

//Annotation imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//Model Imports
import com.canteen.canteenms.model.AllOrder;
import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.service.UserOrderServiceImpl;

@Controller
public class UserOrderController {
	
	
	//User Order Service class object by Autowiring
	@Autowired
	private UserOrderServiceImpl os;
	
	
	// Url Mapping for Viewing User Order
	@GetMapping("/user/viewuserorder")
	public ModelAndView userOrder(Principal  user){
		
		//Using Model and View to Send Data attributes to the front end
		ModelAndView model= new ModelAndView();
		
		// LIst of different objects of models
		System.out.println(user.getName());
		List<AllOrder> orders = this.os.getAllOrder(user.getName());
		List<FoodList> foodList = new ArrayList<>();
		List<OrderList> orderList = new ArrayList<>();
		
		for(AllOrder temp : orders) {
			System.out.println(temp.getFoodlist());
			foodList.add(temp.getFoodlist());
			orderList.add(temp.getOrderList());
		}
		
		//adding attributes to the model
		model.addObject("foods",foodList);
		model.addObject("orders",orderList);
		model.setViewName("viewuserorder.html");
		
		return model;
	}
	
	
	//URl Mapping to implement the canceling function of the order the order
	@GetMapping("/user/cancelorder")
	public String deleteOrder(@RequestParam Long orderId) {
		this.os.cancelOrder(orderId);
		 
		return "redirect:/user/viewuserorder";
		
	}

}
