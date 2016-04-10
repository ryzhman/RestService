package com.store.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.store.entities.Item;
import com.store.entities.Shop;

public class ItemDAOImpl implements ItemDAO {
	private static List<Shop>shops1;
	private  static List<Shop>shops2;
	private  static List<Shop>shops3;
	private  static Shop shop1;
	private  static Shop shop2;
	private  static Shop shop3;
	private static Map<Integer, Item> items;
	private static List<Item> listOfItems;

	static{
		items = new HashMap<>();
		listOfItems = new ArrayList<>();
		shop1=new Shop(1,4.55, 1);
		shop2=new Shop(2,9.99, 2);
		shop3=new Shop(3,6,0);
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
		Item i = new Item(1, "hand", null);
//		Item i = items.get(id);
		return i;
	}

	@Override
	public List<Item> getAll() {
		List<Item> listOfItems = new ArrayList<>(items.values());
		return listOfItems;
	}

	public Map<Integer, Item> getItems() {
		return items;
	}

	/*public void setItems(Map<Integer, Item> items) {
		this.items = items;
	}

	public  List<Shop> getShops1() {
		return shops1;
	}

	public  List<Shop> getShops2() {
		return shops2;
	}

	public  List<Shop> getShops3() {
		return shops3;
	}

	public  Shop getShop1() {
		return shop1;
	}

	public  Shop getShop2() {
		return shop2;
	}

	public  Shop getShop3() {
		return shop3;
	}

	public  void setShops1(List<Shop> shops1) {
		this.shops1 = shops1;
	}

	public  void setShops2(List<Shop> shops2) {
		this.shops2 = shops2;
	}

	public  void setShops3(List<Shop> shops3) {
		this.shops3 = shops3;
	}

	public  void setShop1(Shop shop1) {
		this.shop1 = shop1;
	}

	public  void setShop2(Shop shop2) {
		this.shop2 = shop2;
	}

	public  void setShop3(Shop shop3) {
		this.shop3 = shop3;
	}*/

}
