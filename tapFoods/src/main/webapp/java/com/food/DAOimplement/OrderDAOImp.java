package com.food.DAOimplement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderDAO;
import com.food.model.Order;

public class OrderDAOImp implements OrderDAO{
	String url = "jdbc:mysql://localhost:3306/online_food_delivery";
	String userName = "root";
	String pw ="root";
	Connection connection = null;
	String insertQuery = "INSERT INTO `order`(orderDate,totalAmount,status,paymentmethod)VALUES(?,?,?,?)";
	String deleteQuery = "DELETE FROM `user` WHERE `order_id`=?";
	String selectQuery = "SELECT * FROM `order` WHERE `order` =?";
	String retreiveQuery="SELECT * FROM `order`WHERE `orderId`=?";
	String updateQuery = "UPDATE `order` SET orderdate = ?,totalAmount = ?,status = ?,paymentmethod = ?, WHERE order_id = ?";
	PreparedStatement statement = null;
	Order order=null;
	ResultSet res=null;
	
	public OrderDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, pw);
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void addOrder(Order order) {
		try 
		{
			statement = connection.prepareStatement(insertQuery);
			statement.setDate(1, new Date(order.getOrderDate().getTime()));
			statement.setDouble(2,order.getTotalAmount());
			statement.setString(3, order.getStatus());
			statement.setString(4, order.getPaymentmethod());
			
			System.out.println("Rows affected: "+ statement.executeUpdate());
		}	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Order getOrder(int orderId) {	
		try 
		{
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1, orderId);
			ResultSet res = statement.executeQuery();
			if(res.next())
			{
				order = extractOrderFromResultSet(res);
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private Order extractOrderFromResultSet(ResultSet res) throws SQLException {
        Order order=new Order();
		
		order.setOrderId(res.getInt("orderId"));
		order.setUserId(res.getInt("restaurantId"));
		order.setOrderDate(res.getDate("orderDate"));
		order.setTotalAmount(res.getDouble("totalAmount"));
		order.setStatus(res.getString("status"));
		order.setPaymentmethod(res.getString("paymentmethod"));
		return order;
	}		

	@Override
	public void updateOrder(Order order) {
		try {
			statement=connection.prepareStatement(updateQuery);
			

			statement.setDate(1, new Date(order.getOrderDate().getTime()));
			statement.setDouble(2, order.getTotalAmount());
			statement.setString(3, order.getStatus());
			statement.setString(4, order.getPaymentmethod());
			statement.setInt(5, order.getOrderId());
			
			System.out.println("row affected " + statement.executeUpdate());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int orderId) {
		try {
			statement=connection.prepareStatement(deleteQuery);
			statement.setInt(1, orderId);
			System.out.println(statement.executeUpdate());
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Order> getAllOrder() {
		ArrayList<Order> al=new ArrayList<Order>();
		try {
			statement=connection.prepareStatement(selectQuery);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				order=extractOrderFromResultSet(res);
				al.add(order);
			  } 
			}catch(SQLException e) {
				e.printStackTrace();
				}
		return al;
	}
}
