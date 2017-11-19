package com.gem.kfc.pojo;

public class CartItem {
	private int id;
	private Goods goods;
	private int count;
	private User user;
	private int status;

	public CartItem(){}

	public CartItem(int id, Goods goods, int count, User user) {
		super();
		this.id = id;
		this.goods = goods;
		this.count = count;
		this.user = user;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
}
