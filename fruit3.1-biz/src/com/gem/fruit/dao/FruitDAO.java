package com.gem.fruit.dao;

import java.util.List;

import com.gem.fruit.pojo.Fruit;

public interface FruitDAO {
	List<Fruit> getFruitList();
	
	//ÿҳ��ʾpageSize����¼����ǰ��ʾ��pageNumҳ
	List<Fruit> getFruitList(int pageSize , int pageNum);
	
	//��ȡ�ܼ�¼����
	int getFruitsCount();
	
	//���ݹؼ��ֲ�ѯ, ÿҳ��ʾpageSize����¼����ǰ��ʾ��pageNumҳ
	List<Fruit> getFruitList(String keyword , int pageSize , int pageNum);
	//���ݹؼ��ֲ�ѯ, ��ȡ�ܼ�¼����
	int getFruitsCount(String keyword);
	
	boolean addFruit(Fruit fruit);
	boolean updateFruit(Fruit fruit);
	boolean delFruit(int id);
	Fruit getFruit(int id);
	
	boolean isFruitNameExists(String name);
}
