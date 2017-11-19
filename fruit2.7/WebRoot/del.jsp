<%@page import="com.gem.fruit.pojo.Fruit"%>
<%@page import="com.gem.fruit.dao.Impl.FruitDAOImpl"%>
<%@page import="com.gem.fruit.dao.FruitDAO"%>
<%@page contentType="text/html;charset=utf-8"%>

<%
//request.getPatameter用于获取发送某个页面发送的请求中的参数或表单post的内容，request.getAttribute用户获取存放在request中的内容
	String fidStr=request.getParameter("fid");
	if(fidStr==null||"".equals(fidStr)){
		response.sendRedirect("pre_index.jsp");//将响应发送给pre_index
	}else{
		int id=Integer.parseInt(fidStr);
		FruitDAO fruitDAO=new FruitDAOImpl();
		fruitDAO.delFruit(id);
		Object currPageObj=session.getAttribute("currPage");
		int currPage=0;
		if(currPageObj==null){
			currPage=1;
		}else{
			currPage=(Integer)currPageObj;
		}
		response.sendRedirect("pre_index.jsp?currPage="+currPage);
		
	}

%>