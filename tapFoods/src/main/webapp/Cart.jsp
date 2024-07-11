<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.Map, com.food.model.Cart,com.food.model.Cartitem"%>

<html>
<head>
<title>Shopping Cart</title>
<link rel="stylesheet" href="css/cart.css">
</head>
<body>
	<h1>Your Shopping Cart</h1>
	<div class="cart-items">
		<%
		p

				//HttpSession session = request.getSession();
				Cart cart = (Cart) session.getAttribute("cart");
				if (cart != null && !cart.getItems().isEmpty()) {
			for (Cartitem item : cart.getItems().values()) {
		%>
		<div class="cart-item">
			<h3><%=item.getName()%></h3>
			<p>
				&#x20B9;
				<%=item.getPrice()%></p>
			<form action="cart" method="post">
				<input type="hidden" name="itemId" value="<%=item.getItemId()%>">
				<label>Quantity: <input type="number" name="quantity"
					value="<%=item.getQuantity()%>" min="1">
				</label> <input type="submit" name="action" value="update"
					class="update-btn"> <input type="submit" name="action"
					value="remove" class="remove-btn">
			</form>
		</div>

		<%
		}

		} else {
		%>
		<p>Your cart is empty.</p>
		<%
		}
		%>


		<%-- Add More Items Button --%>
		<a href="menu?restaurantId=<%=session.getAttribute("resturantId") %>" class="btn add-more-items-btn">Add More Items</a>

		<%-- Proceed to Checkout Button --%>
		<%
		if (session.getAttribute("cart") != null) {
		%>
		<form action="checkout.jsp" method="post">
			<input type="submit" value="Proceed to Checkout"
				class="btn proceed-to-checkout-btn">
		</form>
		<%
		}
		%>


	</div>
</body>
</html>