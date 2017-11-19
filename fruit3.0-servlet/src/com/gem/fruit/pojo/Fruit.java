package com.gem.fruit.pojo;

public class Fruit {
	private int id;
	private String fname;
	private int price;
	private int count;
	private String remark;

	public Fruit() {
	}

	public Fruit(String fname, int price, int count, String remark) {
		super();
		this.fname = fname;
		this.price = price;
		this.count = count;
		this.remark = remark;
	}

	public Fruit(int id, String fname, int price, int count, String remark) {
		super();
		this.id = id;
		this.fname = fname;
		this.price = price;
		this.count = count;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

}
