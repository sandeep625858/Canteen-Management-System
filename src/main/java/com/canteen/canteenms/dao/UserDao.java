package com.canteen.canteenms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canteen.canteenms.model.UserList;

@Repository
public interface UserDao extends JpaRepository<UserList, Long> {
	
	

	UserList findByUserEmail(String name);

}
