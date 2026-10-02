package com.canteen.canteenms.AdminFeedbackTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.canteen.canteenms.dao.FeedbackDao;
import com.canteen.canteenms.model.Feedback;
import com.canteen.canteenms.service.FeedbackService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdminFeedbackServiceTest {

	@Autowired
	private FeedbackDao feedbackdao;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Test
	void isFeedbackExistsById() {
		Feedback f=new Feedback();
		//f.setFeedbackId(1);
		f.setUsername("roshni");
		f.setEmail("roshni@gmail.com");
		f.setRating("4");
		f.setFeedDate(new Date(2022,12,07));
		f.setFeedbackDesc("Double Cheese margherita was cheesy");
		feedbackdao.save(f);
		Boolean result=feedbackdao.isFeedbackExistsById(f.getFeedbackId());
		
		boolean boolVar1 = true;
		assertEquals(boolVar1, result);
	}
}
