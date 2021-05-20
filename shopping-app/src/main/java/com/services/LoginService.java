package com.services;

import com.model.User;

public interface LoginService {
	public User isUserPresent(String username);
}
