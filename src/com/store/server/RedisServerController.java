package com.store.server;

import java.io.IOException;

import redis.clients.jedis.Jedis;
import redis.embedded.RedisServer;

public class RedisServerController {
	private static RedisServer redisServer;
	public RedisServerController(){}
	
	public static void startServer(){
		try {
			redisServer = new RedisServer(6379);
			redisServer.start();
			System.out.println("Server was launched");
		} catch (IOException e) {
			e.getMessage();
		}
	}
	public static void stopServer(){
		redisServer.stop();
		System.out.println("Server was stopped");
	}
	
	public static Jedis getConnection(){
		Jedis jedis = new Jedis("localhost");
		return jedis;
	}
	
}
