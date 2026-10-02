package com.canteen.canteenms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.canteen.canteenms.model.OrderList;

import javax.transaction.Transactional;



public interface OrderDao extends CrudRepository<OrderList, Long> {
	
	@Query("select o from OrderList o where o.paymentStatus='Pending' and o.userId=:userId and o.orderStatus !='Cancelled'")
	List<OrderList> findAllUnpaid(@Param("userId") long userId);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("Update OrderList o set o.paymentStatus='Paid' where o.userId=:userId and o.paymentStatus='Pending'")
	void updateAllOrder(@Param("userId") long userId);
	
	@Query("select o from OrderList o where o.orderStatus !='Cancelled' and o.userId=:userId")
	List<OrderList> findAllOrder(long userId);
	
	
	List<OrderList> findByUserId(long userId);

	
	OrderList findByUserId(long l);

}
