package com.canteen.canteenms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canteen.canteenms.dao.AdminOrderListDao;
import com.canteen.canteenms.model.OrderList;

@Service
public class AdminOrderServiceImpl implements AdminOrderService{
	
	@Autowired
	AdminOrderListDao adminOrderDao;

	
	

	public AdminOrderServiceImpl(AdminOrderListDao adminOrderDao) {
		super();
		this.adminOrderDao = adminOrderDao;
	}

	@Override
	public List<OrderList> getOrderByStatus(String s) {
		List<OrderList> u = adminOrderDao.getOrderDetails(s);
		return u;
	}

	@Override
	public void addOrder(OrderList o) {
		adminOrderDao.save(o);
	}

	@Override
	public OrderList getOrderById(long id) {
		Optional<OrderList> optional = adminOrderDao.findById(id);
		OrderList order = null;
		if (optional.isPresent()) {
			order = optional.get();
		} else {
			throw new RuntimeException("Order with id " + id + " not found.");
		}
		return order;

	}

	@Override
	public List<OrderList> getAllOrders() {
		List<OrderList> o = adminOrderDao.getAllOrderDetails();
		return o;
	}


}
