package com.lopez.rafael.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lopez.rafael.model.Class;
import com.lopez.rafael.util.HibernateUtil;

public class ClassService {
	public void save(Class newClass) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        
        session.save(newClass);
        
        session.getTransaction().commit();
        
        session.close();
	}
}
