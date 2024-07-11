<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order History</title>
    <link rel="stylesheet" href="OrderHistory.css">
</head>
<body>
    <div class="container">
        <h1>Order History</h1>
        <table class="order-history">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Items</th>
                    <th>Total Amount</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>#001</td>
                    <td>2023-06-28</td>
                    <td>
                        <ul>
                            <li>Pizza</li>
                            <li>Burger</li>
                        </ul>
                    </td>
                    <td>250.00</td>
                    <td>Delivered</td>
                </tr>
                <tr>
                    <td>#002</td>
                    <td>2024-06-27</td>
                    <td>
                        <ul>
                            <li>Pasta</li>
                            <li>Salad</li>
                        </ul>
                    </td>
                    <td>180.00</td>
                    <td>Delivered</td>
                </tr>
                <tr>
                    <td>#003</td>
                    <td>2024-06-30</td>
                    <td>
                        <ul>
                            <li>Noodles</li>
                            <li>Chicken Soup</li>
                        </ul>
                    </td>
                    <td>170.00</td>
                    <td>Pending</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>