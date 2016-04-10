package com.store.entities;

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
	
	
	

}
