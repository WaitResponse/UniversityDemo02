package com.gem.java.fruit.pojo;

public class CartItem {
	private int id;
	private Fruit fruit;
	private int count;	//这里的count指的是buycount
	private User user;
	
	public CartItem(){}

	public CartItem(User user, Fruit fruit, int count) {
		super();
		this.user = user;
		this.fruit = fruit;
		this.count = count;
	}
	
	public CartItem(int id, Fruit fruit, int count, User user) {
		super();
		this.id = id;
		this.fruit = fruit;
		this.count = count;
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
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
	
	
}
