package com.lopez.rafael.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lopez.rafael.model.Class;
import com.lopez.rafael.model.Subject;
import com.lopez.rafael.model.Teacher;
import com.lopez.rafael.service.ClassService;

/**
 * Servlet implementation class RegisterClassServlet
 */
public class RegisterClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		int subjectId = Integer.valueOf(request.getParameter("subjectId"));
		int teacherId = Integer.valueOf(request.getParameter("teacherId"));
		
		if ( name == null || name.isEmpty() || code == null || code.isEmpty() ) {
				PrintWriter out = response.getWriter();
				
				RequestDispatcher rd = request.getRequestDispatcher("/newClassForm.jsp");	
		    	out.println("<center><span style = 'color: red'>All fields are required for a class!</span></center>");
		    	rd.include(request, response);
		} else {
			Subject subject = new Subject();
			subject.setId(subjectId);
			
			Teacher teacher = new Teacher();
			teacher.setId(teacherId);
			
			Class newClass = new Class();
			newClass.setName(name);
			newClass.setCode(code);
			newClass.setSubject(subject);
			newClass.setTeacher(teacher);
			
			ClassService classService = new ClassService();
			classService.save(newClass);
			
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
