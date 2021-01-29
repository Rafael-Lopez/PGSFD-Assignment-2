package com.lopez.rafael.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lopez.rafael.model.Student;
import com.lopez.rafael.util.HibernateUtil;

public class StudentService {
	public void save(Student student) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        
        session.save(student);
        
        session.getTransaction().commit();
        
        session.close();
	}
}
