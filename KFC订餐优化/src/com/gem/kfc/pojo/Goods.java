package com.gem.kfc.pojo;

public class Goods {
	private int id;
	private String gname;
	private int price;
	private String img;
	private Category category;//÷÷¿‡Id
	
	public Goods(){}

	public Goods(int id, String gname, int price) {
		super();
		this.id = id;
		this.gname = gname;
		this.price = price;
	}

	public Goods(int id) {
		super();
		this.id = id;
	}

	public Goods(int id, String gname, int price, String img, Category category) {
		super();
		this.id = id;
		this.gname = gname;
		this.price = price;
		this.img = img;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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


	
}
