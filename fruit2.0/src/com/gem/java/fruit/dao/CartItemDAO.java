package com.gem.java.fruit.dao;

import java.util.Map;

import com.gem.java.fruit.pojo.CartItem;

public interface CartItemDAO {
	Map<Integer,CartItem>getCartItemMap(int userId);
	
	void addCartItem(CartItem cartitem);
	
	void delCartItem(int cartItemId);
}
