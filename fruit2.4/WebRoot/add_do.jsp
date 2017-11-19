<%@page import="com.gem.fruit.pojo.Fruit"%>
<%@page import="com.gem.fruit.dao.Impl.FruitDAOImpl"%>
<%@page import="com.gem.fruit.dao.FruitDAO"%>
<%@page contentType="text/html;charset=utf-8"%>

<% 
	request.setCharacterEncoding("utf-8");
	String fname=request.getParameter("fname");
	int price=Integer.parseInt(request.getParameter("price"));
	int count=Integer.parseInt(request.getParameter("count"));
	String remark=request.getParameter("remark");
	Fruit fruit=new Fruit(fname,price,count,remark);
	
	FruitDAO fruitDAO=new FruitDAOImpl();
	boolean flag=fruitDAO.addFruit(fruit);
	
	out.println("<script language='javascript'>");
	out.println("alert('"+(flag ? "添加成功！" : "添加失败！")+"');");
	out.println("window.location.href='pre_index.jsp';");
	out.println("</script>");
	out.flush();

%>