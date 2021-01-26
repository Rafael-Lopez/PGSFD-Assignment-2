package com.lopez.rafael;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//These values should come from the DB
	private static final String USERNAME = "test";
	private static final String PASSWORD = "test";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;
        
        if (username != null && username.contentEquals(USERNAME) && password != null && password.contentEquals(PASSWORD)) {
        	rd = request.getRequestDispatcher("dashboard");
        	rd.forward(request, response);
        } else {
        	rd = request.getRequestDispatcher("index.html");
        	PrintWriter out = response.getWriter();
        	out.println("<center><span style = 'color: red'>Invalid Credentials!</span></center>");
        	rd.include(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
