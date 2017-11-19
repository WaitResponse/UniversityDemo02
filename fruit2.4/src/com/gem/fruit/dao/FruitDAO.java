package com.gem.fruit.dao;

import java.util.List;

import com.gem.fruit.pojo.Fruit;

public interface FruitDAO {
	List<Fruit>getFruitList();//�������û������
	//ÿҳ��ʾpagesize����¼����ǰ��ʾ��pageNumҳ
	List<Fruit>getFruitList(int pageSize,int pageNum);
	//��ȡ�ܼ�¼����
	int getFruitsCount();
	
	boolean addFruit(Fruit fruit);
	boolean updateFruit(Fruit fruit);
	boolean delFruit(int id);
	Fruit getFruit(int id);
}
