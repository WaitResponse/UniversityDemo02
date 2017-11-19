package com.gem.structs.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class loginAction4 implements ServletRequestAware,ServletResponseAware{
	private String name;
	private String pwd;
	public String  execute(){
		System.out.println("loginId:"+name);
		System.out.println("pwd:"+pwd);
		if("lina".equals(name)&&"ok".equals(pwd)){
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
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;	
	}
	private HttpServletResponse respose;
	public void setServletResponse(HttpServletResponse response) {
		this.respose=response;
		
	}
	
}
