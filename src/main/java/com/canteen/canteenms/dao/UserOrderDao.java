package com.canteen.canteenms.dao;

import java.util.List;

// Required Imports
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.canteen.canteenms.model.OrderList;

//Extending the Interface of Jpa to use its inbuilt database Operation for User Order Class 
public interface UserOrderDao extends JpaRepository<OrderList, Long>{

	@Query("select o from OrderList o where o.orderStatus!='OptOut'")
	List<OrderList> findAllOrder();

}
