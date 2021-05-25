package com.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AddressDAO;
import com.dao.UserDAO;
import com.model.Address;
import com.model.User;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AddressDAO addressDAO;
	
	
	@Override
	public int updateUser(User user) {
		return userDAO.updateUser(user);
	}
	@Override
	public Boolean createAddress(Address address) {
		return addressDAO.createAddress(address);
	}
	@Override
	public int deleteAddress(String id) {
		return addressDAO.deleteAddress(Integer.valueOf(id));
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public AddressDAO getAddressDAO() {
		return addressDAO;
	}
	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}
	

}
