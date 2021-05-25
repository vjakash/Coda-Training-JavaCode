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
		user=(User)query.uniqueResult();
		return user;
	}
	@Override
	public int updateUser(User user) {
		User user1=null;
		Session session= sessionFactory.getCurrentSession();
		 String hql =" update User u set"+
				 	 " u.username=:uname,"
				 	 + "u.password=:upass,"
				 	 + "u.mobile=:mob,"
				 	 + "u.email=:email "
				 	 + "where u.uid=:uid";
		Query query = session.createSQLQuery(hql);
		query.setParameter("uname", user.getUsername());
		query.setParameter("upass", user.getPassword());
		query.setParameter("mob", user.getMobile());
		query.setParameter("email", user.getEmail());
		query.setParameter("uid",user.getUid());
        int count = query.executeUpdate();        
		return count;
	}

}
