package com.gem.kfc.pojo;

public class UserAddress {
	private int id;
	private String address,uname,tel;
	private boolean defaultAddressFlag;
	private User user;
	
	public UserAddress(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public boolean isDefaultAddressFlag() {
		return defaultAddressFlag;
	}

	public void setDefaultAddressFlag(boolean defaultAddressFlag) {
		this.defaultAddressFlag = defaultAddressFlag;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	
	
}
