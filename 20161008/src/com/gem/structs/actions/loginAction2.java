package com.gem.structs.actions;

import com.opensymphony.xwork2.ActionContext;

public class loginAction2 {
	private String name;
	private String pwd;
	public String  execute(){
		System.out.println("loginId:"+name);
		System.out.println("pwd:"+pwd);
		if("lina".equals(name)&&"ok".equals(pwd)){
			//将用户名保存到request作用域
			ActionContext.getContext().put("currName1",name);
			ActionContext.getContext().getSession().put("currName2",name);
			ActionContext.getContext().getApplication().put("currName3",name);
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
