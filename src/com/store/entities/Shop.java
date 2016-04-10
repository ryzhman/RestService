package com.store.entities;

import java.util.Comparator;

public class Shop {
	private int id;
	private double price;
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
	
	

}
