<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="OrderConfirmation.css">
</head>
<body>
    <div class="container">
        <h1>Order Confirmation</h1>
        <div class="order-details">
            <p>Thank you for your purchase! Your order has been confirmed.</p>
            <h2>Order Summary</h2>
            <p><strong>Order ID:</strong> #001234</p>
            <p><strong>Date:</strong> 2024-06-30</p>
            <p><strong>Items:</strong></p>
            <ul>
                <li>Noodles - 150.00</li>
                <li>Chicken Soup - 120.00</li>
            </ul>
            <p><strong>Total Amount:</strong> 170.00</p>
            <p><strong>Status:</strong> Confirmed</p>
        </div>
        <div class="order-actions">
            <button onclick="window.print()">Print Receipt</button>
            <button onclick="window.location.href='home.html'">Back to Home</button>
        </div>
    </div>
</body>
</html>