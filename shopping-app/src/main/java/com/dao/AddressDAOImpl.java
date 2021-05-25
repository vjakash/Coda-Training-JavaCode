package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Address;

@Repository
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Boolean createAddress(Address address) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(address);
		return true;
	}

	@Override
	public List<Address> findAllAddressByUserId(int uid) {
		
		return null;
	}

	@Override
	public int deleteAddress(int id) {
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("DELETE FROM Address where addressId=:id");
		query.setParameter("id", id);
		return query.executeUpdate();
	}

}
