package com.gem.structs.actions;

public class loginAction1 {
	private String name;
	private String pwd;
	//jsp发送请求给loginAction1,默认调用execute方法
	public String  execute(){
		System.out.println("loginId:"+name);
		System.out.println("pwd:"+pwd);
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
