package com.gem.java.fruit;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.gem.java.fruit.dao.CartItemDAO;
import com.gem.java.fruit.dao.FruitDAO;
import com.gem.java.fruit.dao.OrderDAO;
import com.gem.java.fruit.dao.OrderItemDAO;
import com.gem.java.fruit.dao.UserDAO;
import com.gem.java.fruit.dao.Impl.CartItemDAOImpl;
import com.gem.java.fruit.dao.Impl.FruitDAOImpl;
import com.gem.java.fruit.dao.Impl.OrderDAOImpl;
import com.gem.java.fruit.dao.Impl.OrderItemDAOImpl;
import com.gem.java.fruit.dao.Impl.UserDAOImpl;
import com.gem.java.fruit.pojo.CartItem;
import com.gem.java.fruit.pojo.Fruit;
import com.gem.java.fruit.pojo.OrderBean;
import com.gem.java.fruit.pojo.OrderItem;
import com.gem.java.fruit.pojo.User;

public class Menu {
		
	private Scanner input = new Scanner(System.in);
	
	private FruitDAO fruitDAO=new FruitDAOImpl();
	private UserDAO userDAO=new UserDAOImpl();
	private CartItemDAO cartItemDAO=new CartItemDAOImpl();
	private OrderDAO orderDAO=new OrderDAOImpl();
	private OrderItemDAO orderItemDAO=new OrderItemDAOImpl();
	public User currUser;
	//��¼
	public User login(){
		System.out.print("�˺�:");
		String  loginId=input.next();
		System.out.print("����:");
		int pwd=input.nextInt();
		return userDAO.login(loginId, pwd);
		
	}
	//���ع��ﳵ��Ϣ
	public void loadCartItem(User user){
		Map<Integer,CartItem>cartItemMap=cartItemDAO.getCartItemMap(user.getId());
		user.setCartItemMap(cartItemMap);
	}
	
	//��ʾ���˵�
	public int showMainMenu(){
		System.out.println("===========��ӭʹ��ˮ�����ϵͳ===============");
		System.out.println("1.�鿴ˮ���б�");
		System.out.println("2.���ˮ��");
		System.out.println("3.ˮ���¼�");
		System.out.println("4.�˳�");
		System.out.println("5.���յ���������ʾˮ���б�");
		System.out.println("6.���տ��������ʾˮ���б�");
		System.out.println("7.����");
		System.out.println("8.����");
		System.out.println("=========================================");
		System.out.print("��ѡ��");
		int slt = input.nextInt();
		return slt ;
	}
	
	//��ʾ����ˮ����Ϣ
	public void showFruitList(){
		List<Fruit>fruitList=fruitDAO.getFruitList();
		showFruitList(fruitList);
	}
	public void showFruitList(List<Fruit>fruitList){
		System.out.println("-----------------------------------------");
		System.out.println("����\t����\t�����\t��ע");
		if(fruitList==null || fruitList.size()<=0){
			System.out.println("�Բ��𣬿������û���κμ�¼��");
		}else{
			for(int i = 0 ; i<fruitList.size() ; i++){
				System.out.println(fruitList.get(i));
			}
		}
		System.out.println("-----------------------------------------");
	}
	
	//�˳�����
	public boolean exit(){
		System.out.print("�Ƿ�ȷ���˳���(Y/N)");
		String slt = input.next() ;
		boolean flag = !"Y".equalsIgnoreCase(slt) ;
		if(!flag){
			saveCart();
		}
		return flag ;
	}
	//���湺�ﳵ
	private void saveCart(){
		Map<Integer,CartItem>cartItemMap=currUser.getCartItemMap();
		if(cartItemMap!=null  && cartItemMap.size()>0){
			Set<Integer>keys=cartItemMap.keySet();
			Iterator<Integer> keyItor=keys.iterator();
			while(keyItor.hasNext()){
				Integer key=keyItor.next();
				CartItem cartItem=cartItemMap.get(key);
				cartItemDAO.addCartItem(cartItem);
			}
	}
	}
	
	//�����ˮ��
	public void addFruit(){
		System.out.print("���������ƣ�");
		String name = input.next();
		
		//�ж�name��Ӧ��ˮ���Ƿ����
		Fruit fruit=fruitDAO.getFruitByName(name);
		if(fruit==null){
			System.out.print("�����뵥�ۣ�");
			double price = input.nextDouble() ;
			System.out.print("������������");
			int count = input.nextInt() ;
			System.out.print("�����뱸ע��");
			String remark = input.next() ;
			
			 fruit = new Fruit(name , price , count , remark );
			boolean addFlag=fruitDAO.addFruit(fruit);
			System.out.println(addFlag?"��ӳɹ���":"���ʧ�ܣ�");
		}else{
			System.out.print("������׷�ӵĿ����:");
			int count = input.nextInt() ;
			fruit.setCount(fruit.getCount()+count);
			boolean updateFlag=fruitDAO.updateFruit(fruit);
			System.out.println(updateFlag?"�޸ĳɹ���":"�޸�ʧ�ܣ�");
		}	
		
	}
	
	
	//ˮ���¼�
	public void delFruit(){
		System.out.print("�������¼ܵ�ˮ�����ƣ�");
		String name = input.next() ;
		Fruit fruit=fruitDAO.getFruitByName(name);
		if(fruit==null){
			System.out.println("�Բ���ָ����ˮ�������ڣ�");
		}else{
			System.out.print("�Ƿ�ȷ���¼ܣ�(Y/N)");
			String slt = input.next() ;
			if("Y".equalsIgnoreCase(slt)){			//size:5
				boolean delFlag=fruitDAO.delFruit(fruit.getId());
				System.out.println(delFlag?"�¼ܳɹ���":"�¼�ʧ�ܣ�");
			}
		}
	}
	
