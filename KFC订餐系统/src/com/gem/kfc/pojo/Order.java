package com.gem.kfc.pojo;

import java.util.Date;

public class Order {
	private int id;
	private int uid;
	private Date orderDate;
	private int money;
	private int orderStatus;
	private int aid;
	
	public Order(){}

	public Order(int id, int uid, Date orderDate, int money, int orderStatus,
			int aid) {
		super();
		this.id = id;
		this.uid = uid;
		this.orderDate = orderDate;
		this.money = money;
		this.orderStatus = orderStatus;
		this.aid = aid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
}
