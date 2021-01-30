package com.lopez.rafael.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashboardServlet
 */
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");		
		PrintWriter out = response.getWriter();
		
		out.println("<div style=\"text-align: center\">");
		out.println("<h2>My Dashboard</h2>");
//		out.println("<h3>Welcome " + username + "!</h3>");
		
		out.println("<form action=\"newClassForm.jsp\">");         
        out.println("<button type=\"submit\">Add New Class</button>");
        out.println("</form>");
		
        out.println("<form action=\"newTeacherForm.jsp\">");         
        out.println("<button type=\"submit\">Add New Teacher</button>");
        out.println("</form>");
        
		out.println("<form action=\"newSubjectForm.jsp\">");         
        out.println("<button type=\"submit\">Add New Subject</button>");
        out.println("</form>");
        
        out.println("<form action=\"newStudentForm.jsp\">");         
        out.println("<button type=\"submit\">Add New Student</button>");
        out.println("</form>");
        
        out.println("<form action=\"classReportMenu.jsp\">");         
        out.println("<button type=\"submit\">View Class Report</button>");
        out.println("</form>");
        
        out.println("<form action=\"studentList.jsp\">");         
        out.println("<button type=\"submit\">View Student List</button>");
        out.println("</form>");
		
		out.println("<a href='/PGFSD-Assignment-2'>Logout</a>");
		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
