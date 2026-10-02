package com.canteen.canteenms.service;



import java.util.List;

// Required Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.canteen.canteenms.dao.UserListDao;
import com.canteen.canteenms.dao.UsersRepository;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.model.Users;


// Service Class to handle all the services of the mapped requests from Home Controller and performing operations of the database table
@Service
public class HomeServiceImpl implements HomeService {
	
	
	// Creation of Database Jpa Object Of User using Autowired
	@Autowired
	private UserListDao hd;
	
	// Creation of Database Jpa Object of Users class (authentication purpose)
	@Autowired
	private UsersRepository userrepo;

	
	//addUser() method to add the user to the database
	@Override
	public UserList  addUser(UserList userList) {
		//System.out.println(userList);
	
		// jpa function used to insert into database and return the saved entity as well
		return this.hd.save(userList); 
		
		
	}
	
	
	// Method to add the Users into the Users Table 
	// Required for Authentication
	@Override
	public Users addUsers(Users users) {
		return this.userrepo.save(users);
		
	}


	@Override
	public List<Users> getAllUsers() {
		
		return this.userrepo.findAll();
	}

	
	@Override
	public List<UserList> getAllUser() {
		
		return this.hd.findAll();
	}

	
	
	

}
