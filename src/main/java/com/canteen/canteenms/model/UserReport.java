package com.canteen.canteenms.model;

public class UserReport {
	
	private long userId;
	private String userName;
	private long noOfBreakfast;
	private long noOfLunch;
	private long noOfOptOut;
	private long noOfBoth;
	public UserReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserReport(long userId, String userName, long noOfBreakfast, long noOfLunch, long noOfOptOut,
			long noOfBoth) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.noOfBreakfast = noOfBreakfast;
		this.noOfLunch = noOfLunch;
		this.noOfOptOut = noOfOptOut;
		this.noOfBoth = noOfBoth;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getNoOfBreakfast() {
		return noOfBreakfast;
	}
	public void setNoOfBreakfast(long noOfBreakfast) {
		this.noOfBreakfast = noOfBreakfast;
	}
	public long getNoOfLunch() {
		return noOfLunch;
	}
	public void setNoOfLunch(long noOfLunch) {
		this.noOfLunch = noOfLunch;
	}
	public long getNoOfOptOut() {
		return noOfOptOut;
	}
	public void setNoOfOptOut(long noOfOptOut) {
		this.noOfOptOut = noOfOptOut;
	}
	public long getNoOfBoth() {
		return noOfBoth;
	}
	public void setNoOfBoth(long noOfBoth) {
		this.noOfBoth = noOfBoth;
	}
	@Override
	public String toString() {
		return "UserReport [userId=" + userId + ", userName=" + userName + ", noOfBreakfast=" + noOfBreakfast
				+ ", noOfLunch=" + noOfLunch + ", noOfOptOut=" + noOfOptOut + ", noOfBoth=" + noOfBoth + "]";
	}
	
	

}
