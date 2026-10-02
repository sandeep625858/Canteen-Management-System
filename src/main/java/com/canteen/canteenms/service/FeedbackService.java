package com.canteen.canteenms.service;

import java.util.List;

import com.canteen.canteenms.model.Feedback;
import com.canteen.canteenms.model.Feedback;

public interface FeedbackService {
	
	// admin
	public List<Feedback> getFeedback();
	//user
	public Feedback addFeedback(Feedback f);
	
	

}
