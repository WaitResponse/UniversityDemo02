package com.gem.kfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.kfc.dao.CategoryDAO;
import com.gem.kfc.dao.GoodsDAO;
import com.gem.kfc.dao.Impl.CategoryDAOImpl;
import com.gem.kfc.dao.Impl.GoodsDAOImpl;
import com.gem.kfc.pojo.Category;
import com.gem.kfc.pojo.Goods;
import com.gem.kfc.util.StringUtil;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//response.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charSet=utf-8");
		String operate=request.getParameter("operate");
		if(operate.equals("preIndex")){
			preIndex(request,response);
		}else if(operate.equals("preMain")){
			preMain(request,response);
		}else if(operate.equals("exits")){
			exits(request,response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	}
	
	private void exits(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("currUser");//�ѵ�ǰ�û��ӻỰ���Ƴ�
		session.removeAttribute("cartItemMap");//�ѹ��ﳵ�ӻỰ���Ƴ�
		session.invalidate();//ʹ�Ự��Ч
		response.sendRedirect("login.jsp");//���˵���¼����
	}
	
	
	
	private void preIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		CategoryDAO categoryDAO=new CategoryDAOImpl();
		Set<Category> categories=categoryDAO.getCategories();
		session.setAttribute("categories",categories);

		//��ȡ������Ʒ�����������Ʒ
		GoodsDAO goodsDAO=new GoodsDAOImpl();
		Set<Goods>goodses=goodsDAO.getGoods();
		session.setAttribute("goodses", goodses);
		

		response.sendRedirect("index.jsp");
	}
	private void preMain(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String cidStr=request.getParameter("cid");
		int cid=0;
		if(StringUtil.isNotEmpty(cidStr)){
			cid=Integer.parseInt(cidStr);
		}
		GoodsDAO goodsDAO=new GoodsDAOImpl();
		Set<Goods>goodsSet=(cid==0?goodsDAO.getGoods():goodsDAO.getGoods(cid));
		session.setAttribute("goodses", goodsSet);
		
		response.sendRedirect("frame/main.jsp");
		
	}
	

}
