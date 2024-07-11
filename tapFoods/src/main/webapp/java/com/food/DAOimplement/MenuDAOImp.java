package com.food.DAOimplement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.MenuDAO;
import com.food.model.Menu;

public class MenuDAOImp implements MenuDAO{
	
	String url = "jdbc:mysql://localhost:3306/online_foods_delivery";
	String userName = "root";
	String pw = "root";
	Connection connection = null;
	String insertQuery = "INSERT INTO menu(menuId,itemName, price, isAvailable) VALUES(?,?,?,?)";
	String deleteQuery = "DELETE FROM menu WHERE menuId = ?";
	String selectQuery = "SELECT * FROM menu";
	String retreiveQuery ="SELECT * FROM menu WHERE menuId = ?";
	String updateQuery = "UPDATE menu SET itemName=?, description=?, price=?, isAvailable=? WHERE menuId=?";
	PreparedStatement statement = null;
	Menu menu = null;
	
	public MenuDAOImp() {
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
	public void addMenu(Menu menu) {
		try {
			statement = connection.prepareStatement(insertQuery);
			
			statement.setInt(1,menu.getMenuId());
			statement.setString(2,menu.getItemName());
			statement.setDouble(3,menu.getPrice());
			statement.setBoolean(4, menu.isAvailable());
			
			System.out.println("row affected " + statement.executeUpdate());		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Menu getMenu(int menuId) {
		try {
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1, menuId);
			ResultSet res = statement.executeQuery();
			if(res.next())
			{
				menu = extractFromResultSet(res);
				
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return menu;
	}
		private Menu extractFromResultSet(ResultSet res)
		{	
			try
			{
				Menu menu = new Menu();
				menu.setRestaurantId(res.getInt("restaurantId"));
				menu.setItemName(res.getString("itemName"));
				menu.setDescription(res.getString("description"));
				menu.setPrice(res.getDouble("price"));
				menu.setAvailable(res.getBoolean("isAvailable"));
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			return menu;
	}

	@Override
	public void updateMenu(Menu menu) {
		try {
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1,menu.getItemName());
			statement.setString(2, menu.getDescription());
			statement.setDouble(3, menu.getPrice());
			statement.setBoolean(4, menu.isAvailable());
			statement.setInt(5, menu.getMenuId());
			System.out.println("Rows effected: " + statement.executeUpdate());
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteMenu(int menuId) {
		try 
		{
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, menuId);
			System.out.println("row effected: " + statement.executeUpdate());
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Menu> getAllMenuByRestaurant() {
		ArrayList <Menu>al = new ArrayList<Menu>();
		try 
		{
			statement = connection.prepareStatement(selectQuery);
			ResultSet res = statement.executeQuery();
			while(res.next())
			{
				menu = extractFromResultSet(res);
				al.add(menu);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
}
