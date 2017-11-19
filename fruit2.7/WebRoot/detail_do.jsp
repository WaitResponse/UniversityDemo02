<%@page import="com.gem.fruit.pojo.Fruit"%>
<%@page import="com.gem.fruit.dao.Impl.FruitDAOImpl"%>
<%@page import="com.gem.fruit.dao.FruitDAO"%>
<%@page contentType="text/html;charset=utf-8"%>

<%
	String idStr=request.getParameter("id");
	if(idStr!=null&&!"".equals(idStr)){
		int id=Integer.parseInt(idStr);
		FruitDAO fruitDAO=new FruitDAOImpl();
		Fruit fruit=fruitDAO.getFruit(id);
		//将数据库找到的fruit保存在request里面
		request.setAttribute("fruit", fruit);
		
		//这里不能用客户端重定向，必须用服务器转发因为重定向会让客户端重新发一个请求,保存在上一个
		//request里面的fruit则会失效
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	//将request发送给detail然后获取detail的响应，将detail的内容展示出来，地址栏不发生变化
	}







%>