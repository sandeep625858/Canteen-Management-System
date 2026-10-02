package com.canteen.canteenms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.canteenms.model.Users;


//Extending the Interface of Jpa to use its inbuilt database Operation for User Authentication Table
// While authenticating the user we use this repository to perform actions on the user username and password
public interface UsersRepository extends JpaRepository<Users, String> {


	
	

}
