package com.gem.kfc.pojo;

public class Goods {
	private int id;
	private String gname;
	private int price;
	private String img;
	private int categoryId;//÷÷¿‡Id
	
	public Goods(){}

	public Goods(int id, String gname, int price, String img, int categoryId) {
		super();
		this.id = id;
		this.gname = gname;
		this.price = price;
		this.img = img;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
