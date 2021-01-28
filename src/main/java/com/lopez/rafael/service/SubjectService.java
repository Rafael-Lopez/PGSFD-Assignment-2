package com.lopez.rafael.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lopez.rafael.model.Subject;
import com.lopez.rafael.model.SystemUser;
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
	
	public List<Subject> getSubjectList() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Subject> criteria = builder.createQuery(Subject.class);
        criteria.from(Subject.class);
        List<Subject> subjectList = session.createQuery(criteria).getResultList();
        
        session.getTransaction().commit();
        
        session.close();
        
        return subjectList;
	}
}
