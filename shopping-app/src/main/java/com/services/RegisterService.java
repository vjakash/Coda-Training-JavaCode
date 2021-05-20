package com.services;

import com.model.User;

public interface RegisterService {
	public Boolean registerUser(User user);
	public Boolean isUsernameExist(String username);
}
