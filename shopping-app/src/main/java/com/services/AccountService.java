package com.services;

import com.model.Address;
import com.model.User;

public interface AccountService {

	public int updateUser(User user);
	public Boolean createAddress(Address address);
	public int deleteAddress(String id);
}
