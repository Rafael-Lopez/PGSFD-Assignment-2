package com.lopez.rafael.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lopez.rafael.model.Subject;
import com.lopez.rafael.service.SubjectService;

/**
 * Servlet implementation class NewSubjectServlet
 */
public class RegisterSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Subject subject = (Subject) request.getAttribute("subject");
		
		if ( subject.getName() == null || subject.getName().isEmpty() ||
			subject.getCode() == null || subject.getCode().isEmpty() ) {
			PrintWriter out = response.getWriter();
			
			RequestDispatcher rd = request.getRequestDispatcher("/dashboard");	
	    	out.println("<center><span style = 'color: red'>Name and code are required for a subject!</span></center>");
	    	rd.include(request, response);
		} else {
			SubjectService subjectService = new SubjectService();
			subjectService.save(subject);
			
			RequestDispatcher rd = request.getRequestDispatcher("dashboard");
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
