//package com.store.tests;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.store.DAO.ItemDAOImpl;
//import com.store.entities.Item;
//import com.store.entities.Shop;
//
//import redis.clients.johm.JOhm;
//import redis.clients.johm.collections.RedisList;
//import redis.embedded.RedisServer;
//
//public class JOhmTests {
//	private static ItemDAOImpl itemDAO;
//	
//	@BeforeClass
//	public static void setUpClass(){
////		RedisServer redisServer;
////		try {
////			redisServer = new RedisServer(6379);
////			redisServer.start();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		itemDAO = ItemDAOImpl.getInstance();
//		itemDAO.createDB();
//	}
//	
////	@AfterClass
////	public static void tearDown(){
////		itemDAO.stopTheServer();
////	}
//	
//	@Test
//	public void createDBTest(){
//		itemDAO.createDB();
//		
//		Shop shop1=new Shop(1,4.55, 1);
//		Shop shop2=new Shop(2,9.99, 2);
//		Shop shop3=new Shop(3,6,0);
//		
//		JOhm.save(shop1);
//		JOhm.save(shop2);
//		JOhm.save(shop3);
//		
//		Item i1=new Item(1,"wheel");
//		JOhm.save(i1);
//		i1.getShops().add(shop1);
//		i1.getShops().add(shop2);
//		i1.getShops().add(shop3);
//		
//		Item savedItem = JOhm.get(Item.class, i1.getId());
//        assertEquals(3, savedItem.getShops().size());
//		
////        List<Shop> list = JOhm.get(RedisList.class, i1.getShops());
//        assertEquals(shop1, savedItem.getShops().get(0));
//	}
//	
//
//}
