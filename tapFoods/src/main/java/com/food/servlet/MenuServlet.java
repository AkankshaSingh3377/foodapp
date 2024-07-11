package com.food.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.MenuDAO;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MenuDAO menuDAO;

    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
    	System.out.println(restaurantId);
    	List<MenuServlet> menuList = menuDAO.getAllMenuByRestaurantId(restaurantId);
    	req.setAttribute("menuList", menuList);
    	System.out.println("menu working ");
    	RequestDispatcher dispatcher = req.getRequestDispatcher("menu.jsp");
    	dispatcher.include(req, resp);
    	
    }
}


    
