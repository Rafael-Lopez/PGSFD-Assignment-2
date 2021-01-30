<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.button {border: 1px solid #000; margin: 10px; background-color: #f1f1f1;color: black;border-radius: 5%;min-width:200px;text-decoration: none;display: inline-block;padding: 8px 16px;}
</style>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<div style="text-align: center">
		<h2>My Dashboard</h2>
		
		<a href="/PGFSD-Assignment-2/newClassForm.jsp" class="button">Add New Class</a>
		<br/>
		<a href="/PGFSD-Assignment-2/newTeacherForm.jsp" class="button">Add New Teacher</a>
		<br/>
		<a href="/PGFSD-Assignment-2/newSubjectForm.jsp" class="button">Add New Subject</a>
		<br/>
		<a href="/PGFSD-Assignment-2/newStudentForm.jsp" class="button">Add New Student</a>
		<br/>
		<a href="/PGFSD-Assignment-2/classReportMenu.jsp" class="button">View Class Report</a>
		<br/>
		<a href="/PGFSD-Assignment-2/studentList.jsp" class="button">View Student List</a>
		<br/>		
		<a href='/PGFSD-Assignment-2'>Logout</a>
	</div>
</body>
</html>