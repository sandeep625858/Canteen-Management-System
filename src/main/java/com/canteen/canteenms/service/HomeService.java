package com.canteen.canteenms.service;
import java.util.List;

// Required Imports
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.model.Users;



// Interface Class Contains all the methods for Home Service Layer
// Implemented By Home Service class
public interface HomeService {
	
	public UserList  addUser(UserList userList);
	public Users addUsers(Users users) ;
	public List<Users> getAllUsers();
	public List<UserList> getAllUser();
	

}
