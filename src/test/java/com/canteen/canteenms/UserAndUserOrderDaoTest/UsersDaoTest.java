package com.canteen.canteenms.UserAndUserOrderDaoTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.canteen.canteenms.dao.UsersRepository;
import com.canteen.canteenms.model.Users;

@SpringBootTest
public class UsersDaoTest {
	
	@Autowired
	  UsersRepository usersRepository;
	 
	 @Test
	 public void usersReposTest() {
		 
		 Users users = new Users("rahul@gmail.com","rahul1234","ROLE_USER");
		 
		 
		 usersRepository.save(users);
		 
		 
		   Iterable<Users> orders = usersRepository.findAll();
		   Assertions.assertThat(orders).extracting(Users :: getUsername).containsOnly("rahul@gmail.com");
		 
		   usersRepository.deleteAll();
		   Assertions.assertThat(usersRepository.findAll()).isEmpty();
	 }
	

}
