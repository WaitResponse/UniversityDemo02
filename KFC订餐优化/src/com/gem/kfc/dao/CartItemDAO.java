package com.gem.kfc.dao;

import java.util.Set;

import com.gem.kfc.pojo.CartItem;

public interface CartItemDAO {
	//根据商品Id获取购物车信息
	public Set<CartItem>getCartItem(int uid);
	
	//添加购物车信息
	public CartItem addCartItem(CartItem cartItem);
	
	//修改购物车信息
	public boolean updateCartItem(CartItem cartItem);
	
	//删除购物车信息,根据商品Id
	public boolean delCartItem(int gid);
	//根据购物袋Id删除信息
	public boolean delCartItemBycid(int cid);
}
