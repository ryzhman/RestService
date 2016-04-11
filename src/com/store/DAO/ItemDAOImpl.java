package com.store.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.store.entities.Item;
import com.store.entities.Shop;

public class ItemDAOImpl implements ItemDAO {
	private static List<Shop>shops1 = new ArrayList<>();
	private  static List<Shop>shops2=new ArrayList<>();
	private  static List<Shop>shops3= new ArrayList<>();
	private static Map<Integer, Item> items;
	private static List<Item> listOfItems;
	private static ItemDAOImpl itemDAOimpl;

//	private static Map<String, String> itemsData;
//	private static Map<String, String> shopsData;
	
//	Initialisation of DB alternative - Map<Integer, Item>items, which includes all the data about item, including List<Shop>
	static{
		items = new HashMap<>();
		listOfItems = new ArrayList<>();
		
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
				break;
			};
		}
		List<Shop> shopList = item.getShops();
		List<Shop> sortedList = new ArrayList<>();
		switch(availability){
			case 0: {
				sortedList.addAll(shopList);
				break;
			}
			case 1:{
				for(Shop e: shopList){
					if(!(e.getStock()==0)){
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
				item.setShops(sortedList);
				break;
			}
			case 1:{
				Collections.sort(sortedList, Shop.AscComparator);
				item.setShops(sortedList);
				break;
			}
			case 2:{
				Collections.sort(sortedList, Shop.DescComparator);
				item.setShops(sortedList);
				break;
			}
		}
		return item;
	}

	public Map<Integer, Item> getItems() {
		return items;
	}
	
	
	
//	Redis DB related code
//	public void createDB(){
//		RedisServerController.startServer();
//		Jedis jedis = RedisServerController.getConnection();
//		JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "localhost"); 
//		JOhm.setPool(jedisPool);
//		
//		JOhm.save(shop1);
//		JOhm.save(shop2);
//		JOhm.save(shop3);
//		JOhm.save(shop4);
//		JOhm.save(shop5);
//		JOhm.save(shop6);
//		JOhm.save(shop7);
//		JOhm.save(shop8);
//		
//		Item i1=new Item(1,"wheel");
//		JOhm.save(i1);
//		i1.getShops().add(shop1);
//		i1.getShops().add(shop2);
//		i1.getShops().add(shop3);
//
////		createMapsOfShops(shop1, jedis);
//	}
	
//	public void stopTheServer(){
//		RedisServerController.stopServer();
//	}
	
//	public void createMapsOfShops(Shop s){
//		Map<String,String> shopsDataTemp = new HashMap<>();
//		shopsData.put("id", String.valueOf(s.getId()));
//		shopsData.put("price", String.valueOf(s.getPrice()));
//		shopsData.put("stock", String.valueOf(s.getStock()));
//		
//		itemsData.put("Store id:"+i.getId(), itemsDataTemp);
//
////		jedis.hmset("shop:" + s.getId(), shopsData);
//	}
//	
//	public void createMapOfItems(Item i){
//		Map<String,String> itemsDataTemp = new HashMap<>();
//		itemsData.put("id", String.valueOf(i.getId()));
//		itemsData.put("mpn", i.getMpn());
//		itemsData.put("shops", i.getShops());
//		
//		itemsData = new HashMap<>();
//		itemsData.put("item id:"+i.getId(), itemsDataTemp);
//	}

}
