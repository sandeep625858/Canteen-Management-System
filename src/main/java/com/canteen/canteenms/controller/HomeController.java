package com.canteen.canteenms.controller;

import java.util.List;

// Required Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.model.Users;
import com.canteen.canteenms.service.HomeServiceImpl;

@Controller
public class HomeController {
	
	// Home Service object creation by autowired
	// Home Service uses the service layer function for various Home Controller Request handling and database workings
	@Autowired
	private HomeServiceImpl hs;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	//URL Mapping for root url request
	@RequestMapping("/")
	public String HomePage(Model model) {
		
		//System.out.println("Sign in hitting"); //For Debugging
		
		
		return "index.html";
	}
	
	
	//Redirection to root url if index page is requested
	@RequestMapping("/index")
	public String handleRedirect() {
		return "redirect:/";
	}
		
	
	
	
	
	
	// Request Mapping for Registration of user
	@RequestMapping(value="/register",method=RequestMethod.POST) 
	public String Register(@ModelAttribute UserList register, Model model ) { 
		// Model Attribute Binds the variables of the form data into a single object
		
	
		List<Users> usersList = this.hs.getAllUsers();
		//System.out.println("Entering Here"); // For Debugging
		
		// Sending to the Home service to add it to the database
		//System.out.println(register); // For Debugging
		
		//Checking if the Username Already Exists
		for(Users urs : usersList) {
			if(urs.getUsername().equals(register.getUserEmail())) {
				
				model.addAttribute("msg","Error");
				
				return "RegistrationFailure.html";
			}
		}
		
		
		try {
		register.setPassword(passwordEncoder.encode(register.getPassword()));
		this.hs.addUser(register);
		this.hs.addUsers(new Users(register.getUserEmail(),register.getPassword(),register.getRole()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(register.getUsername()); //For debugging
		model.addAttribute("msg","Success");
		
		return "RegistrationSuccess.html";
		
		}
	

}
