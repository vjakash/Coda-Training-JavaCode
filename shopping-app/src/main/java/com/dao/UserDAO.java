package com.dao;

import com.model.User;

public interface UserDAO {
	public Boolean createUser(User user);
	public User findUserByUsername(String name);
}
