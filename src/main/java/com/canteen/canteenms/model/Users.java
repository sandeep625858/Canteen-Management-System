package com.canteen.canteenms.model;

// Required imports
import javax.persistence.Entity;
import javax.persistence.Id;


// Class or Entity for Storing the Registered data(same data stored in UserList) separately in the database for authentication purpose
@Entity
public class Users {
	
	@Id
	private String username;
	private String password;
	private String role;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
