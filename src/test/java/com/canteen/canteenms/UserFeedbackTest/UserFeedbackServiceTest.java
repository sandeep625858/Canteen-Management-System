package com.canteen.canteenms.UserFeedbackTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.canteen.canteenms.dao.FeedbackDao;
import com.canteen.canteenms.model.Feedback;
import com.canteen.canteenms.service.FeedbackService;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserFeedbackServiceTest {

@Autowired
private FeedbackDao fdao;

@Autowired
private FeedbackService fs;

@Test
void isFeedbackExistsById()
{
  Feedback obj=new Feedback();
 // obj.setFeedbackId(1);
  obj.setUsername("sush");
  obj.setEmail("sush@gmail.com");
  obj.setRating("5");
  obj.setFeedDate(new Date(2022,12,10));
  obj.setFeedbackDesc("Great Food");

  fs.addFeedback(obj);
 
  //Boolean result=fs.addFeedback(obj.getFeedbackId());
  //boolean boolVar1 = true;
//assertEquals(boolVar1, result);
 
  assertNotNull(fdao.isFeedbackExistsById(obj.getFeedbackId()));
}

}
