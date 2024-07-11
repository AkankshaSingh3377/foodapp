<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Out</title>
<link rel="stylesheet" href="Checkout.css">
</head>
<body>
	<div class="container">
        <h2>Checkout</h2>
    <form action="checkout" method="post">
        <label for="address">Delivery Address:</label>
        <textarea id="address" name="address" required></textarea><br><br>
        
        <label for="paymentMethod">Payment Method:</label>
        <select id="paymentMethod" name="paymentMethod">
            <option value="Credit Card">Credit Card</option>
            <option value="Debit Card">Debit Card</option>
            <option value="UPI">UPI</option>
            <option value="Cash on Delivery">Cash on Delivery</option>
        </select><br><br>
        <input type="submit" value="Place Order">
    </form>
    </div>
</body>
</html>