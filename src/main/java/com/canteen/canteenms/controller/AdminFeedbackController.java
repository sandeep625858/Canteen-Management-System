package com.canteen.canteenms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canteen.canteenms.model.Feedback;
import com.canteen.canteenms.model.Feedback;
import com.canteen.canteenms.service.FeedbackService;
import com.canteen.canteenms.service.FeedbackService;

//@RestController
@RequestMapping("/admin")
@Controller
public class AdminFeedbackController {
	@Autowired
	private FeedbackService fs;
	
	@GetMapping("/feedback")
	public String home(Model model) {
		model.addAttribute("feedbackList",fs.getFeedback());
		return "ad_feed.html";
	}

	
//	@GetMapping("/feedback")
//	public List<Feedback> getAllFeedback() {
//		return this.fs.getFeedback();
//	}
	
	
}
