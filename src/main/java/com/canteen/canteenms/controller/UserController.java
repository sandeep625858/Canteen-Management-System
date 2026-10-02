package com.canteen.canteenms.controller;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.OrderSelect;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.service.UserService;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class UserController {
	
	// Autowired the service layer to utilize all the functions of that layer 
	@Autowired(required=false)
	private UserService service;
	
	
	@RequestMapping("/")
	public String userhome(Principal user,Model model) {
		String Username = user.getName();
		UserList userList = this.service.getUserDetailsByEmail(Username);
		model.addAttribute("username",userList.getName());
		model.addAttribute("userid",userList.getUserId());
		model.addAttribute("userStatus",userList.getUserStatus());
		
		return "userdashboard.html";
	}

	/* Api to fetch all the items of foodlist and display in browser in form of a table so that the
	 user can place order */
	@GetMapping("/menu")
	public String getAllUserMenu(Model model,Principal User) {
		
		LocalDate currentdate = LocalDate.now();
		
		Month currentmonth = currentdate.getMonth();
		String currentMonth = currentmonth.toString();
		currentMonth = currentMonth.charAt(0)+currentMonth.substring(1).toLowerCase(); 
	    System.out.println("Current month: "+currentMonth);
	      //getting the current year
	    int currentYear = currentdate.getYear();
	    System.out.println("Current month: "+currentYear);
			
	    model.addAttribute("preference",service.getUserDetailsByEmail(User.getName()).getPreference());
	    
		List<FoodList> foodMenu = this.service.getAllUserMenu(currentMonth,currentYear);	// Getting All values of Food table based on certain conditions and storing in the database
		model.addAttribute("foodMenu", foodMenu); // Model Attribute used to send data to any frontend page
		return "orderPage.html";

		
	}
	
	
	
	
	
	//Receiving the orders of the user in form of JSON using @RequestBody in an class named oSelect
	// and sending the value to the Service layer to add to the OrderList Table
	@PostMapping("/menu/selection")
	public void addOrder(@RequestBody OrderSelect oSelect,HttpServletResponse res,Principal User) {
		
		UserList userprofile = this.service.getUserDetailsByEmail(User.getName());// Getting the user deatails using the session Management
		
		this.service.addOrder(oSelect.getDate(), oSelect.getFoodIdList(),oSelect.getQuantity(),oSelect.getOrderPrice(),userprofile.getUserId());
		try {
			res.sendRedirect("/user/menu");	//used to redirect user to the desired Api/Page
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//If The user chooses to optout sending optout to the OrderList Table
	
	@PostMapping("/menu/optOut")
	public void optOut(@RequestBody OrderSelect oSelect,HttpServletResponse res,Principal User) {
		UserList userprofile = this.service.getUserDetailsByEmail(User.getName());// Getting the user deatails using the session Management
		
		this.service.optOut(oSelect.getDate(),userprofile.getUserId());
		try {
			res.sendRedirect("/user/menu");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	// Fetching the details of the User from the database and showing those values in form of a Form in Frontend
	// so that the user can changed the details if he wants
	@RequestMapping("/details")
	public String showUserDetails(Principal User, Model model) {
		
		UserList userprofile = this.service.getUserDetailsByEmail(User.getName());// Getting the user deatails using the session Management
		model.addAttribute("userDetails",userprofile);
		return "userProfile.html";
		
	}
	
	
	
	
	//Taking the changes that the user provided and saving those changes to the database
	@PostMapping("/details/updateUser")
	public void updateUserProfile(@ModelAttribute UserList user,HttpServletResponse response) {
		this.service.updateProfile(user);	// Saving all the updates to the UserList Table
		try {
			response.sendRedirect("/user/details");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Fetching All the pending payments of the user and displaying in a table format with a option to pay the pending ones
	@GetMapping("/payment")
	public String findAllUnPaid(Principal User, Model model){
		UserList user = this.service.getUserDetailsByEmail(User.getName());// Getting the user deatails using the session Management
		List<OrderList> nonpaid = this.service.findAllUnPaid(user.getUserId());	// Getting all the payment status pending orders from the OrderList table  
		model.addAttribute("payment",nonpaid);
		double totalPrice = 0;			//Taking a double variable to calculate the total pending price
		List<FoodList> foodList = new ArrayList<>();
		for(int i=0;i<nonpaid.size();i++) {
			totalPrice += nonpaid.get(i).getTotalAmount();
			foodList.add(this.service.findById(nonpaid.get(i).getFoodId()));	// Fetching the foodList values with the foodId from Order Table
		}
		model.addAttribute("Total",totalPrice);		// Calculating and Sending the total unpaid amount
		model.addAttribute("foodList",foodList);
		
		
		return "paymentPage.html";
	}
	
	
	
	/*Sending the orderId that user selected to pay and fetching the amount to pay using wallet balance
	 	here @RequestParam is used to */
	@GetMapping("/payment/pay{id}")
	public String paymentPage(@RequestParam("id") String id,Model model) {
		
		long orderId = Long.parseLong(id);
		OrderList order = this.service.findByorderId(orderId);
		model.addAttribute("order", order);
		return "payment.html";
		
		
	}
	
	
	
	
	// If the user decides to pay all the pending payments at once then we will fetch total amount received in url
	@GetMapping("/payment/payAll{total}")
	public String paymentAll(@RequestParam("total") String Total,Model model) {
		double total = Double.parseDouble(Total);
		model.addAttribute("Total", total);
		return "paymentAll.html";
	}
	
	
	// After Payment Making Changes to the wallet balance and changing the orderList status in case of selected orderId
	@GetMapping("/payment/pay/paid{id}")
	public String paid(@RequestParam("id") String id,Principal User, Model model) {
		
		long orderId = Long.parseLong(id);
		
		OrderList order = this.service.findByorderId(orderId);
		
		order.setPaymentStatus("Paid");
		
		
		UserList userprofile = this.service.getUserDetailsByEmail(User.getName());// Getting the user deatails using the session Management
		
		if(order.getTotalAmount()>userprofile.getWalletBalance()) {
			return "failure.html";
		}
		
		double amount = userprofile.getWalletBalance() - order.getTotalAmount();
		
		userprofile.setWalletBalance(amount);
		
		this.service.saveOrder(order);
		
		this.service.updateProfile(userprofile);
		
		return "Success.html";
		
	}
	
	
	
	
	// After Payment Making Changes to the wallet balance and changing the orderList status in case of all orders by the user
	@GetMapping("/payment/pay/paidAll{total}")
	public String paidAll(@RequestParam("total") String Total,Principal User) {
		
		UserList userprofile = this.service.getUserDetailsByEmail(User.getName());// Getting the user deatails using the session Management
		
		double total = Double.parseDouble(Total);
		
		if(total > userprofile.getWalletBalance()) {
			return "failure.html";
		}
		
		double amount = userprofile.getWalletBalance() - total;
		
		userprofile.setWalletBalance(amount);
		
		this.service.updateAllOrder(userprofile.getUserId());
		
		this.service.updateProfile(userprofile);
		
		return "Success.html";
		
	}
	
	
	
	// Displaying the Balance and showing a add money form so that user can add money
	@RequestMapping("/add")
	public String addToWallet(Model model,Principal User) {
		UserList userprofile = this.service.getUserDetailsByEmail(User.getName());// Getting the user deatails using the session Management
		double balance = userprofile.getWalletBalance(); 
		
		model.addAttribute("balance",balance);
		
		return "addBalance.html";
	}
	
	
	
	
	// Fetching the WalletBalance of the user and adding the balance to the wallet
	@PostMapping("/add/wallet")
	public void addedWallet(@RequestParam(value="Amount") String Amount,HttpServletResponse res,Principal User) {
		
		UserList userprofile = this.service.getUserDetailsByEmail(User.getName());// Getting the user deatails using the session Management
		
		double amount = userprofile.getWalletBalance() + Double.parseDouble(Amount);
		
		userprofile.setWalletBalance(amount);
		
		this.service.updateProfile(userprofile);
		
		try {
			res.sendRedirect("/user/add");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
