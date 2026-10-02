package com.canteen.canteenms.model;

import javax.persistence.Id;

public class ResetPassword {
	
	
    private String oldpassword;
	
    private String password;

	public ResetPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResetPassword(String oldpassword, String password) {
		super();
		this.oldpassword = oldpassword;
		this.password = password;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    
   
    
    

}
