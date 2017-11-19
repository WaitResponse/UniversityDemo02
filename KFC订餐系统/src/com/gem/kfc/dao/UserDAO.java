package com.gem.kfc.dao;

import com.gem.kfc.pojo.User;

public interface UserDAO {
	User getUser(String loginId,String pwd);//登录用到
	boolean addUser(User user);//注册用到
}
