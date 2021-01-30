package com.lopez.rafael.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lopez.rafael.model.Class;
import com.lopez.rafael.model.Student;
import com.lopez.rafael.service.StudentService;

/**
 * Servlet implementation class RegisterStudentServlet
 */
public class RegisterStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int classId = Integer.valueOf(request.getParameter("classId"));
		
		if ( firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() ||
			 email == null || email.isEmpty()	) {
			PrintWriter out = response.getWriter();
			
			RequestDispatcher rd = request.getRequestDispatcher("/newStudentForm.jsp");	
	    	out.println("<center><span style = 'color: red'>All fields are required!</span></center>");
	    	rd.include(request, response);
		} else {
			Class newClass = new Class();
			newClass.setId(classId);
			
			Student student = new Student();
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setEmail(email);
			student.setAssignedClass(newClass);
			
			StudentService studentService = new StudentService();
			studentService.save(student);
			
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
