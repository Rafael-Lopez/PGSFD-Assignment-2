package com.lopez.rafael.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lopez.rafael.model.Subject;
import com.lopez.rafael.util.HibernateUtil;

public class SubjectService {
	public void save(Subject subject) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        
        session.save(subject);
        
        session.getTransaction().commit();
        
        session.close();
	}
}
