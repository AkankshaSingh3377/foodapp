package com.food.DAOimplement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.UserDAO;
import com.food.model.User;

public class UserDAOImp implements UserDAO{
	String url = "jdbc:mysql://localhost:3306/online_food_delivery";
	String userName = "root";
	String pw ="root";
	Connection connection = null;
	String insertQuery = "INSERT INTO `user`(userId,userName,password,email,address,role)" + "VALUES(?,?,?,?,?,?)";
	String deleteQuery = "DELETE FROM `user` WHERE `userId`=?";
	String selectQuery = "SELECT * FROM `user`";
	String retreiveQuery = "SELECT * FROM `user` WHERE `email` = ?";
	String updateQuery = "UPDATE `user` SET userName = ? ,password = ?,email = ?,address = ?,role=? WHERE userId=?";
	PreparedStatement statement = null;
	User user = null;
	public UserDAOImp()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, pw);
		}		
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
	
	@Override
	public int addUser(User user) {
		try 
		{
			statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, user.getUserId());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getAddress());
			statement.setString(6, user.getRole());
			
			return statement.executeUpdate();
		}	
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}	
	}

	@Override
	public User getUser(String email) {
		try 
		{
			statement = connection.prepareStatement(retreiveQuery);
			statement.setString(1, email);
			ResultSet res = statement.executeQuery();
			if(res.next())
			{
				user = extractUserFromResultSet(res);
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	private User extractUserFromResultSet(ResultSet res) throws SQLException 
	{
		User user = new User();
		user.setUserId(res.getInt("userId"));
		user.setUsername(res.getString("userName"));
		user.setPassword(res.getString("password"));
		user.setEmail(res.getString("email"));
		user.setAddress(res.getString("address"));
		user.setRole(res.getString("role"));
		
		return user;
	}
	@Override
	public void updateUser(User user) {
		try 
		{
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getRole());
			statement.setInt(6,user.getUserId());
			
			statement.executeUpdate();
		} 		
		catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteUser(int userId) {
		try
		{
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, userId);
			statement.executeUpdate();
		} 		
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<User> getAllUser() {
		List<User> al= new ArrayList<User>();
		try {
			statement=connection.prepareStatement(selectQuery);
			ResultSet res= statement.executeQuery();
			while(res.next()) {
				user=extractUserFromResultSet(res);
				al.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}		
}
