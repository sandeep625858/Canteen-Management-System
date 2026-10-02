package com.canteen.canteenms.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.service.AdminOrderService;
import com.canteen.canteenms.service.AdminUserService;
import com.canteen.canteenms.service.UserOrderService;
import com.canteen.canteenms.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AdminOrderService adminOrderService;
	

	// View All users
	@GetMapping("/viewAllUser")
	public String viewUserList(Model model) {
		model.addAttribute("userList", adminUserService.viewAllUser());
		return "viewUsers.html";
	}

	// Update User details
	@PostMapping("/insertUser")
	public String insertUser(@ModelAttribute("user") UserList user) {
		adminUserService.addUser(user);
		return "redirect:/admin/viewAllUser";
	}

	// Remove user
	@PostMapping("/removeUser")
	public String deleteUser(@ModelAttribute("user") UserList user) {
		user.setUserStatus("inactive");
		adminUserService.addUser(user);
		return "redirect:/admin/viewAllUser";
	}

	// Get user for removing or updating user
	@GetMapping("/userDetails/{id}")
	public String userDetails(@PathVariable("id") Long id, Model model) {
		UserList u = new UserList();
		u = adminUserService.getUserById(id);
		model.addAttribute("user", u);
		return "userDetailsForm.html";
	}

	// Get user for removing or updating user
	@GetMapping("/userActivate/{id}")
	public String activateUserForm(@PathVariable("id") Long id, Model model) {
		UserList u = new UserList();
		u = adminUserService.getUserById(id);
		model.addAttribute("user", u);
		return "activateUserForm.html";
	}

	// Activate user
	@PostMapping("/activateUser")
	public String activateUser(@ModelAttribute("user") UserList user) {
		user.setUserStatus("active");
		adminUserService.addUser(user);
		return "redirect:/admin/viewAllUser";
	}

	// View for All Orders
	@GetMapping("/DeliverOrder")
	public String allOrderDetails(Model model) {
		List<FoodList> f = new ArrayList<>();
		List<UserList> u = new ArrayList<>();
		List<OrderList> o = adminOrderService.getAllOrders();
		for (OrderList ol : o) {
			u.add(adminUserService.getUserById(ol.getUserId()));
			f.add(adminUserService.getFoodbyId(ol.getFoodId()));
		}
		model.addAttribute("food", f);
		model.addAttribute("user", u);
		model.addAttribute("orders", adminOrderService.getAllOrders());
		return "viewOrders.html";
	}

	// View For placed Orders
	@GetMapping("/viewPlacedOrder")
	public String orderDetailsForplaced(Model model) {
		String s = "Placed";
		model.addAttribute("orders", adminOrderService.getOrderByStatus(s));
		return "viewOrders.html";
	}

	// View For delivered Orders
	@GetMapping("/viewDeliveredOrder")
	public String orderDetailsForDelivered(Model model) {
		String s = "Delivered";
		model.addAttribute("orders", adminOrderService.getOrderByStatus(s));
		return "viewOrders.html";
	}

	// For Delivering Placed Orders
	@GetMapping("/delivery/{id}")
	public String deliveringFood(@PathVariable("id") Long id, Model model) {
		OrderList o = new OrderList();
		o = adminOrderService.getOrderById(id);
		o.setOrderStatus("Delivered");
		adminOrderService.addOrder(o);
		return "redirect:/admin/DeliverOrder";
	}

	// View all the Active Users
	@GetMapping("/viewActiveUser")
	public String viewActive(Model model) {
		String a = "active";
		model.addAttribute("userList", adminUserService.getActiveORInactiveUser(a));
		return "viewActiveUsers.html";
	}

	// View all the InActive Users
	@GetMapping("/viewInActiveUser")
	public String viewInActive(Model model) {
		String a = "inactive";
		model.addAttribute("userList", adminUserService.getActiveORInactiveUser(a));
		return "viewUsers.html";
	}
	

	// Fetching the details of the User from the database and showing those values in form of a Form in Frontend
	// so that the user can changed the details if he wants
	@GetMapping("/details")
	public String showUserDetails(Principal Admin, Model model) {
		
		UserList admin = this.service.getUserDetailsByEmail(Admin.getName());	// Getting the user deatails using the session Management
		UserList adminprofile = this.service.getUserDetails(admin.getUserId());
		model.addAttribute("adminDetails",adminprofile);
		return "adminProfile.html";
		
	}
	
	
	
	
	//Taking the changes that the user provided and saving those changes to the database
	@PostMapping("/details/updateAdmin")
	public void updateUserProfile(@ModelAttribute UserList admin,HttpServletResponse response) {
		this.service.updateProfile(admin);	// Saving all the updates to the UserList Table
		try {
			response.sendRedirect("/admin/details");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
