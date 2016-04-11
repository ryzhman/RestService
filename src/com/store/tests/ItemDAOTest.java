package com.store.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.store.DAO.ItemDAOImpl;
import com.store.entities.Item;
import com.store.entities.Shop;

public class ItemDAOTest {
	private static List<Shop>shops1 = new ArrayList<>();
	private static List<Shop>shops2=new ArrayList<>();
	private static List<Shop>shops3= new ArrayList<>();
	private static Map<Integer, Item> items = new HashMap<>();;
	private static List<Item> listOfItems = new ArrayList<>();;
	private static ItemDAOImpl itemDAO;

	@BeforeClass
	public static void setUp(){
		itemDAO = ItemDAOImpl.getInstance();
		Shop shop1=new Shop(1,4.55, 1);
		Shop shop2=new Shop(2,9.99, 2);
		Shop shop3=new Shop(3,6,0);
		Shop shop4=new Shop(4,10,1);
		Shop shop5=new Shop(5,0.44,2);
		Shop shop6=new Shop(6,7,0);
		Shop shop7=new Shop(7,1,1);
		Shop shop8=new Shop(8,12,2);

		shops1.add(shop1); 
		shops1.add(shop2);
		shops1.add(shop3);
		shops1.add(shop4);
		shops2.add(shop5); 
		shops2.add(shop6);
		shops2.add(shop7);
		shops2.add(shop8);
		shops3.add(shop1); 
		shops3.add(shop3);
		shops3.add(shop5);
		shops3.add(shop7);

		listOfItems.add(new Item(1, "hand", shops1));
		listOfItems.add(new Item(2, "pen", shops2));
		listOfItems.add(new Item(3, "ball", shops3));
		items.put(1, new Item(1, "hand", shops1));
		items.put(2, new Item(2, "pen", shops2));
		items.put(3, new Item(3, "ball", shops3));
	}
	
	@Test
	public void getArrangedItemTest(){
		List<Shop>testShopsList = new ArrayList<>();
		testShopsList.add(new Shop(8,12,2));
		testShopsList.add(new Shop(5,0.44,2));
		Item testItem = new Item(2, "pen", testShopsList);
		
		assertEquals(testItem,itemDAO.getArrangedItem("pen", 2, 2));
		assertEquals(testItem.getShops(), itemDAO.getArrangedItem("pen", 2, 2).getShops());
	}

}
