package com.gem.structs.actions;

import com.opensymphony.xwork2.ActionContext;

public class HelloAction2 {
	public String execute(){
		System.out.println("ÄãºÃ£¡");
		ActionContext.getContext().put("uname", "³Â¶«ÎÄ");
		return "success";
	}
}
