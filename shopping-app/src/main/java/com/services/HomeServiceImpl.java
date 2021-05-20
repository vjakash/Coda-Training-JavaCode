package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ItemDAO;
import com.model.Item;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

	@Autowired
	private ItemDAO itemDAO;
	
	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	@Override
	public List<Item> getAllItemsByType(String type) {
		// TODO Auto-generated method stub
		return itemDAO.findAllItemByType(type);
	}

	

}
