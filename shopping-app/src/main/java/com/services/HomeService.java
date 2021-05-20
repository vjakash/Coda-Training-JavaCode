package com.services;

import java.util.List;

import com.model.Item;

public interface HomeService {
	public List<Item> getAllItemsByType(String type);
}
