<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "java.util.List,com.food.model.Restaurant,com.food.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant List</title>
<link rel="stylesheet" href="restaurant.css">
<link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@500&family=Bree+Serif&display=swap" rel="stylesheet">
</head>
<body>
 <!-- Navigation bar -->
    <nav id="navbar">
        <div id="logo">
            <img src="https://thatsuman.github.io/web-dev-projects/SafeMeal/assets/chef_2.svg" alt="MyFood.com" width="80px" height="80px">
        </div>
        <header>
            <nav>
                <a href="home">Home</a>
                <%
                User loggedInUser = (User) session.getAttribute("loggedInUser");
                if (loggedInUser != null) {
                %>
                    <span>Welcome, <%= loggedInUser.getUsername() %>!</span>
                    <a href="cart">View Cart</a>
                    <a href="orderHistory">View Order History</a>
                    <a href="logout">Logout</a>
                <%
                } else {
                %>
                    <a href="Login.jsp">Login</a>
                    <a href="register.jsp">Register</a>
                <%
                }
                %>
            </nav>
        </header>
    </nav>
    
    <footer>
        <p>&copy; www.MyFood.com. All rights reserved!</p>
    </footer>
</body>
</html>