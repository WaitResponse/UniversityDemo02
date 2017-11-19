<%@page import="com.gem.fruit.util.StringUtil"%>
<%@page import="com.gem.fruit.pojo.Fruit"%>
<%@page import="java.util.List"%>
<%@page import="com.gem.fruit.dao.Impl.FruitDAOImpl"%>
<%@page import="com.gem.fruit.dao.FruitDAO"%>
<%@page contentType="text/html; charset=utf-8" %>

	
<%
	request.setCharacterEncoding("utf-8");
	int currPage=0;
	String keyword=null;
	String operate=request.getParameter("operate");
	if("search".equals(operate)){
		//说明点击的是查询按钮
		currPage=1;//默认显示第一页内容
		keyword=request.getParameter("keyword");
		//将新的关键字覆盖到保存作用域中，方便搜索框显示输入的关键字
		session.setAttribute("keyword", keyword);		
	}else{
		 //因为地址栏首先输入的是pre_index所以currPageStr为null，删除记录之后会再次获取当前页码
		String currPageStr=request.getParameter("currPage");
		if(StringUtil.isEmpty(currPageStr)){//判断request中的currpage是否为空
			currPage=1;
		}else{
			currPage=Integer.parseInt(currPageStr);//获取页码
		}
		Object keywordObj=session.getAttribute("keyword");
		if(keywordObj!=null){
			keyword=(String)keywordObj;
		}else{
			keyword="";
		}
	}
	
	//1.将当前页码保存到session中，便于index获取和发送页码数
	FruitDAO fruitDAO=new FruitDAOImpl();
	
	//2.获取总页数
	//2-1先获取总记录条数
	int count=fruitDAO.getFruitsCount(keyword);
	int pageSize=5;//每页最多5条记录
	//2-2计算总页数，删除记录之后再次计算总页数
	int pageCount=(count+pageSize-1)/pageSize;
	//3.将总页数保存到session中
	session.setAttribute("pageCount", pageCount);
	//删除记录之后如果当前页码大于总页数，确保删除之后不会出现最后一页显示"对不起没有数据"的情况
	if(currPage>pageCount){
		currPage--;
	}
	session.setAttribute("currPage", currPage);
	List<Fruit>fruitList=fruitDAO.getFruitList(keyword,pageSize, currPage);
	session.setAttribute("fruitList", fruitList);
	//地址栏输入pre_index立刻跳转到index
	response.sendRedirect("index.jsp");

	
%>