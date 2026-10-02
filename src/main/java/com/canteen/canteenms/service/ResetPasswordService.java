package com.canteen.canteenms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canteen.canteenms.dao.UserListDao;
import com.canteen.canteenms.dao.UsersRepository;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.model.Users;

@Service
public class ResetPasswordService {
	
	@Autowired
	UserListDao uld;
	
	@Autowired
	UsersRepository urepo;
	
	public Users getUsers(String name) {
		Users userobj = this.urepo.findById(name).get();
		return userobj;
		
	}


	
	public void resetPassword(UserList userobj) {
		
		this.uld.save(userobj);
		
	}

	public void resetUsersPassword(Users usersobj) {
		this.urepo.save(usersobj);
		
	}
}
