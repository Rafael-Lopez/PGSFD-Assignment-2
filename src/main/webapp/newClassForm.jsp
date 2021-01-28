<%@page import="com.lopez.rafael.service.SubjectService"%>
<%@page import="com.lopez.rafael.model.Subject"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Class</title>
</head>
<body>
	<div style="text-align: center">
		<h1>New Class</h1>
		
		<%! SubjectService subjectService = new SubjectService(); %>  
		<% List<Subject> subjectList = subjectService.getSubjectList();
		   request.setAttribute("subjectList", subjectList);
		%>
		<form action="registerClass" method="post">
			<label for="name">Name:</label>
			<input type="text" id="name" name="name">
			<br><br>
			<label for="code">Code:</label>
			<input type="text" id="code" name="code">
			<br><br>
			<label for="subjectId">Subject:</label>
			<select id="subjectId" name="subjectId">
				<c:forEach items="${subjectList}" var="subject">
				    <option value="${subject.id}">${subject.name}</option>
				</c:forEach>			
			</select>
			<br><br>
			<input type="submit" name="register" value="Register Class">
		</form>
	</div>
</body>
</html>