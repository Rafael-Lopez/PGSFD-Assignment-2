package com.lopez.rafael.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lopez.rafael.model.Class;
import com.lopez.rafael.model.Subject;
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
	
	public List<Class> getClassList() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Class> criteria = builder.createQuery(Class.class);
        criteria.from(Class.class);
        List<Class> classList = session.createQuery(criteria).getResultList();
        
        session.getTransaction().commit();
        
        session.close();
        
        return classList;
	}
}
