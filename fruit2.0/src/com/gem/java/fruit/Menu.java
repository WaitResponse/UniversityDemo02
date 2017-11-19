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
	//登录
	public User login(){
		System.out.print("账号:");
		String  loginId=input.next();
		System.out.print("密码:");
		int pwd=input.nextInt();
		return userDAO.login(loginId, pwd);
		
	}
	//加载购物车信息
	public void loadCartItem(User user){
		Map<Integer,CartItem>cartItemMap=cartItemDAO.getCartItemMap(user.getId());
		user.setCartItemMap(cartItemMap);
	}
	
	//显示主菜单
	public int showMainMenu(){
		System.out.println("===========欢迎使用水果库存系统===============");
		System.out.println("1.查看水果列表");
		System.out.println("2.添加水果");
		System.out.println("3.水果下架");
		System.out.println("4.退出");
		System.out.println("5.按照单价升序显示水果列表");
		System.out.println("6.按照库存升序显示水果列表");
		System.out.println("7.购物");
		System.out.println("8.结账");
		System.out.println("=========================================");
		System.out.print("请选择：");
		int slt = input.nextInt();
		return slt ;
	}
	
	//显示所有水果信息
	public void showFruitList(){
		List<Fruit>fruitList=fruitDAO.getFruitList();
		showFruitList(fruitList);
	}
	public void showFruitList(List<Fruit>fruitList){
		System.out.println("-----------------------------------------");
		System.out.println("名称\t单价\t库存量\t备注");
		if(fruitList==null || fruitList.size()<=0){
			System.out.println("对不起，库存里面没有任何记录！");
		}else{
			for(int i = 0 ; i<fruitList.size() ; i++){
				System.out.println(fruitList.get(i));
			}
		}
		System.out.println("-----------------------------------------");
	}
	
	//退出功能
	public boolean exit(){
		System.out.print("是否确认退出？(Y/N)");
		String slt = input.next() ;
		boolean flag = !"Y".equalsIgnoreCase(slt) ;
		if(!flag){
			saveCart();
		}
		return flag ;
	}
	//保存购物车
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
	
	//添加新水果
	public void addFruit(){
		System.out.print("请输入名称：");
		String name = input.next();
		
		//判断name对应的水果是否存在
		Fruit fruit=fruitDAO.getFruitByName(name);
		if(fruit==null){
			System.out.print("请输入单价：");
			double price = input.nextDouble() ;
			System.out.print("请输入库存量：");
			int count = input.nextInt() ;
			System.out.print("请输入备注：");
			String remark = input.next() ;
			
			 fruit = new Fruit(name , price , count , remark );
			boolean addFlag=fruitDAO.addFruit(fruit);
			System.out.println(addFlag?"添加成功！":"添加失败！");
		}else{
			System.out.print("请输入追加的库存量:");
			int count = input.nextInt() ;
			fruit.setCount(fruit.getCount()+count);
			boolean updateFlag=fruitDAO.updateFruit(fruit);
			System.out.println(updateFlag?"修改成功！":"修改失败！");
		}	
		
	}
	
	
	//水果下架
	public void delFruit(){
		System.out.print("请输入下架的水果名称：");
		String name = input.next() ;
		Fruit fruit=fruitDAO.getFruitByName(name);
		if(fruit==null){
			System.out.println("对不起，指定的水果不存在！");
		}else{
			System.out.print("是否确认下架？(Y/N)");
			String slt = input.next() ;
			if("Y".equalsIgnoreCase(slt)){			//size:5
				boolean delFlag=fruitDAO.delFruit(fruit.getId());
				System.out.println(delFlag?"下架成功！":"下架失败！");
			}
		}
	}
	
	//按照单价升序显示水果列表
	public void showFruitListByPriceAsc(){
		List<Fruit>fruitList=fruitDAO.getFruitListAsc();
		showFruitList(fruitList);
	}
	
	//按照库存降序显示水果列表
	
	//购物
	public void shopping(){
		System.out.print("请输入商品名称：");
		String name = input.next() ;
		Fruit fruit=fruitDAO.getFruitByName(name);
		if(fruit==null){
			System.out.println("对不起，没有你需要的商品！");
		}else{		
			System.out.println(fruit);
			int buyCount = 0 ;
			do{
				System.out.print("请输入购买的数量:");
				buyCount = input.nextInt() ;
				if( buyCount > fruit.getCount() ){
					System.out.print("土豪！少买点！");
				}else{
					break;
				}
			}while(true);
			
			Map<Integer,CartItem> cartItemMap = currUser.getCartItemMap();
			
			//获取当前用户的购物袋集合
			if(cartItemMap.containsKey(fruit.getId())){
				//说明该用户拥有该购物袋,通过fruit的ID找到购物袋
				CartItem cartItem = cartItemMap.get(fruit.getId());
				//修改袋子上标注的数量
				cartItem.setCount(cartItem.getCount() + buyCount) ;
			}else{
				//车中没有存放这种商品的方便袋
				CartItem cartItem = new CartItem(currUser,fruit,buyCount);
				cartItemMap.put(fruit.getId(), cartItem);
			}
			System.out.println("成功添加到购物车！");
		}
	}
	
	//结账
	public void pay(){
		System.out.println("名称\t单价\t购买数量\t小计");
		if(currUser.getCartItemMap()==null ||   currUser.getCartItemMap().size()==0){
			System.out.println("你没有购买任何商品！");
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
			System.out.print("是否结账？(Y/N)");
			String slt = input.next() ;
			if("Y".equalsIgnoreCase(slt)){
				//新建一条订单
				OrderBean orderBean=new OrderBean();
				orderBean.setTotal(sum);
				orderBean.setOrderDate(new Date());
				orderBean.setUser(currUser);
				int orderId=orderDAO.addOrderBean(orderBean);
				orderBean.setId(orderId);
				//将订单编号载入内存
				orderBean.setId(orderId);//将订单编号放入内存	
				
				cartItemMap = currUser.getCartItemMap();								
				keys = cartItemMap.keySet();
				keyItor = keys.iterator();		
				while(keyItor.hasNext()){
					Integer key=keyItor.next();
					CartItem cartItem=cartItemMap.get(key);	
					Fruit fruit =cartItem.getFruit();
					int buyCount =cartItem.getCount();
					//创建一条订单详情
					OrderItem orderItem=new OrderItem();
					orderItem.setCount(buyCount);
					orderItem.setFruit(fruit);
					orderItem.setOrderBean(orderBean);
					//把这些订单详情放入数据库
					orderItemDAO.addOrderItem(orderItem);
					//清空(数据库)购物车,通过购物袋的ID找到并从数据库删除
					cartItemDAO.delCartItem(cartItem.getId());
					//更新库存
					fruit=fruitDAO.getFruit(fruit.getId());//通过水果的ID找到该水果
					fruit.setCount(fruit.getCount()-buyCount);
					fruitDAO.updateFruit(fruit);
				}
				//清空(内存)购物车
				currUser.getCartItemMap().clear();
				System.out.println("结账成功！");
			}
		}
		System.out.println("----------------------------------");
	}
	//保存订单详情信息到数据库
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
