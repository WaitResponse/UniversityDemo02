package com.gem.structs.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class loginAction3 {
	private String name;
	private String pwd;
	public String  execute(){
		System.out.println("loginId:"+name);
		System.out.println("pwd:"+pwd);
		if("lina".equals(name)&&"ok".equals(pwd)){
			//将用户名保存到request作用域
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse session=ServletActionContext.getResponse();
			ServletContext application =ServletActionContext.getServletContext();
			request.getSession();
			return "success";
		}else{
			return "login";
		}		
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
