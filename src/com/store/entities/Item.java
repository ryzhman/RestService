package com.store.entities;

import java.util.List;

public class Item {

	private int id;
	private String mpn;
	private List<Shop> shops;

	public Item(){}
	public Item(int id, String mpn, List<Shop> shops){
		this.id = id;
		this.mpn = mpn;
		this.shops = shops;
	}

	public int getId() {
		return id;
	}
	public String getMpn() {
		return mpn;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMpn(String mpn) {
		this.mpn = mpn;
	}

	public List<Shop> getShops() {
		return shops;
	}
	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
	@Override
	public String toString() {
		return "Item id - " + id + ", mpn - " + mpn + ", shop - " + shops;
	}


}
