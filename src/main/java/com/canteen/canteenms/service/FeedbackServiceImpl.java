package com.canteen.canteenms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.canteen.canteenms.dao.FeedbackDao;
import com.canteen.canteenms.dao.FeedbackDao;
import com.canteen.canteenms.model.Feedback;
import com.canteen.canteenms.model.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao fdao;

	//admin
	@Override
	public List<Feedback> getFeedback() {
		return fdao.findAllByOrderByDateAsc();
	}
	
	

	//user
	@Override
	public Feedback addFeedback(Feedback f) {
		return fdao.save(f);
	}

	
	

}
