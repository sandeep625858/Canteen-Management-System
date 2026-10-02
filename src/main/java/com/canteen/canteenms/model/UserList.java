package com.canteen.canteenms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Required Imports

// Entity for creating a table into the database with the same name of the class
@Entity
public class UserList {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long userId;
	private String name;
	private String userEmail;
	private String preference;
	private String username;
	private String password;
	private String userStatus; // (Active , Inactive)
	private String role;
	private double walletBalance;
	
	public UserList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserList(long userId, String name, String userEmail, String preference, String username, String password,
			String userStatus, String role, double walletBalance) {
		super();
		this.userId = userId;
		this.name = name;
		this.userEmail = userEmail;
		this.preference = preference;
		this.username = username;
		this.password = password;
		this.userStatus = userStatus;
		this.role = role;
		this.walletBalance = walletBalance;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	@Override
	public String toString() {
		return "UserList [userId=" + userId + ", name=" + name + ", userEmail=" + userEmail + ", preference="
				+ preference + ", username=" + username + ", password=" + password + ", userStatus=" + userStatus
				+ ", role=" + role + ", walletBalance=" + walletBalance + "]";
	}

	

	


	


}
