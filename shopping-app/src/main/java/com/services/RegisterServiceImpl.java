package com.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.model.User;


@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public Boolean registerUser(User user) {
		return userDAO.createUser(user);
	}
	@Override
	public Boolean isUsernameExist(String username) {
		if(userDAO.findUserByUsername(username)==null) {
			return false;
		}else {
			return true;
		}
	}

}
