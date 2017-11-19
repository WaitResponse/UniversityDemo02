package com.gem.fruit.dao;

import java.util.List;

import com.gem.fruit.pojo.Fruit;

public interface FruitDAO {
	List<Fruit>getFruitList();//这个方法没有作用
	//每页显示pagesize条记录，当前显示的pageNum页
	List<Fruit>getFruitList(int pageSize,int pageNum);
	//获取总记录条数
	int getFruitsCount();
	
	boolean addFruit(Fruit fruit);
	boolean updateFruit(Fruit fruit);
	boolean delFruit(int id);
	Fruit getFruit(int id);
}
