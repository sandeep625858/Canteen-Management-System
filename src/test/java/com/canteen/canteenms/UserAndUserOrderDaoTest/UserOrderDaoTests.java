package com.canteen.canteenms.UserAndUserOrderDaoTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.canteen.canteenms.dao.OrderDao;
import com.canteen.canteenms.model.OrderList;

@SpringBootTest
public class UserOrderDaoTests {
	
	 @Autowired
	  OrderDao orderRepository;
	 
	 @Test
	 public void orderReposTest() {
		 
		 OrderList orderList = new OrderList(101,1,2,"22-01-2023",2,200,"Placed",400,"Unpaid");
		 
		 
		 orderRepository.save(orderList);
		 
		 
		   Iterable<OrderList> orders = orderRepository.findAll();
		   Assertions.assertThat(orders).extracting(OrderList :: getOrderStatus).containsOnly("Placed");
		 
		   orderRepository.deleteAll();
		   Assertions.assertThat(orderRepository.findAll()).isEmpty();
	 }
	
	

}
