package com.food.DAOimplement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.food.DAO.OrderHistoryDAO;
import com.food.model.OrderHistory;

public class OrderHistoryDAOImp  implements OrderHistoryDAO{
		String url = "jdbc:mysql://localhost:3306/online_foods_delivery";
		String userName = "root";
		String pw = "root";
		Connection connection = null;
		String insertionQuery = "INSERT INTO orderhistory(status, order_date, total_amount) VALUES(?,?,?)";
		String deleteQuery = "DELETE FROM orderhistory WHERE orderhistory_Id = ?";
		String selectQuery = "SELECT * FROM orderhistory";
		String retreiveQuery ="SELECT * FROM orderhistory WHERE orderhistory_Id = ?";
		String updateQuery = "UPDATE orderhistory SET status=?, order_date=?, total_amount=? WHERE orderhistory_Id=?";
		PreparedStatement statement = null;
		OrderHistory orderHistory = null;
		ResultSet res = null; 
		
		public OrderHistoryDAOImp() 
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, userName, pw);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	@Override
	public void addOrderHistory(OrderHistory orderhistory) {
		try 
		{
			statement = connection.prepareStatement(insertionQuery);
			statement.setString(1,orderHistory.getStatus());
			statement.setDate(2, new Date(orderHistory.getOrderDate().getTime()));
			statement.setDouble(3, orderHistory.getTotalAmount());
			
			System.out.println("Rows affected: "+ statement.executeUpdate());
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderHistory getOrderHistory(int orderhistoryId) {
		try {
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1, orderhistoryId);
			res = statement.executeQuery();
			while(res.next())
			 {
				orderHistory = extractFromResultSet(res);
			 }
			}
		catch(Exception e){
				e.printStackTrace();
			}
			return orderHistory;
	}

	private OrderHistory extractFromResultSet(ResultSet res) {
    OrderHistory orderHistory = new OrderHistory();
		
		try {
			
			orderHistory.setOrderHistoryId(res.getInt("orderhistory_Id"));
			orderHistory.setOrderId(res.getInt("order_id"));
			orderHistory.setUserId(res.getInt("user_id"));
			orderHistory.setOrderDate(res.getDate("orderdate"));
			orderHistory.setTotalAmount(res.getDouble("totalamount"));
			orderHistory.setStatus(res.getString("status"));
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return orderHistory;
	}
	
	@Override
	public void updateOrderHistory(OrderHistory orderhistory) {
		try 
		{	
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1, orderHistory.getStatus());
			statement.setDate(2, new Date(orderHistory.getOrderDate().getTime()));
			statement.setDouble(3, orderHistory.getTotalAmount());
			statement.setInt(4, orderHistory.getOrderId());
			
			System.out.println("row affected " + statement.executeUpdate());		
		} 	
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void deleteOrderHistory(int orderhistory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderHistory> getAllOrderHistory(int userId) {
		// TODO Auto-generated method stub
		return null;
	}	
}
