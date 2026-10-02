package com.canteen.canteenms.UserAndUserOrderDaoTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.canteen.canteenms.dao.UserListDao;
import com.canteen.canteenms.model.UserList;

@SpringBootTest
public class UserListDaoTest {
	
	@Autowired
	  UserListDao userListRepository;
	 
	 @Test
	 public void userListDaoTest() {
		 
		 UserList userList = new UserList(101,"Ankan","ankannath2012@gmail.com","Veg","ankan","ankan","active","ROLE_USER",1200);
		 
		 
		 userListRepository.save(userList);
		 
		 
		   Iterable<UserList> orders = userListRepository.findAll();
		   Assertions.assertThat(orders).extracting(UserList :: getUserStatus).containsOnly("active");
		 
		   userListRepository.deleteAll();
		   Assertions.assertThat(userListRepository.findAll()).isEmpty();
	 }
	

}
