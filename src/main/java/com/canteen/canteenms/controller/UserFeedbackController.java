package com.canteen.canteenms.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.canteen.canteenms.model.Feedback;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.service.FeedbackServiceImpl;
import com.canteen.canteenms.service.UserService;



@Controller
@RequestMapping("/user")
public class UserFeedbackController { // class having all API Endpoints/handlers

	@Autowired
	private FeedbackServiceImpl fs;
	
	@Autowired
	private UserService us;

	@RequestMapping("/feedbackform")
	public String home(Principal user, Model model) {
		UserList userList = us.getUserDetailsByEmail(user.getName());
		model.addAttribute("user",userList);
		return "feed.html";
	}
	
	@RequestMapping("/thankyou")
	public String userthankyou() {
		return "thankyou.html";
	}

	
	
	@RequestMapping(value="/submitfeedbackform/", method=RequestMethod.POST)
	public String addNewFeedback(@ModelAttribute Feedback fobj) {
		//System.out.println(fobj.getRating());
		this.fs.addFeedback(fobj);
		return "redirect:/user/thankyou";

	}

}
