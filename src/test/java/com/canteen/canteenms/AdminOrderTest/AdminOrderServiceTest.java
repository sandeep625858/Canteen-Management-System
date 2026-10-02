package com.canteen.canteenms.AdminOrderTest;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.canteen.canteenms.dao.AdminOrderListDao;
import com.canteen.canteenms.dao.AdminUserListDao;
import com.canteen.canteenms.service.AdminOrderServiceImpl;
import com.canteen.canteenms.service.AdminUserServiceImpl;


@ExtendWith(MockitoExtension.class)            
@TestMethodOrder(OrderAnnotation.class) 
public class AdminOrderServiceTest {

	@Mock
	private AdminOrderListDao adminOrderDao;
	
	private AdminOrderServiceImpl adminOrderService;
	

	@BeforeEach
	void setUp()
	{
		this.adminOrderService = new AdminOrderServiceImpl(this.adminOrderDao);
	}
	
	@Test
	void getOrderByStatusPlaced()
	{
		adminOrderService.getOrderByStatus("Placed");
		verify(adminOrderDao).getOrderDetails("Placed");
	}
	
	@Test
	void getOrderByStatusDelivered()
	{
		adminOrderService.getOrderByStatus("Delivered");
		verify(adminOrderDao).getOrderDetails("Delivered");
	}
	
	@Test
	void getOrderByStatusCancelled()
	{
		adminOrderService.getOrderByStatus("Cancelled");
		verify(adminOrderDao).getOrderDetails("Cancelled");
	}
	
	
	
	@Test
	void viewAllUserTest()
	{
		adminOrderService.getAllOrders();
		verify(adminOrderDao).getAllOrderDetails();
	}
	
}
