package com.canteen.canteenms.dao;

//Required Imports
import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.canteenms.model.UserList;

//Extending the Interface of Jpa to use its inbuilt database Operation for Registered User Operations
public interface UserListDao extends JpaRepository<UserList, Long> {

	
	UserList findByUserEmail(String userName);

	

}
