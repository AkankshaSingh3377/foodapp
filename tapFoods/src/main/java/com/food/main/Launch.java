package com.food.main;

import java.util.List;
import java.util.Scanner;

import com.food.DAOimplement.RestaurantDAOImp;
import com.food.DAOimplement.UserDAOImp;
import com.food.model.Restaurant;
import com.food.model.User;

public class Launch {
	
	public static void main(String[] args) 
	{
//		adduser
//		User u=new User(3,"Abhi","abhi@123","abhi@gmail.com","BTM2","customer");
//		UserDAOImp ud=new UserDAOImp();
//		ud.addUser(u);
//	
//		getUser
//		UserDAOImp u=new UserDAOImp();
//		System.out.println("Enter the user id: ");
//		User user = u.getUser(scan.nextInt());
//		System.out.println(user);
			
		//update user
//		User u1 =new User(3,"rajkumar","raj@123","raj@gmail.com","HSR","customer");
//		UserDAOImp ud = new UserDAOImp();
//		ud.updateUser(u1);		
		
//		//delete row
//		UserDAOImp u = new UserDAOImp();
//		System.out.println("Enter the user id for deletion:");
//		u.deleteUser(scan.nextInt());
		
		//addRestaurant
//		Restaurant restaurant=new Restaurant("Grand Dhillon","MultiCuisine",10,"Nehru Nagar",4.5,true);
//		RestaurantDAOImp r=new RestaurantDAOImp();
//		r.addRestaurant(restaurant);
		
		//getRestaurant
		RestaurantDAOImp r=new RestaurantDAOImp();
		Restaurant restaurant= r.getRestaurant(1);
		System.out.println(restaurant);
		
		//updateRestaurant
//		RestaurantDAOImp r=new RestaurantDAOImp();
//		Restaurant restaurant=new Restaurant("Ghar ka Khana","South Indian",30,"HSR",4.5,true);
//		r.updateRestaurant(restaurant);
		
		//deleteRestaurant
//		RestaurantDAOImp r=new RestaurantDAOImp();
//		r.deleteRestaurant(1);
		
		//getList
//		RestaurantDAOImp r=new RestaurantDAOImp();
//		List<Restaurant> allRestaurants= r.getAllRestaurants();
//		for(Restaurant res : allRestaurants) {
//			System.out.println(res);
		}
   }
