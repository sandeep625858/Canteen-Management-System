package com.canteen.canteenms.service;

import java.util.List;

import com.canteen.canteenms.model.OrderList;

public interface ReportService {
	
	List<OrderList> findAllOrder(long userId);
	
}
