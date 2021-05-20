package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDAOImpl extends UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void createUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println(".................session factory.................:"+sessionFactory);
		session.persist(user);
	//	session.beginTransaction().commit();
	}
}
