package com.food.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.model.User;
import com.food.DAO.UserDAO;
import com.food.DAOimplement.UserDAOImp;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO;
	
	@Override
		public void init() throws ServletException {
			userDAO = new UserDAOImp();
		}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		userDAO = new UserDAOImp(); 
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
	    
		User loggedInUser = userDAO.getUser(email);
		
	    if (loggedInUser.getPassword() != null && password.equals(loggedInUser.getPassword())) {
            // Create a session and redirect to home page
            HttpSession session = request.getSession();
            session.setAttribute("userDAO", loggedInUser);
            response.sendRedirect("home.jsp");
            
            if(loggedInUser.getRole().equals("USER")) {
            }
        } else {
            // Set an error message and forward to the login page
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
