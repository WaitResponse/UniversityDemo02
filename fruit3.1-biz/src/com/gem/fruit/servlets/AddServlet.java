package com.gem.fruit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.fruit.biz.FruitBiz;
import com.gem.fruit.biz.Impl.FruitBizImpl;
import com.gem.fruit.pojo.Fruit;

public class AddServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	//�ң������������͸��㣨�ͻ��ˣ������ݵ���ʵ����
		response.setContentType("text/html;charset=utf-8");//�Ҹ������ҷ��͸������text/html�����ݣ�������utf-8������ʾ��
		PrintWriter out = response.getWriter() ;
		
		request.setCharacterEncoding("utf-8");
		String fname = request.getParameter("fname");
		int price = Integer.parseInt(request.getParameter("price"));
		int count = Integer.parseInt(request.getParameter("count"));
		String remark = request.getParameter("remark");
		
		Fruit fruit = new Fruit(fname , price , count , remark );
		
		FruitBiz fruitBiz=new FruitBizImpl();
		boolean flag = fruitBiz.addFruit(fruit);
		
		out.println("<script language='javascript'>");
		out.println("alert('"+(flag ? "��ӳɹ���" : "���ʧ�ܣ�")+"');");
		out.println("window.location.href='preIndex.html';");
		out.println("</script>");
		out.flush();
	}
	
}
