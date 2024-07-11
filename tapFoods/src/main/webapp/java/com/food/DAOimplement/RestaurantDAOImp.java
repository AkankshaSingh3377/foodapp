package com.food.DAOimplement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.RestaurantDAO;
import com.food.model.Restaurant;

public class RestaurantDAOImp implements RestaurantDAO{
	String url = "jdbc:mysql://localhost:3306/online_food_delivery";
	String userName = "root";
	String pw ="root";
	Connection connection = null;
	String insertQuery = "INSERT INTO `restaurant`(name,cuisinetype,deliverytime,address,rating,isActive)VALUES(?,?,?,?,?,?)";
	String deleteQuery = "DELETE FROM `user` WHERE `restaurant_id`=?";
	String selectQuery = "SELECT * FROM `restaurant` WHERE `restaurant_id` =?";
	String retreiveQuery="SELECT * FROM `restaurant`";
	String updateQuery = "UPDATE `restaurant` SET name = ? ,cuisinetype = ?,deliverytime = ?,address = ?,rating = ?,isActive = ? WHERE restaurant_id = ?";
	PreparedStatement statement = null;
	Restaurant restaurant=null;
	
	public RestaurantDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, pw);
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void addRestaurant(Restaurant restaurant) {
		try 
		{
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, restaurant.getName());
			statement.setString(2, restaurant.getCusineType());
			statement.setInt(3, restaurant.getDeliveryTime());
			statement.setString(4, restaurant.getAddress());
			statement.setDouble(5, restaurant.getRating());
			statement.setBoolean(6, restaurant.isActive());
			
			System.out.println("Row Affected "+ statement.executeUpdate());
		}	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public Restaurant getRestaurant(int restaurant_id) {
		try 
		{
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1, restaurant_id);
			ResultSet res = statement.executeQuery();
			
			if(res.next())
			{
				restaurant = extractRestaurantFromResultSet(res);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return restaurant;
	}
	private Restaurant extractRestaurantFromResultSet(ResultSet res) throws SQLException {
		Restaurant restaurant=new Restaurant();
		
		restaurant.setName(res.getString("name"));
		restaurant.setCusineType(res.getString("cuisinetype"));
		restaurant.setDeliveryTime(res.getInt("deliverytime"));
		restaurant.setAddress(res.getString("address"));
		restaurant.setAdminUserId(res.getInt("adminuser_id"));
		restaurant.setRating(res.getDouble("rating"));
		restaurant.setActive(res.getBoolean("isActive"));
		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		try {
			statement=connection.prepareStatement(updateQuery);
			statement.setString(1, restaurant.getName());
			statement.setString(2, restaurant.getCusineType());
			statement.setInt(3, restaurant.getDeliveryTime());
			statement.setString(4, restaurant.getAddress());
			statement.setInt(5, restaurant.getAdminUserId());
			statement.setDouble(6, restaurant.getRating());
			statement.setBoolean(7, restaurant.isActive());
			
			statement.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int restaurant_id) {
		try {
			statement=connection.prepareStatement(deleteQuery);
			statement.setInt(1, restaurant_id);
			statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() 
	{
		ArrayList<Restaurant> restaurants= new ArrayList<>();
		try {
			statement=connection.prepareStatement(retreiveQuery);
			ResultSet res=statement.executeQuery();
			
			while(res.next()) {
				restaurant = extractRestaurantFromResultSet(res);
				restaurants.add(restaurant);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return restaurants;
	}	
}
