package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Item> findAllItemByType(String type) {
		System.out.println(type);
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Item item where item.type=:t");
		query.setParameter("t", type);
		List list=query.list();
		System.out.println(list);
		return list;
	}

	@Override
	public List<Item> findAllItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findItemById(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
