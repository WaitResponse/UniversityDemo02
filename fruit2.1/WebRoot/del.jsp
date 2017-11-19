<%@page import="com.gem.fruit.pojo.Fruit"%>
<%@page import="com.gem.fruit.dao.Impl.FruitDAOImpl"%>
<%@page import="com.gem.fruit.dao.FruitDAO"%>
<%@page contentType="text/html;charset=utf-8"%>

<%
	String fidStr=request.getParameter("fid");
	if(fidStr==null||"".equals(fidStr)){
		response.sendRedirect("index.jsp");
	}else{
		int id=Integer.parseInt(fidStr);
		FruitDAO fruitDAO=new FruitDAOImpl();
		fruitDAO.delFruit(id);
		response.sendRedirect("index.jsp");
	}

%>