package com.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.model.User;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public User isUserPresent(String username) {
		return userDAO.findUserByUsername(username);
	}

}
