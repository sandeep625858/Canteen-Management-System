package com.canteen.canteenms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.canteen.canteenms.model.UserList;

@Repository
public interface AdminUserListDao extends JpaRepository<UserList, Long> {

	@Query(value="SELECT * FROM User_List WHERE user_Status like (?1)",nativeQuery=true)
	public List<UserList> getAllActiveOrInactiveUsers(String status);
	
	@Query("select u from UserList u where u.role='ROLE_USER'")
	public List<UserList> findAllroles();
	

}
