package com.canteen.canteenms.AdminOrderTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.canteen.canteenms.dao.AdminOrderListDao;
import com.canteen.canteenms.dao.AdminUserListDao;
import com.canteen.canteenms.model.OrderList;
import com.canteen.canteenms.model.UserList;
import com.canteen.canteenms.service.AdminOrderService;
import com.canteen.canteenms.service.AdminUserService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class AdminOrderDaoTest {
	
	
	@Autowired
	private AdminOrderListDao adminOrderDao;
	
	@Autowired
	private AdminOrderService adminOrderService;
	
	
	@Test
	@Order(1)
	void getOrderDetailsTestPlaced()
	{
		List<OrderList> o = adminOrderDao.getOrderDetails("Placed");
		assertThat(o).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(2)
	void getOrderDetailsTestDelivered()
	{
		List<OrderList> o = adminOrderDao.getOrderDetails("Delivered");
		assertThat(o).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(3)
	void getOrderDetailsTestCancelled()
	{
		List<OrderList> o = adminOrderDao.getOrderDetails("Cancelled");
		assertThat(o).size().isGreaterThan(0);
	}
	
	

	@Test
	@Order(4)
	void getAllOrderDetailsTest()
	{
		List<OrderList> o = adminOrderDao.getAllOrderDetails();
		assertThat(o).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(6)
	void addOrderTest()
	{
		OrderList o = new OrderList();
		o.setFoodId(1);
		o.setUserId(1);
		o.setOrderPrice(25);
		o.setOrderStatus("Placed");
		o.setPaymentStatus("Paid");
		o.setQuantity(2);
		o.setTotalAmount(50);
		o.setSavetime("10-12-2022");
		adminOrderService.addOrder(o);
		assertNotNull(adminOrderService.getOrderById(o.getOrderId()));
	}
	
	
	@Test
	@Order(5)
	void getOrderByIdTest()
	{
		OrderList o = new OrderList();
		o.setFoodId(1);
		o.setUserId(1);
		o.setOrderPrice(25);
		o.setOrderStatus("Placed");
		o.setPaymentStatus("Paid");
		o.setQuantity(2);
		o.setTotalAmount(50);
		o.setSavetime("10-12-2022");
		adminOrderDao.save(o);
		OrderList result = adminOrderService.getOrderById(o.getOrderId());
	     assertThat(o)
         .usingRecursiveComparison()
         .isEqualTo(result);
		//assertThat(result).isEqualToComparingFieldByField(u);
	}
	
	

}
