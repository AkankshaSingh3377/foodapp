<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="login" href="login.html">
    <link rel="stylesheet" href="login.css">
    
    <body>
        <div class="container">
            <div class="login-container">
                
                <form action="login" method="POST">
                    <h2>Login</h2>
                    <input type="email" placeholder="Email" required><br>
                    <input type="password" placeholder="Password" required><br><br>
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
        <script src="scripts.js"></script>
    </body>
</head>
</html>
