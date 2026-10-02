package com.canteen.canteenms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.canteen.canteenms.model.OrderList;


@Repository
public interface AdminOrderListDao extends JpaRepository<OrderList,Long> {
	
	@Query(value="SELECT * FROM Order_List WHERE order_Status like(?1)",nativeQuery=true)
	public List<OrderList> getOrderDetails(String status);
	
	
	@Query(value="SELECT * FROM Order_List where order_Status != 'OptOut' order by order_Status DESC",nativeQuery=true)
	public List<OrderList> getAllOrderDetails();

}
