package com.food.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.UserDAO;
import com.food.DAOimplement.UserDAOImp;
import com.food.model.User;


@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO;
	
	public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@Override
		public void init() throws ServletException {
		userDAO = new UserDAOImp();
		}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username, email, password, cpassword, address, role; 
		
		username=request.getParameter("username");
		email=request.getParameter("email");
		password=request.getParameter("password");
		cpassword=request.getParameter("cpassword");
		address=request.getParameter("address");
		role=request.getParameter("role");
		
		if (!password.equals(cpassword)) 
		{
            int x = userDAO.addUser(new User(0, username, cpassword, email, address, role));
            //here we are giving an user object to the addUSer method with the help of the constructor
            if(x != 0) {
            	response.sendRedirect("login.jsp");
            }
            else {
            	response.sendRedirect("failureRegistration.jsp");
            }
        }
		else {
			response.sendRedirect("passwordError.jsp");
		}
	}			
}	
			
		
		
		
		
		