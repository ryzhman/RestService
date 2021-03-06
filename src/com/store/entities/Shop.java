package com.store.entities;

import java.util.Comparator;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Indexed;
import redis.clients.johm.Model;

@Model
public class Shop {
	@Id
	private int id;
	@Attribute
    @Indexed
	private double price;
	@Attribute
    @Indexed
	private int stock;
	
	public Shop(){}
	public Shop(int id, double price, int stock){
		this.id = id;
		this.price = price;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Shop id - " + id + ", price - " + price + ", stock - " + stock;
	}
	
	
	public static Comparator<Shop> AscComparator = new Comparator<Shop>(){
		@Override
		public int compare(Shop s1, Shop s2) {
			if((s1.getPrice()-s2.getPrice())>0) return 1;
			else if((s1.getPrice()-s2.getPrice())<0) return -1;
			else return 0;
		}
	};
	
	public static Comparator<Shop> DescComparator = new Comparator<Shop>(){
		@Override
		public int compare(Shop s1, Shop s2) {
			if((s1.getPrice()-s2.getPrice())<0) return 1;
			else if((s1.getPrice()-s2.getPrice())>0) return -1;
			else return 0;
		}
	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
