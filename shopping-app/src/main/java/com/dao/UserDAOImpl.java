package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Boolean createUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(user);
		return true;
	}
	@Override
	public User findUserByUsername(String name) {
		User user=null;
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User user where user.username=:name");
		query.setParameter("name", name);
		List list=query.list();
		if(list.size()!=0) {			
			user=(User)list.get(0);
		}
		return user;
	}

}
