package com.canteen.canteenms.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.canteen.canteenms.dao.MenuDao;
import com.canteen.canteenms.dao.OrderDao;
import com.canteen.canteenms.dao.UserDao;
import com.canteen.canteenms.dao.UserListDao;
import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.service.UserService;

@SpringBootTest
public class UserServiceImplTest {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private MenuDao mDao;
	
	@MockBean
	private OrderDao oDao;
	
	@MockBean
	private UserDao uDao;
	
	@Test
	public void getAllUserMenuTest() {
		
		
		mDao.save(new FoodList(1L,"pizza","Veg","Lunch","Available",300.0,"January",2023));
		mDao.save(new FoodList(2L,"pasta","Veg","Lunch","Unavailable",400.0,"January",2023));
		mDao.save(new FoodList(3L,"Chicken","Nonveg","Breakfast","Available",300.0,"January",2023));
		mDao.save(new FoodList(4L,"prawn","Nonveg","Lunch","Available",200.0,"January",2022));
		mDao.save(new FoodList(5L,"Fish","Nonveg","Breakfast","Available",100.0,"February",2023));
		
		LocalDate currentdate = LocalDate.now();
		Month currentmonth = currentdate.getMonth();
		String currentMonth = currentmonth.toString();
		currentMonth = currentMonth.charAt(0)+currentMonth.substring(1).toLowerCase(); 
	    int currentYear = currentdate.getYear();
		
		assertThat(mDao.findAllAvailiable(currentMonth, currentYear).size()== 2);
		
		
//		assertEquals(2,userService.getAllUserMenu(currentMonth, currentYear).size());
		
	}
	
	@Test
	public void optOutTest() {
		
		LocalDate currentdate = LocalDate.now();
		userService.optOut(currentdate.toString(), 100);
		assertNotNull(oDao.findByUserId((long) 100));
		
	}
	
	@Test
	public void addOrderTest() {
		
		LocalDate currentdate = LocalDate.now();
		List<Long> foodId = new ArrayList<>();
		foodId.add(25L);
		List<Integer> quantity = new ArrayList<>();
		quantity.add(2);
		List<Double> price = new ArrayList<>();
		price.add(250.0);
		userService.addOrder(currentdate.toString(), foodId, quantity, price, 200L);
		
		assertNotNull(oDao.findByUserId(200L));
		
		
	}
	
//	@Test
//	public void getUserDetailsTest() {
//		
//		UserList userList = new UserList();
//		userList.setUserId(200L);
//		userList.setName("Sandeep");
//		userList.setUserEmail("sandeep12@gmail.com");
//		userList.setUsername("sandeep02");
//		userList.setPassword("sandeep");
//		userList.setUserStatus("Active");
//		userList.setPreference("Veg");
//		userList.setRole("ROLE_USER");
//		userList.setWalletBalance(1500.00);
//		
//		assertThat(uDao.save(userList));
//		
//		System.out.println(userList);
//		
//		System.out.println(uDao.findAll());
//		
//		assertNotNull(userService.getUserDetails(200L).getWalletBalance()==1500);
//		
//	}
	@Test
	public void findAllUnpaidTest() {
		//oDao.save(new OrderList)
		assertNotNull(userService.findAllUnPaid(200L).size()==1);
	}
	
//	@Test
//	public void findByIdTest() {
//			when(mDao.findById(2L).get()).thenReturn((FoodList) Stream.of(new FoodList(2L,"pasta","Veg","Lunch","Unavailable",400.0,"January",2023)).collect(Collectors.toList()));
//			
//			assertEquals(1, userService.findById(2L));
//	}
	
	@Test
	public void saveOrderTest() {
		
		OrderList order = new OrderList();
		order.setOrderId(50L);
		order.setFoodId(2L);
		order.setUserId(100L);
		order.setOrderPrice(100);
		order.setOrderStatus("Paid");
		order.setQuantity(3);
		order.setSavetime("12-08-2002");
		order.setTotalAmount(300);
		
		when(oDao.save(order)).thenReturn(order);
	
		assertEquals(order, userService.saveOrder(order));
		
	}
	
	
}
