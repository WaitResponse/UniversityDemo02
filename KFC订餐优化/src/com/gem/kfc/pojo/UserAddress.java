package com.gem.kfc.pojo;

public class UserAddress {
	private int id;
	private String address,uname,tel;
	private boolean defaultAddressFlag;
	private User user;
	
	
	public UserAddress(int id, String address, String uname, String tel,
			boolean defaultAddressFlag, User user) {
		super();
		this.id = id;
		this.address = address;
		this.uname = uname;
		this.tel = tel;
		this.defaultAddressFlag = defaultAddressFlag;
		this.user = user;
	}

	public UserAddress(int id) {
		super();
		this.id = id;
	}

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
