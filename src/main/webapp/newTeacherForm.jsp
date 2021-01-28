<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Teacher</title>
</head>
<body>
	<div style="text-align: center">
		<h1>New Teacher</h1>
		<form action="registerTeacher" method="post">
			<label for="firstName">First Name:</label>
			<input type="text" id="firstName" name="firstName">
			<br><br>
			<label for="lastName">Last Name:</label>
			<input type="text" id="lastName" name="lastName">
			<br><br>
			<label for="email">Email:</label>
			<input type="email" id="email" name="email">
			<br><br>
			<input type="submit" name="register" value="Register Teacher">
		</form>
	</div>	
</body>
</html>