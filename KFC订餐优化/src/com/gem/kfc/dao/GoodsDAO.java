package com.gem.kfc.dao;

import java.util.Set;

import com.gem.kfc.pojo.Goods;

public interface GoodsDAO {
	 public Set<Goods> getGoods();
	 public Set<Goods> getGoods(int categoryId);
}
