package com.gem.kfc.pojo;

public class CartItem {
	private int id;
	private int gid;
	private int count;
	private int uid;
	private int cateItemStatus;
	
	public CartItem(){}

	public CartItem(int id, int gid, int count, int uid, int cateItemStatus) {
		super();
		this.id = id;
		this.gid = gid;
		this.count = count;
		this.uid = uid;
		this.cateItemStatus = cateItemStatus;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getCateItemStatus() {
		return cateItemStatus;
	}

	public void setCateItemStatus(int cateItemStatus) {
		this.cateItemStatus = cateItemStatus;
	}
	
	
}
