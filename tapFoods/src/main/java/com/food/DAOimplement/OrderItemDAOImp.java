package com.food.DAOimplement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderItemDAO;
import com.food.model.OrderItem;

public class OrderItemDAOImp implements OrderItemDAO
{
	String url = "jdbc:mysql://localhost:3306/online_food_delivery";
	String userName = "root";
	String pw ="root";
	Connection connection = null;
	PreparedStatement statement = null;
	OrderItem orderItem=null;
	String insertQuery = "INSERT INTO `orderItem`(orderitem_Id,order_id,menu_id,quantity,itemtotal) VALUES(?,?,?,?,?)";
	String deleteQuery = "DELETE FROM `user` WHERE `order_id`=?";
	String selectQuery = "SELECT * FROM `orderItem` WHERE `order_id` =?";
	String retreiveQuery="SELECT * FROM `orderItem`";
	String updateQuery = "UPDATE `orderItem` SET orderitem_Id = ? ,order_id = ?,menu_id = ?,quantity = ?,itemtotal = ? WHERE orderitem_id = ?";
	
	public OrderItemDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, pw);
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void addOrderItem(OrderItem orderItem) {
	try
	{
		statement = connection.prepareStatement(insertQuery);
		statement.setInt(1, orderItem.getOrderItem());
		statement.setInt(2, orderItem.getOrderId());
		statement.setInt(3, orderItem.getMenuId());
		statement.setInt(4, orderItem.getQuantity());
		statement.setDouble(5, orderItem.getItemTotal());
		statement.executeUpdate();
	}	
	catch(SQLException e)
	{
		e.printStackTrace();
	}
 }
	@Override
	public OrderItemDAO getOrderItem(int orderItemId) {
		try 
		{
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1, orderItemId);
			ResultSet res = statement.executeQuery();
			if(res.next())
			{
				orderItem = extractOrderItemFromResultSet(res);
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private OrderItem extractOrderItemFromResultSet(ResultSet res) throws SQLException{
	OrderItem orderItem=new OrderItem();
		
		orderItem.setOrderItem(res.getInt("orderItem"));
		orderItem.setOrderId(res.getInt("order_id"));
		orderItem.setMenuId(res.getInt("menu_id"));
		orderItem.setQuantity(res.getInt("quantity"));
		orderItem.setItemTotal(res.getDouble("itemTotal"));
		
		return null;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
				try {
					statement=connection.prepareStatement(updateQuery);
					statement.setInt(1, orderItem.getOrderItem());
					statement.setInt(2, orderItem.getOrderId());
					statement.setInt(3, orderItem.getMenuId());
					statement.setInt(4, orderItem.getQuantity());
					statement.setDouble(5, orderItem.getItemTotal());
					
					statement.executeUpdate();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}		
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		try {
			statement=connection.prepareStatement(deleteQuery);
			statement.setInt(1, orderItemId);
			statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderItem> getOrderItemByOrder(int orderId) 
	{
		orderItem = new OrderItem();
		ArrayList<OrderItem> arrayList = new ArrayList<OrderItem>();
		try {
			statement=connection.prepareStatement(retreiveQuery);
			ResultSet res=statement.executeQuery();
			
			while(res.next()) {
				orderItem = extractOrderItemFromResultSet(res);
				arrayList.add(orderItem);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
}
