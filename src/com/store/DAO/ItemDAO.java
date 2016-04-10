package com.store.DAO;

import java.util.List;

import com.store.entities.Item;

public interface ItemDAO {
	
	public Item getById(int id);
	
	public List<Item> getAll();
}
