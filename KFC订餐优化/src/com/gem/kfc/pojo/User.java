package com.gem.kfc.pojo;

import java.util.Set;

public class User {
	private int id;
	private String loginId;
	private String pwd;
	private String nickName;
	private String realName;
	private int balance;
	private Set<UserAddress> addresses;
	
	public Set<UserAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<UserAddress> addresses) {
		this.addresses = addresses;
	}

	public User(){}
	
	
	public User(int id) {
		super();
		this.id = id;
	}

	public User(String loginId, String pwd, String nickName, String realName,
			int balance) {
		super();
		this.loginId = loginId;
		this.pwd = pwd;
		this.nickName = nickName;
		this.realName = realName;
		this.balance = balance;
	}

	public User(int id, String loginId, String pwd, String nickName,
			String realName, int balance) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.pwd = pwd;
		this.nickName = nickName;
		this.realName = realName;
		this.balance = balance;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
