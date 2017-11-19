package com.gem.fruit.biz;

import java.util.List;

import com.gem.fruit.pojo.Fruit;

public interface FruitBiz {
	//ͨ����ѯ�ؼ��֣�һҳ��ʾ�ļ�¼�����Ҹ����������������ҳ��
	int getPageCount(String keyword,int pageSize);
	
	//������Ҳ�ѯ�ؼ��֣���������ʾ�ڼ�ҳ��һҳ��ʾ���������Ҹ��������ҳ�ļ�¼
	List<Fruit> getFruitList(String keyword,int pageSize,int currPage);
	
	//�����ˮ��
	boolean addFruit(Fruit fruit);
	
	//�޸��ض�ˮ��
	boolean updateFruit(Fruit fruit);
	//��ѯ�ض�ˮ����Ϣ
	Fruit getFruit(int id);
	//ɾ��ˮ��
	boolean delFruit(int id);
}
