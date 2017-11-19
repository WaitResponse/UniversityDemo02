package com.gem.java.fruit.pojo;

import java.io.Serializable;

public class Fruit implements Serializable{
	private int id;
	private String name;
	private double price;
	private int count;
	private String remark;

	public Fruit() {
	}

	public Fruit(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Fruit(int id, String name, double price, int count, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.remark = remark;
	}

	public Fruit(String name, double price, int count, String remark) {
		this.name = name;
		this.price = price;
		this.count = count;
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name+"\t"+price+"\t"+count+"\t"+remark;
	}
	

	
}
