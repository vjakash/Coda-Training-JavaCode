package com.dao;

import java.util.List;

import com.model.Address;

public interface AddressDAO {

	public Boolean createAddress(Address address);
	public List<Address> findAllAddressByUserId(int uid);
	public int deleteAddress(int id);
}
