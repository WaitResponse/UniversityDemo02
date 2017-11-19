package com.gem.kfc.pojo;

import java.util.Set;

public class Category {
	private int id;
	private String cname;
	private Set<Goods>goodses;
	
	public Category(){}
	
	
	public Category(int id) {
		super();
		this.id = id;
	}


	public Category(int id, String cname) {
		super();
		this.id = id;
		this.cname = cname;
	}


	public Set<Goods> getGoodses() {
		return goodses;
	}

	public void setGoodses(Set<Goods> goodses) {
		this.goodses = goodses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	
}
