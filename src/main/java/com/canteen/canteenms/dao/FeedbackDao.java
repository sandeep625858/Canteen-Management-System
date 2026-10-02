package com.canteen.canteenms.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.canteen.canteenms.model.Feedback;


public interface FeedbackDao extends JpaRepository<Feedback, Long>{

//	List<Feedback> findAll();
	@Query("SELECT f FROM Feedback f ORDER BY f.feedDate DESC")
	List<Feedback> findAllByOrderByDateAsc();
	
	@Query("SELECT CASE WHEN COUNT(s)>0 THEN TRUE ELSE FALSE END FROM Feedback s WHERE s.feedbackId=?1")
	Boolean isFeedbackExistsById(Long id);
}
