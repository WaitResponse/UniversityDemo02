package com.gem.fruit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.fruit.dao.FruitDAO;
import com.gem.fruit.dao.FruitDAOImpl;
import com.gem.fruit.pojo.Fruit;

public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter() ;
		
		//1.设置编码
		request.setCharacterEncoding("utf-8");

		//2.获取参数
		String idStr = request.getParameter("id");
		if(idStr!=null && !"".equals(idStr)){
			int id = Integer.parseInt(idStr);
			String fname = request.getParameter("fname");
			int price = Integer.parseInt(request.getParameter("price"));
			int count  = Integer.parseInt(request.getParameter("count"));
			String remark = request.getParameter("remark");
			Fruit fruit = new Fruit(id , fname , price , count , remark ) ;
			FruitDAO fruitDAO = new FruitDAOImpl();
			boolean flag = fruitDAO.updateFruit(fruit);
			//跳转到index.jsp页面
			//response.sendRedirect("index.jsp");
			
			out.println("<script language='javascript'>");
			out.println("alert('"+(flag? "修改成功！" : "修改失败!")+"');");
			out.println("window.location.href='preIndex.html';");
			out.println("</script>");
		}
	}

}
