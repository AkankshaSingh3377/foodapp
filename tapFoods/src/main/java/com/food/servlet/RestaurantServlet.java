package com.food.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.RestaurantDAO;
import com.food.DAOimplement.RestaurantDAOImp;
import com.food.model.Restaurant;


@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestaurantDAO restaurantDAO;
	
    public RestaurantServlet() {
    }
    
    @Override
    	public void init() throws ServletException {
    		restaurantDAO = new RestaurantDAOImp();
    	}
    	
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		List<Restaurant> restaurantList = restaurantDAO.getAllRestaurants();
    		req.setAttribute("restaurantList", restaurantList);
    		System.out.println("request working");
    		
    		RequestDispatcher rd = req.getRequestDispatcher("restaurant.jsp");
    		rd.include(req, resp);		
    	}
}
