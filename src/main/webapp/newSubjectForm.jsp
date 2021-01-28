<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Subject</title>
</head>
<body>
	<div style="text-align: center">
		<h1>New Subject</h1>
		<form action="" method="post">
			<label for="name">Name:</label>
			<input type="text" id="name" name="name">
			<br><br>
			<label for="code">Code:</label>
			<input type="text" id="code" name="code">
			<br><br>
			<input type="submit" name="register" value="Register Subject">
		</form>
		<% if (request.getParameter("register") != null) { %>
			<jsp:useBean id="subject" class="com.lopez.rafael.model.Subject" scope="request"></jsp:useBean>
			<jsp:setProperty property="*" name="subject"/>
			<jsp:forward page="registerSubject"></jsp:forward>
		<% } %>
	</div>	
</body>
</html>