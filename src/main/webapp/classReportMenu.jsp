<%@page import="com.lopez.rafael.model.Class"%>
<%@page import="java.util.List"%>
<%@page import="com.lopez.rafael.service.ClassService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Class Report</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Class Report</h1>
		
		<%! ClassService classService = new ClassService(); %>  
		<% List<Class> classList = classService.getClassList();
		   request.setAttribute("classList", classList);
		%>
		<form action="classReport" method="post">
			<label for="classId">Select a class:</label>
			<select id="classId" name="classId">
				<c:forEach items="${classList}" var="item">
				    <option value="${item.id}">${item.name}</option>
				</c:forEach>			
			</select>
			<br/><br/>
			<input class="register" type="submit" name="register" value="View Report">
		</form>
		<a href="/PGFSD-Assignment-2/dashboard.jsp" class="previous">&laquo; Back to Dashboard</a>
	</div>	
</body>
</html>