package com.food.DAO;

import java.util.List;

import com.food.model.OrderItem;

public interface OrderItemDAO
{
		void addOrderItem(OrderItem orderItem);
		OrderItemDAO getOrderItem(int orderItemId);
		void updateOrderItem(OrderItem orderItem);
		void deleteOrderItem(int orderItemId);
		List<OrderItem> getOrderItemByOrder(int orderId);
}
