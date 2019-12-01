package com.niit.dao;

import com.niit.model.OrderDetail;

public interface OrderDAO {
	public boolean payment(OrderDetail orderDetail);
	public boolean updatCartItemStatus(String username,int orderId);
}
