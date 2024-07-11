<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8">
	<meta name="viewport" content="width=device-widtg, initial-scale=1.0">
	<title>Food Menu</title>
	<link rel="stylesheet" href="stylemenu.css">
	
</head>	
	<body class = "menu-body">
	<header class="menu-header">
	<div class="logo">
</div>
	<div class="location-search">
	<a class=""></a>
	</div>
</header>
<section class="menu-list">
        <h2>&nbsp;&nbsp;&nbsp; Featured Menu</h2>
        <div class="menus">
            <%
            p

              List<MenuServlet> menuList = (List<MenuServlet>) request.getAttribute("menuList");
               if (menuList != null) {
                 for (MenuServlet m : menuList) {
            %>
                <div class="restaurant">
                    <img src="<%= m.getImgPath() %>" alt="<%= m.getItemName() %>">
                    <h3><%= m.getItemName() %></h3>
                    <p><%= m.getDescription() %> - <%= m.getPrice() %> Rs</p>
                    <a href="cart?menuId=<%= m.getMenuId() %>">Add to cart</a>
                </div>
            <%
                    }
                } else {
            %>
                <p>No menu items available at the moment.</p>
            <%
                }
            %>
        </div>
    </section>
</body>
</html>