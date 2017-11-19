package com.gem.java.fruit.pojo;

import java.util.List;
import java.util.Map;


public class User {
	private  int id;
	private String loginId;
	private int pwd;
	private String nickName;
	private String address;
	private List<OrderBean>orderBeanList;
	private Map<Integer,CartItem> cartItemMap;

	public User(){}
	
	public User(int id) {
		super();
		this.id = id;
	}

	public User(int id, String loginId, int pwd, String nickName, String address) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.pwd = pwd;
		this.nickName = nickName;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<OrderBean> getOrderBeanList() {
		return orderBeanList;
	}
	public void setOrderBeanList(List<OrderBean> orderBeanList) {
		this.orderBeanList = orderBeanList;
	}
	public Map<Integer, CartItem> getCartItemMap() {
		return cartItemMap;
	}
	public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
		this.cartItemMap = cartItemMap;
	}
	}
	
