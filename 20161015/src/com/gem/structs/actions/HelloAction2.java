package com.gem.structs.actions;

import com.opensymphony.xwork2.ActionContext;

public class HelloAction2 {
	public String execute(){
		System.out.println("��ã�");
		ActionContext.getContext().put("uname", "�¶���");
		return "success";
	}
}
