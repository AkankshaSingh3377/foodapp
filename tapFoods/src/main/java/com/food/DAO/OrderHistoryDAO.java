package com.food.DAO;

import java.util.List;

import com.food.model.OrderHistory;

public interface OrderHistoryDAO 
{
	
	void addOrderHistory(OrderHistory orderhistory);
	OrderHistory getOrderHistory(int orderhistory);
	void updateOrderHistory(OrderHistory orderhistory);
	void deleteOrderHistory(int orderhistory);
	List<OrderHistory> getAllOrderHistory(int userId);
}
