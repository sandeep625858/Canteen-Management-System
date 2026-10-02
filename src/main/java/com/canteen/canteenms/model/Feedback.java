package com.canteen.canteenms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long feedbackId;
	private String username;
	private String email;
	private String rating;
	private String feedbackDesc;
	private Date feedDate;
	
	

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(long feedbackId, String username, String email, String rating, String feedbackDesc, Date feedDate) {
		super();
		this.feedbackId = feedbackId;
		this.username = username;
		this.email = email;
		this.rating = rating;
		this.feedbackDesc = feedbackDesc;
		this.feedDate=feedDate;
	}
	public long getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getFeedbackDesc() {
		return feedbackDesc;
	}
	public void setFeedbackDesc(String feedbackDesc) {
		this.feedbackDesc = feedbackDesc;
	}
	
	public Date getFeedDate() {
		return feedDate;
	}
	public void setFeedDate(Date feedDate) {
		this.feedDate = feedDate;
	}
}
