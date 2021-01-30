<%@page import="com.lopez.rafael.model.Teacher"%>
<%@page import="com.lopez.rafael.model.Class"%>
<%@page import="java.util.List"%>
<%@page import="com.lopez.rafael.service.TeacherService"%>
<%@page import="com.lopez.rafael.service.ClassService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		
		<%! ClassService classService = new ClassService(); 
			TeacherService teacherService = new TeacherService();
		%>  
		<% List<Class> classList = classService.getClassList();
		   request.setAttribute("classList", classList);
		   
		   List<Teacher> teacherList = teacherService.getTeacherList();
		   request.setAttribute("teacherList", teacherList);
		%>
				
		<form action="registerSubject" method="post">
			<label for="name">Name:</label>
			<input type="text" id="name" name="name">
			<br><br>
			<label for="code">Code:</label>
			<input type="text" id="code" name="code">
			<br><br>
			<label for="classId">Class:</label>
			<select id="classId" name="classId">
				<c:forEach items="${classList}" var="item">
				    <option value="${item.id}">${item.name}</option>
				</c:forEach>			
			</select>
			<br><br>
			<label for="teacherId">Teacher:</label>
			<select id="teacherId" name="teacherId">
				<c:forEach items="${teacherList}" var="teacher">
				    <option value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
				</c:forEach>			
			</select>
			<br><br>
			<input type="submit" name="register" value="Register Subject">
		</form>
	</div>	
</body>
</html>