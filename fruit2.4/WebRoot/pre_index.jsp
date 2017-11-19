<%@page import="com.gem.fruit.util.StringUtil"%>
<%@page import="com.gem.fruit.pojo.Fruit"%>
<%@page import="java.util.List"%>
<%@page import="com.gem.fruit.dao.Impl.FruitDAOImpl"%>
<%@page import="com.gem.fruit.dao.FruitDAO"%>
<%@page contentType="text/html; charset=utf-8" %>

	
<%
	String currPageStr=request.getParameter("currPage");//因为地址栏首先输入的是pre_index所以currPageStr为null
	int currPage=0;
	if(StringUtil.isEmpty(currPageStr)){//判断request中的currpage是否为空
		currPage=1;
	}else{
		currPage=Integer.parseInt(currPageStr);//获取页码
	}
	//1.将当前页码保存到session中，便于index获取和发送页码数
	session.setAttribute("currPage", currPage);
	FruitDAO fruitDAO=new FruitDAOImpl();
	
	//2.获取总页数
	//2-1先获取总记录条数
	int count=fruitDAO.getFruitsCount();
	int pageSize=5;//每页最多5条记录
	//2-2计算总页数
	int pageCount=(count+pageSize-1)/pageSize;
	//3.将总页数保存到session中
	session.setAttribute("pageCount", pageCount);
	
	List<Fruit>fruitList=fruitDAO.getFruitList(pageSize, currPage);
	session.setAttribute("fruitList", fruitList);
	//地址栏输入pre_index立刻跳转到index
	response.sendRedirect("index.jsp");

	
%>