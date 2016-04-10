package com.store.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.store.entities.Item;
import com.store.entities.Shop;

public class ItemDAOImpl implements ItemDAO {
	private static List<Shop>shops1;
	private static List<Shop>shops2;
	private static List<Shop>shops3;
	private static Shop shop1;
	private static Shop shop2;
	private static Shop shop3;
	private Map<Integer, Item> items = new HashMap<>();
	
	public ItemDAOImpl(){
		shop1 = new Shop(1,4.55, 1);
		shop2 = new Shop(2,9.99, 2);
		shop3 = new Shop(3,6,0);
		shops1.add(shop1); shops1.add(shop2);
		shops2.add(shop3); shops2.add(shop1);
		shops3.add(shop2); shops3.add(shop3);

		items.put(1, new Item(1, "hand", shops1));
		items.put(2, new Item(2, "pen", shops2));
		items.put(3, new Item(3, "ball", shops2));
	}
	
	@Override
	public Item getById(int id) {
		Item i = items.get(id);
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

	public void setItems(Map<Integer, Item> items) {
		this.items = items;
	}

	public static List<Shop> getShops1() {
		return shops1;
	}

	public static List<Shop> getShops2() {
		return shops2;
	}

	public static List<Shop> getShops3() {
		return shops3;
	}

	public static Shop getShop1() {
		return shop1;
	}

	public static Shop getShop2() {
		return shop2;
	}

	public static Shop getShop3() {
		return shop3;
	}

	public static void setShops1(List<Shop> shops1) {
		ItemDAOImpl.shops1 = shops1;
	}

	public static void setShops2(List<Shop> shops2) {
		ItemDAOImpl.shops2 = shops2;
	}

	public static void setShops3(List<Shop> shops3) {
		ItemDAOImpl.shops3 = shops3;
	}

	public static void setShop1(Shop shop1) {
		ItemDAOImpl.shop1 = shop1;
	}

	public static void setShop2(Shop shop2) {
		ItemDAOImpl.shop2 = shop2;
	}

	public static void setShop3(Shop shop3) {
		ItemDAOImpl.shop3 = shop3;
	}

}
