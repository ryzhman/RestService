package com.store.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.store.entities.Item;
import com.store.entities.Shop;
import com.store.server.RedisServerController;

public class ItemDAOImpl implements ItemDAO {
	private static List<Shop>shops1 = new ArrayList<>();
	private  static List<Shop>shops2=new ArrayList<>();
	private  static List<Shop>shops3= new ArrayList<>();
	private  static Shop shop1=new Shop(1,4.55, 1);
	private  static Shop shop2=new Shop(2,9.99, 2);
	private  static Shop shop3=new Shop(3,6,0);
	private static Map<Integer, Item> items;
	private static List<Item> listOfItems;
	
	static{
		items = new HashMap<>();
		listOfItems = new ArrayList<>();
		shops1.add(shop1); 
		shops1.add(shop2);
		shops2.add(shop3); 
		shops2.add(shop1);
		shops3.add(shop2); 
		shops3.add(shop3);
		listOfItems.add(new Item(1, "hand", shops1));
		listOfItems.add(new Item(2, "pen", shops2));
		listOfItems.add(new Item(3, "ball", shops2));
		items.put(1, new Item(1, "hand", shops1));
		items.put(2, new Item(2, "pen", shops2));
		items.put(3, new Item(3, "ball", shops2));
	}
	
	private static ItemDAOImpl itemDAOimpl;

	public static ItemDAOImpl getInstance(){
		if(itemDAOimpl==null) {
			itemDAOimpl=new ItemDAOImpl();
		}
		return itemDAOimpl;
	}

	public ItemDAOImpl(){
	}

	@Override
	public Item getById(Integer id) {
		Item i = items.get(id);
		return i;
	}

	@Override
	public List<Item> getAll() {
		List<Item> listOfItems = new ArrayList<>(items.values());
		return listOfItems;
	}
	
	@Override
	public Item getArrangedItem(String mpn, int availability, int sortBy){
		List<Item> listOfItems = getAll();
		Item item = new Item();
		for(Item e: listOfItems){
			if(e.getMpn().equals(mpn)){
				item.setMpn(mpn);
				item.setId(e.getId());
				item.setShops(e.getShops());
			};
		}
		List<Shop> shopList = item.getShops();
		List<Shop> sortedList = new ArrayList<>();
		switch(availability){
			case 0: {
				break;
			}
			case 1:{
				for(Shop e: shopList){
					if(e.getStock()==1&&e.getStock()==2){
						sortedList.add(e);
					}
				}
				break;
			}
			case 2:{
				for(Shop e: shopList){
					if(e.getStock()==2){
						sortedList.add(e);
					}
				}
				break;
			}
		}
		switch(sortBy){
			case 0:{
				break;
			}
			case 1:{
				Collections.sort(sortedList, Shop.AscComparator);
				break;
			}
			case 2:{
				Collections.sort(sortedList, Shop.DescComparator);
				break;
			}
		}
		item.setShops(sortedList);
		return item;
	}

	public Map<Integer, Item> getItems() {
		return items;
	}
	
	public void createDB(){
		RedisServerController.startServer();
	}

}
