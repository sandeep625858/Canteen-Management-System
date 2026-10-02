package com.canteen.canteenms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canteen.canteenms.dao.OrderDao;
import com.canteen.canteenms.model.OrderList;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private OrderDao oDao;

	@Override
	public List<OrderList> findAllOrder(long userId) {
		
		return this.oDao.findAllOrder(userId);
		
	}

}
