package com.gem.kfc.pojo;

public class OrderItem {
	private int id;
	private int gid;
	private int count;
	private int oid;
	
	public OrderItem(){}

	public OrderItem(int id, int gid, int count, int oid) {
		super();
		this.id = id;
		this.gid = gid;
		this.count = count;
		this.oid = oid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	
}
