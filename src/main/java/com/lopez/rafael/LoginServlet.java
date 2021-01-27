package com.lopez.rafael;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lopez.rafael.model.SystemUser;
import com.lopez.rafael.util.HibernateUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
        //retrieve a hibenate session       
        Session session = factory.openSession();

        session.beginTransaction();
        
        // retrieve the user
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SystemUser> criteria = builder.createQuery(SystemUser.class);
        criteria.from(SystemUser.class);
        List<SystemUser> systemUserList = session.createQuery(criteria).getResultList();
        
        session.getTransaction().commit();
        
        //Flush and Close Session
        session.close();
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;
        
        for (SystemUser user : systemUserList) {
        	if (username != null && username.contentEquals(user.getUsername()) && 
        		password != null && password.contentEquals(user.getPassword())) {
            	rd = request.getRequestDispatcher("dashboard");
            	rd.forward(request, response);
            }
        }
        
    	rd = request.getRequestDispatcher("index.html");	
    	out.println("<center><span style = 'color: red'>Invalid Credentials!</span></center>");
    	rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
