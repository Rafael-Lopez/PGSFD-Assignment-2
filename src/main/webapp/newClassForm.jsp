<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.register {border: 1px solid #000; margin: 10px; background-color: #ADD8E6;color: black;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
	.previous {border: 1px solid #000; margin: 10px; background-color: #f1f1f1;color: black;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
</style>
<meta charset="ISO-8859-1">
<title>Register Class</title>
</head>
<body>
	<div style="text-align: center">
		<h1>New Class</h1>
		
		<form action="registerClass" method="post">
			<label for="name">Name:</label>
			<input type="text" id="name" name="name">
			<br><br>
			<label for="code">Code:</label>
			<input type="text" id="code" name="code">
			<br/><br/>
			<input class="register" type="submit" name="register" value="Register Class">
		</form>
		<a href="/PGFSD-Assignment-2/dashboard.jsp" class="previous">&laquo; Back to Dashboard</a>
	</div>
</body>
</html>