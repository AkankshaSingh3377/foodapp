package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
UserDAO userDAO;
	
	@Override
		public void init() throws ServletException {
			userDAO = new UserDAOImp();
		}
	
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
	    User loggedIn=userDAO.getUser(email);
		 if(loggedIn.getPassword() != null && password.equals(loggedin.getPassword())
		{
			 HttpSession session = request.getSession(true);
			 session.setAttribute("user", loggedIn);
			 if(loggedIn.getRole().equals("USER"))
			     response.sendRedirect("/home");
			 else
				 	response.sendRedirect("/adminHome");
		 }
		 else {
			 response.sendRedirect("/login.jsp");
		 }
	}
}