	//���յ���������ʾˮ���б�
	public void showFruitListByPriceAsc(){
		List<Fruit>fruitList=fruitDAO.getFruitListAsc();
		showFruitList(fruitList);
	}
	
	//���տ�潵����ʾˮ���б�
	
	//����
	public void shopping(){
		System.out.print("��������Ʒ���ƣ�");
		String name = input.next() ;
		Fruit fruit=fruitDAO.getFruitByName(name);
		if(fruit==null){
			System.out.println("�Բ���û������Ҫ����Ʒ��");
		}else{		
			System.out.println(fruit);
			int buyCount = 0 ;
			do{
				System.out.print("�����빺�������:");
				buyCount = input.nextInt() ;
				if( buyCount > fruit.getCount() ){
					System.out.print("����������㣡");
				}else{
					break;
				}
			}while(true);
			
			Map<Integer,CartItem> cartItemMap = currUser.getCartItemMap();
			
			//��ȡ��ǰ�û��Ĺ��������
			if(cartItemMap.containsKey(fruit.getId())){
				//˵�����û�ӵ�иù����,ͨ��fruit��ID�ҵ������
				CartItem cartItem = cartItemMap.get(fruit.getId());
				//�޸Ĵ����ϱ�ע������
				cartItem.setCount(cartItem.getCount() + buyCount) ;
			}else{
				//����û�д��������Ʒ�ķ����
				CartItem cartItem = new CartItem(currUser,fruit,buyCount);
				cartItemMap.put(fruit.getId(), cartItem);
			}
			System.out.println("�ɹ���ӵ����ﳵ��");
		}
	}
	
	//����
	public void pay(){
		System.out.println("����\t����\t��������\tС��");
		if(currUser.getCartItemMap()==null ||   currUser.getCartItemMap().size()==0){
			System.out.println("��û�й����κ���Ʒ��");
		}else{
			Map<Integer,CartItem> cartItemMap = currUser.getCartItemMap();

			Set<Integer> keys = cartItemMap.keySet();
			double sum=0;
			Iterator<Integer> keyItor = keys.iterator();
			while(keyItor.hasNext()){
				Integer key = keyItor.next();
				CartItem cartItem = cartItemMap.get(key);
				Fruit fruit = cartItem.getFruit();
				int buyCount = cartItem.getCount() ;
				double xj = fruit.getPrice() *buyCount ;
				sum=sum+xj;
				System.out.println(fruit.getName()+"\t"+fruit.getPrice()+"\t"+buyCount+"\t"+xj);
			}
			System.out.print("�Ƿ���ˣ�(Y/N)");
			String slt = input.next() ;
			if("Y".equalsIgnoreCase(slt)){
				//�½�һ������
				OrderBean orderBean=new OrderBean();
				orderBean.setTotal(sum);
				orderBean.setOrderDate(new Date());
				orderBean.setUser(currUser);
				int orderId=orderDAO.addOrderBean(orderBean);
				orderBean.setId(orderId);
				//��������������ڴ�
				orderBean.setId(orderId);//��������ŷ����ڴ�	
				
				cartItemMap = currUser.getCartItemMap();								
				keys = cartItemMap.keySet();
				keyItor = keys.iterator();		
				while(keyItor.hasNext()){
					Integer key=keyItor.next();
					CartItem cartItem=cartItemMap.get(key);	
					Fruit fruit =cartItem.getFruit();
					int buyCount =cartItem.getCount();
					//����һ����������
					OrderItem orderItem=new OrderItem();
					orderItem.setCount(buyCount);
					orderItem.setFruit(fruit);
					orderItem.setOrderBean(orderBean);
					//����Щ��������������ݿ�
					orderItemDAO.addOrderItem(orderItem);
					//���(���ݿ�)���ﳵ,ͨ���������ID�ҵ��������ݿ�ɾ��
					cartItemDAO.delCartItem(cartItem.getId());
					//���¿��
					fruit=fruitDAO.getFruit(fruit.getId());//ͨ��ˮ����ID�ҵ���ˮ��
					fruit.setCount(fruit.getCount()-buyCount);
					fruitDAO.updateFruit(fruit);
				}
				//���(�ڴ�)���ﳵ
				currUser.getCartItemMap().clear();
				System.out.println("���˳ɹ���");
			}
		}
		System.out.println("----------------------------------");
	}
	//���涩��������Ϣ�����ݿ�
	private void saveData(){
		Map<Integer,CartItem> cartItemMap = currUser.getCartItemMap();
		if(cartItemMap!=null&&cartItemMap.size()>0);{
			Set<Integer> keys = cartItemMap.keySet();
		    Iterator<Integer> keyItor = keys.iterator();		
			while(keyItor.hasNext()){
			Integer key = keyItor.next();
			CartItem cartItem = cartItemMap.get(key);		
			
			cartItemDAO.addCartItem(cartItem);
		
		}
			
		}
		
	}

	
}
