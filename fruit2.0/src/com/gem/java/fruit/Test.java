package com.gem.java.fruit;

import com.gem.java.fruit.pojo.User;

public class Test {
	public static void main(String[] args) {
		//ʵ������һ��Menu�˵�����
		Menu m = new Menu();
		User user=m.login();
		if(user!=null){
			m.currUser=user;
			m.loadCartItem(user);
			boolean flag = true ;
			while(flag){
				int slt = m.showMainMenu();
				switch(slt){
				case 1:
					m.showFruitList();
					break;
				case 2:
					m.addFruit();
					break;
				case 3:
					m.delFruit();
					break;
				case 4:
					flag = m.exit() ;
					break;
				case 5:
					m.showFruitListByPriceAsc();
					break;
				case 6:
					
					break;
				case 7:
					m.shopping();
					break;
				case 8:
					m.pay();
					break;
				default:
					System.out.println("�㲻����·���ƣ�");
					break;
				}
			}
			System.out.println("ллʹ�ã��ټ���");
		}
			
			
		}
		
}
