<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %> 

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Register Page </title>
<link rel="register" href="register.html">
<link rel="stylesheet" href="register.css">
<body>
  <div class="register-container">
    <form class="register-form">
      <h2>Register User</h2>
      <from action="register" method = "POST">
      
      
      <label for="username">Username</label>
      <input type="text" id="username" name="username" required><br><br>
      
      <label for="email">Email</label>
      <input type="email" id="email" name="email" required><br><br>
      
      <label for="password">Password</label>
      <input type="password" id="password" name="password" required><br><br>
      
      <label for="confirm-password">Confirm Password</label>
      <input type="password" id="confirm-password" name="confirm-password" required><br><br>
      
      <label for="role">Role</label>
      <input type="role" id="role" name="role" required><br><br>
         
      <button type="submit">Register me</button>
    </form>
  </div>
  </body>
  </head>
  </html>