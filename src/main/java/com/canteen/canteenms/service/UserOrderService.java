package com.canteen.canteenms.service;

//Required imports
import java.util.List;

import com.canteen.canteenms.model.AllOrder;


// Interface Layer which contains all the methods of the service Layer
// This interface is implemented by the User order Service Class
public interface UserOrderService {
	public List<AllOrder> getAllOrder(String userName);
	public void cancelOrder(long orderId);

}
