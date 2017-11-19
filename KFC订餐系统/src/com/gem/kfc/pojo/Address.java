package com.gem.kfc.pojo;

public class Address {
	private int id;
	private String userName;
	private String address;
	private String userTel;
	private String defaultAddr;
	private int userId;
	
	public Address(){}

	public Address(int id, String userName, String address, String userTel,
			String defaultAddr, int userId) {
		super();
		this.id = id;
		this.userName = userName;
		this.address = address;
		this.userTel = userTel;
		this.defaultAddr = defaultAddr;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getDefaultAddr() {
		return defaultAddr;
	}

	public void setDefaultAddr(String defaultAddr) {
		this.defaultAddr = defaultAddr;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
