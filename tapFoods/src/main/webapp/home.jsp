<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.User, com.food.model.Restaurant" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Order My Food | MyFood.com</title>
  <link rel="stylesheet" href="home.css">
  <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@500&family=Bree+Serif&display=swap" rel="stylesheet">
</head>

<body>
  <!-- navigation bar -->
  <nav id="navbar">
    <div id="logo">
      <img src="https://thatsuman.github.io/web-dev-projects/SafeMeal/assets/chef_2.svg" alt="MyFood.com" width="80px" height="80px">
    </div>
    <ul>
      <li class="item"><a href="#home">Home</a></li>
      <li class="item"><a href="#contact">Contact Us</a></li>
      
      <%
      	User user = (User) session.getAttribute("userDao");
      	if(user != null){
      %>
      	<span class="welcome">Welcome,<%=user.getUsername() %>!
      	</span>
      	<li><a href="viewChart.jsp">View Chart</a></li>
      	<li><a href="orderHistory.jsp">Order History</a></li>
      	<li><a href="profile.jsp">Profile</a></li>
      	
      	<%
      	} else {
      	%>
      		<li><a href="login.jsp" class="login-btn">Login</a></li>
      		<li><a href="register.jsp" class="register-btn">Register</a></li>
      	<%
      	    }
      	%>	
    </ul>
  </nav>
  <!-- home section -->
  <section id="home">
    <h1 class="h-primary">Welcome to Food World </h1>
   
	<li><a href="restaurant.jsp" class="btn">Order Now</a></li>
	
	</section>
	<section class="restaurant-list">
        <%
            List<Restaurant> restaurantList = (List<Restaurant>) request.getAttribute("restaurantList");
            if (restaurantList != null && !restaurantList.isEmpty()) {
                for (Restaurant restaurant : restaurantList) {
        %>
                    <div class="restaurant">
                        <img src="image/<%= restaurant.getImagePath() %>" alt="Image of <%= restaurant.getName() %>">
                        <h3><%= restaurant.getName() %></h3>
                        <p><%= restaurant.getCusineType() %> - <%= restaurant.getDeliveryTime() %> mins</p>
                        <a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>">View Menu</a>
                    </div>
        <%
                }
            } else {
        %>
                <p>No restaurant available at the moment.</p>
        <%
            }
        %>
    </section>
	
  <footer>
    <div class="center">
      Copyright &copy; www.MyFood.com. All rights reserved!
    </div>
  </footer>
</body>
</html>
