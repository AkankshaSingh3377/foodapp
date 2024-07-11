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
import com.food.servlet.RestaurantServlet;

public class RestaurantDAOImp implements RestaurantDAO
{
	Connection connection = null;
	
	public RestaurantDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery", "root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		String sql = "INSERT INTO `Restaurant`(`Name`,`CuisineType`,`DeliveryTime`,"
				+ "`Address`,`Rating`,`IsActive`) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
		//	pstmt.setInt(5, restaurant.getAdminUserId());
			pstmt.setDouble(5, restaurant.getRating());
			pstmt.setBoolean(6, restaurant.isActive());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	@Override
	public Restaurant getRestaurant(int restaurantId) {
		String sql = "SELECT * FROM `Restaurant` WHERE `RestaurantID` = ?";
		Restaurant restaurant = null;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, restaurantId);
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next())
			{
				restaurant = extractRestaurantFromResultSet(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return restaurant;
	}

	private Restaurant extractRestaurantFromResultSet(ResultSet res) throws SQLException {
		
		
		Restaurant restaurant = new Restaurant();
		
		restaurant.setRestaurantId(res.getInt("RestaurantID"));
		restaurant.setName(res.getString("Name"));
		restaurant.setCuisineType(res.getString("CuisineType"));
		restaurant.setDeliveryTime(res.getInt("DeliveryTime"));
		restaurant.setAddress(res.getString("Address"));
		restaurant.setAdminUserId(res.getInt("AdminUserID"));
		restaurant.setRating(res.getDouble("Rating"));
		restaurant.setActive(res.getBoolean("IsActive"));
		restaurant.setImagePath(res.getString("ImagePath"));
		
		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		 String sql = "UPDATE Restaurant SET Name = ?, CuisineType = ?, DeliveryTime = ?, Address = ?,  "
		 		+ "Rating = ?, IsActive = ? WHERE RestaurantID = ?";
		 
		 try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
		//	pstmt.setInt(5, restaurant.getAdminUserId());
			pstmt.setDouble(5, restaurant.getRating());
			pstmt.setBoolean(6, restaurant.isActive());
			pstmt.setInt(7, restaurant.getRestaurantId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		String sql = "DELETE FROM `Restaurant` WHERE `RestaurantID` = ?";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, restaurantId);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		String sql = "SELECT * FROM `Restaurant`";
		
		ArrayList<Restaurant> restaurants = new ArrayList<>();
		Restaurant restaurant = null;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next())
			{
				restaurant = extractRestaurantFromResultSet(res);
				restaurants.add(restaurant);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return restaurants;
	}

	@Override
	public List<RestaurantServlet> getAllRestaurant() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
