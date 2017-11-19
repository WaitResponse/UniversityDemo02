package com.gem.java.fruit.dao;

import com.gem.java.fruit.pojo.User;

public interface UserDAO {
	User login(String loginId,int pwd);
}
