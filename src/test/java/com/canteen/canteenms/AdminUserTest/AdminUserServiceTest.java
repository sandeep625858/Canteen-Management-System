package com.canteen.canteenms.AdminUserTest;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;

import com.canteen.canteenms.dao.AdminUserListDao;
import com.canteen.canteenms.service.AdminUserServiceImpl;

@ExtendWith(MockitoExtension.class)            
@TestMethodOrder(OrderAnnotation.class)        
public class AdminUserServiceTest {
	
	
	@Mock
	private AdminUserListDao adminUserDao;
	
	private AdminUserServiceImpl adminUserService;
	

	@BeforeEach
	void setUp()
	{
		this.adminUserService = new AdminUserServiceImpl(this.adminUserDao);
	}
	
	@Test
	void getActiveORInactiveUserTestActive()
	{
		adminUserService.getActiveORInactiveUser("active");
		verify(adminUserDao).getAllActiveOrInactiveUsers("active");
	}
	
	@Test
	void getActiveORInactiveUserTestInactive()
	{
		adminUserService.getActiveORInactiveUser("inactive");
		verify(adminUserDao).getAllActiveOrInactiveUsers("inactive");
	}
	
	
	@Test
	void viewAllUserTest()
	{
		adminUserService.viewAllUser();
		verify(adminUserDao).findAllroles();
	}
}
