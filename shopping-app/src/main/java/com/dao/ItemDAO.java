package com.dao;

import java.util.List;

import com.model.Item;

public interface ItemDAO {
	public List<Item> findAllItemByType(String type);
	public List<Item> findAllItem();
	public Item findItemById(String name);
}
