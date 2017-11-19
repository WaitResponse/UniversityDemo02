package com.gem.java.fruit.dao;

import java.util.List;

import com.gem.java.fruit.pojo.Fruit;

public interface FruitDAO {
	boolean addFruit(Fruit fruit);
	boolean delFruit(int id);
	boolean updateFruit(Fruit fruit);
	List<Fruit>getFruitList();
	List<Fruit>getFruitListAsc();
	Fruit getFruit(int id);
	Fruit getFruitByName(String name);
}
