package com.store.DAO;

import java.util.List;

import com.store.entities.Item;

public interface ItemDAO {
	
	public Item getById(Integer id);
	
	public List<Item> getAll();
	
	public Item getArrangedItem(String mpn, int availability, int sortBy);
}
