package com.canteen.canteenms.AdminUserTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.canteen.canteenms.dao.AdminFoodListDao;
import com.canteen.canteenms.dao.AdminUserListDao;
import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.service.AdminUserService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class AdminUserDaoTest {
	
	@Autowired
	private AdminUserListDao adminUserDao;
	
	@Autowired
	private AdminUserService adminUserService;
	
	@Autowired
	private AdminFoodListDao adminFoodDao;
	
	
	@Test
	@Order(1)
	void getAllActiveOrInactiveUsersTestActive()
	{
		List<UserList> l = adminUserDao.getAllActiveOrInactiveUsers("active");
		assertThat(l).size().isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	void getAllActiveOrInactiveUsersTestInactive()
	{
		List<UserList> l = adminUserDao.getAllActiveOrInactiveUsers("inactive");
		assertThat(l).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	void findAllrolesTest()
	{
		List<UserList> l2 = adminUserDao.findAllroles();
		assertThat(l2).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(5)
	void addUserTest()
	{
		UserList u = new UserList();
		u.setName("john2");
		u.setPassword("john2");
		u.setPreference("veg");
		u.setRole("USER_ROLE");
		u.setUserEmail("john@gmail.com");
		u.setUsername("john2");
		u.setUserStatus("active");
		u.setWalletBalance(1000);
		this.adminUserService.addUser(u);
		assertNotNull(adminUserService.getUserById(u.getUserId()));
	}
	
	
	@Test
	@Order(4)
	void getUserByIdTest()
	{
		UserList u = new UserList();
		u.setName("john2");
		u.setPassword("john2");
		u.setPreference("veg");
		u.setRole("USER_ROLE");
		u.setUserEmail("john@gmail.com");
		u.setUsername("john2");
		u.setUserStatus("active");
		u.setWalletBalance(1000);
		this.adminUserDao.save(u);
		UserList result = adminUserService.getUserById(u.getUserId());
	     assertThat(u)
         .usingRecursiveComparison()
         .isEqualTo(result);
	}

	@Test
	@Order(6)
	void getFoodByIdTest()
	{
		FoodList f = new FoodList();
		f.setFoodName("Pasta");
		f.setFoodPrice(50);
		f.setFoodStatus("Available");
		f.setCategory("Veg");
		f.setMeal("Breakfast");
		f.setMonth("January");
		f.setYear(2023);
		this.adminFoodDao.save(f);
		FoodList result = adminUserService.getFoodbyId(f.getFoodId());
	     assertThat(f)
         .usingRecursiveComparison()
         .isEqualTo(result);
	}
	
	
}
