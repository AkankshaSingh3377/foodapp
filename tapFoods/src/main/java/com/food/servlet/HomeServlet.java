package com.food.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.RestaurantDAO;
import com.food.DAOimplement.RestaurantDAOImp;
import com.food.model.Restaurant;


@SuppressWarnings("serial")
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	private RestaurantDAO restaurantDAO;
	
	public HomeServlet() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() throws ServletException {
		restaurantDAO = new RestaurantDAOImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	//fetch list of restaurant
		List<Restaurant> restaurantList = restaurantDAO.getAllRestaurants();
		
		//set the restaurant list as a request attribute
		request.setAttribute("restaurantList", restaurantList);
		
		System.out.println("__RestaurantList__");
		
		//Forword to home.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.include(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Restaurant> restaurantsList = restaurantDAO.getAllRestaurants();
		HttpSession session = request.getSession();
		session.setAttribute("restaurantsList", restaurantsList);		
		response.sendRedirect("/home.jsp");
	}
}
