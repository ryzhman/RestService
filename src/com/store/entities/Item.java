package com.store.entities;

import java.util.List;

import redis.clients.johm.Attribute;
import redis.clients.johm.CollectionList;
import redis.clients.johm.Id;
import redis.clients.johm.Indexed;
import redis.clients.johm.Model;

@Model
public class Item {
	@Id
	private int id;
	@Attribute
    @Indexed
	private String mpn;
    @Indexed
    @CollectionList(of = Shop.class)
	private List<Shop> shops;

	public Item(){}
	public Item(int id, String mpn, List<Shop> shops){
		this.id = id;
		this.mpn = mpn;
		this.shops = shops;
	}
	
	public Item(int id, String mpn){
		this.id = id;
		this.mpn = mpn;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((mpn == null) ? 0 : mpn.hashCode());
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
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		if (mpn == null) {
			if (other.mpn != null)
				return false;
		} else if (!mpn.equals(other.mpn))
			return false;
		return true;
	}


}
