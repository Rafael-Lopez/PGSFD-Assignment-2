<%@page import="com.lopez.rafael.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.lopez.rafael.model.Class"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.subject {text-align:left;float:left;margin-left:150px;}
	.teacher {text-align:right;float:right;margin-right:150px;}
	.tg  {border-collapse:collapse;border-color:#aaa;border-spacing:0;margin-left: auto;margin-right: auto;}
	.tg td{background-color:#fff;border-color:#aaa;border-style:solid;border-width:1px;color:#333;
	  font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;word-break:normal;}
	.tg th{background-color:#f38630;border-color:#aaa;border-style:solid;border-width:1px;color:#fff;
	  font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;min-width: 250px;}
	.tg .tg-general{text-align:center;vertical-align:top}
	.previous {border: 1px solid #000; margin: 10px; background-color: #f1f1f1;color: black;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
</style>
<meta charset="ISO-8859-1">
<title>Class Report</title>
</head>
<body style="padding: 10px">
	<div style="text-align: center">
		<% Class item = (Class) request.getAttribute("class");%>
		<% List<Student> students = item.getStudents();
			request.setAttribute("students", students);%>
		<h1>Class: <%=item.getName()%></h1>
		<h2 class="subject">Subject: <%=item.getSubject().getName()%></h2>
		<h2 class="teacher">Teacher: <%=item.getTeacher().getFirstName() + " " + item.getTeacher().getLastName()%></h2>
		<hr style="clear:both;"/>
		<h2>Students Enrolled</h2>
		
		<table class="tg">
		<thead>
		  <tr>
		    <th class=tg-general>First Name</th>
		    <th class="tg-general">Last Name</th>
		    <th class="tg-general">Email</th>
		  </tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
			  	<tr>
					<td class="tg-general">${student.firstName}</td>
				    <td class="tg-general">${student.lastName}</td>
				    <td class="tg-general">${student.email}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<a href="/PGFSD-Assignment-2/classReportMenu.jsp" class="previous">&laquo; Back to Class Report Menu</a>
	</div>
</body>
</html>