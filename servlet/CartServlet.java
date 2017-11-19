package com.gem.kfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.kfc.dao.AddressDAO;
import com.gem.kfc.dao.CartItemDAO;
import com.gem.kfc.dao.GoodsDAO;
import com.gem.kfc.dao.OrderBeanDAO;
import com.gem.kfc.dao.OrderItemDAO;
import com.gem.kfc.dao.Impl.AddressDAOImpl;
import com.gem.kfc.dao.Impl.CartItemDAOImpl;
import com.gem.kfc.dao.Impl.GoodsDAOImpl;
import com.gem.kfc.dao.Impl.OrderBeanDAOImpl;
import com.gem.kfc.dao.Impl.OrderItemDAOImpl;
import com.gem.kfc.pojo.CartItem;
import com.gem.kfc.pojo.Goods;
import com.gem.kfc.pojo.Order;
import com.gem.kfc.pojo.OrderItem;
import com.gem.kfc.pojo.User;
import com.gem.kfc.pojo.UserAddress;
import com.gem.kfc.util.StringUtil;

public class CartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String operate=request.getParameter("operate");
		if(operate.equals("toAddCart")){
			toAddCart(request,response);
		}else if(operate.equals("prePay")){
			prePay(request,response);
		}else if(operate.equals("Pay")){
			Pay(request,response);
		}else if(operate.equals("cartInfo")){
			cartInfo(request,response);
		}else if(operate.equals("delcart")){
			delcart(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		doGet(request,response);
			
	}
	
	private void delcart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		PrintWriter out=response.getWriter();
		
		
		CartItemDAO cartItemDAO=new CartItemDAOImpl();
		User user=(User)session.getAttribute("currUser");
		String gidStr=request.getParameter("gid");
		int gid=0;
		if(StringUtil.isNotEmpty(gidStr)){
			gid=Integer.parseInt(gidStr);
			boolean flag=cartItemDAO.delCartItem(gid);//从数据库中删除该条购买记录
			if(flag){//如果删除成功，更新购物车			
				Map<Integer,CartItem>cartItemMap=new HashMap<Integer,CartItem>();
				Set<CartItem>cartItemSet=cartItemDAO.getCartItem(user.getId());
				for(CartItem cartItem:cartItemSet){
					cartItemMap.put(cartItem.getGoods().getId(),cartItem);
				}
				session.setAttribute("cartItemMap",cartItemMap);
				response.sendRedirect("cart_detail.jsp");
			}else{
				out.println("<script language='javascript'>");
				out.println("alert('删除失败!')");
				out.println("window.location.href='cart_detail.jsp';");
				out.println("</script>");
			}
		}else{
			out.println("<script language='javascript'>");
			out.println("alert('删除失败!')");
			out.println("window.location.href='cart_detail.jsp';");
			out.println("</script>");
		}
		
	}
	
	
	private void toAddCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		CartItemDAO cartItemDAO=new CartItemDAOImpl();
		GoodsDAO goodsDAO=new GoodsDAOImpl();
		User user=(User)session.getAttribute("currUser");
		//1.获取商品Id,然后显示购物车
		String gidStr=request.getParameter("gid");
		int gid=0;
		if(StringUtil.isNotEmpty(gidStr)){
			gid=Integer.parseInt(gidStr);
			Object obj=session.getAttribute("cartItemMap");//sessoin没有cartItemMap,所有为null
			Map<Integer,CartItem>cartItemMap=null;
			if(obj==null){
				cartItemMap=new HashMap<Integer,CartItem>();//为空创建一个cartItemMap
			}else{
				cartItemMap=(Map<Integer,CartItem>)obj;
			}
			if(cartItemMap.containsKey(gid)){//判断购物车中是否存在对应商品Id的商品，如果存在获取对应的购物袋
				CartItem cartItem=cartItemMap.get(gid);
				cartItem.setCount(cartItem.getCount()+1);//购物袋数量加一
				cartItemDAO.updateCartItem(cartItem);//将修改后的购物袋存入数据库
			}else{//不存在对应的购物袋
				CartItem cartItem=new CartItem();//创建一个并把当前的购物袋属性放入内存
				Goods goods=new Goods(gid);
				cartItem.setGoods(goods);
				cartItem.setCount(1);
				cartItem.setUser(user);
				
				cartItem=cartItemDAO.addCartItem(cartItem);//把内存中的购物袋放入数据库
				cartItemMap.put(gid,cartItem);//把内存中的购物袋放入购物车
			}
			//从数据库加载未结账的购物信息
			Set<CartItem>cartItemSet=cartItemDAO.getCartItem(user.getId());
			cartItemMap=new HashMap<Integer,CartItem>();//创建一个购物车
			for(CartItem cartItem:cartItemSet){
				cartItemMap.put(cartItem.getGoods().getId(),cartItem);
			}
			session.setAttribute("cartItemMap", cartItemMap);
			
			response.sendRedirect("cart_detail.jsp");
		}else{//如果商品id为空,重新登录
			response.sendRedirect("login.jsp");
		}
		

	}
	
	private void prePay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("currUser");
		
		//2.加载用户 地址
		AddressDAO addressDAO=new AddressDAOImpl();
		Set<UserAddress>address=addressDAO.getAddress(user.getId());
		session.setAttribute("address",address);
		
		response.sendRedirect("to_pay.jsp");
	}
	
	private void Pay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		//1.获取当前购物车信息
		CartItemDAO cartItemDAO=new CartItemDAOImpl();
		//2.获取用户地址Id
		String addrIds=request.getParameter("addr");
		if(StringUtil.isNotEmpty(addrIds)){
			int addrId=Integer.parseInt(addrIds);
			//从session中获取购物车
			Map<Integer,CartItem>cartItemMap=(Map<Integer,CartItem>)session.getAttribute("cartItemMap");
			//创建一个订单，填充参数
			Order orderBean=new Order();
			User user=(User)session.getAttribute("currUser");
			orderBean.setUser(user);
			orderBean.setOrderDate(new Date());
			
			Collection<CartItem> cartItems=cartItemMap.values();
			int orderMoney=0;
			for(CartItem cartItem:cartItems){
				orderMoney=orderMoney+cartItem.getCount()*cartItem.getGoods().getPrice();
			}
			orderBean.setMoney(orderMoney);
			orderBean.setAddress(new UserAddress(addrId));
			//参数填充完毕，开始插入数据库
			OrderBeanDAO orderDAO=new OrderBeanDAOImpl();
			orderBean=orderDAO.addOrderBean(orderBean);//此时的orderBean只有id
			//向订单详情表插入订单信息
			for(CartItem ci:cartItems){
				OrderItem oi=new OrderItem();//订单详情放在循环里面表示有多条订单详情
				oi.setGoods(ci.getGoods());
				oi.setCount(ci.getCount());
				oi.setOrder(orderBean);
				
				OrderItemDAO orderItemDAO =new OrderItemDAOImpl();
				boolean flag=orderItemDAO.addOrderItem(oi);
				//如果订单详情插入成功，则清空对应的CartItem信息
				if(flag){
					cartItemDAO.delCartItem(ci.getGoods().getId());//这里因为在add_cart中把没有Id的购物袋放入CartItemMap，所以只能根据商品ID删除
				}
			}			
			response.sendRedirect("frame/main.jsp");
		}	
	}
	

	private void cartInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		User user=(User)session.getAttribute("currUser");
		CartItemDAO cartItemDAO=new CartItemDAOImpl();
		
		Set<CartItem>cartItemSet=cartItemDAO.getCartItem(user.getId());
		Map<Integer,CartItem> cartItemMap = new HashMap<Integer,CartItem>();
		for(CartItem cartItem : cartItemSet){
			cartItemMap.put(cartItem.getGoods().getId(), cartItem);
		}
		session.setAttribute("cartItemMap", cartItemMap);
		//跳转到购物车详情页面
		response.sendRedirect("cart_detail.jsp");
	}
	

}
