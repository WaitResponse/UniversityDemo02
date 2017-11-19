package com.gem.fruit.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.fruit.biz.FruitBiz;
import com.gem.fruit.biz.Impl.FruitBizImpl;
import com.gem.fruit.pojo.Fruit;
import com.gem.fruit.util.StringUtil;

public class PreIndexServlet extends HttpServlet {
	
	private FruitBiz fruitBiz=new FruitBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession() ;
		int currPage = 0 ;
		String keyword = null ;
		String currPageStr = request.getParameter("currPage");
		if(StringUtil.isEmpty(currPageStr)){//�ս����ģ�request��û��currPage
			currPage = 1 ;//���Ե�ǰ�ǵ�һҳ
		}else{
			currPage = Integer.parseInt(currPageStr);
		}
		Object keywordObj = session.getAttribute("keyword");
		if(keywordObj!=null){
			keyword = (String)keywordObj ;
		}else{
			keyword = "" ;//�ս���keywordObj��null
		}
		int pageSize = 5 ;
		int pageCount=fruitBiz.getPageCount(keyword, pageSize);	//ͨ���ؼ��֣���ÿҳ��ʾ��¼������ȡ��ҳ��
		session.setAttribute("pageCount", pageCount);
		
		if(currPage>pageCount){//�����ǰҳ�������ҳ��������ǰҳ����--����ɾ����ʱ�򣬵�ɾ�����һҳû�м�¼��ʱ���Զ�������һҳ
			currPage--;
		}

		session.setAttribute("currPage", currPage);
		
		List<Fruit> fruitList = fruitBiz.getFruitList(keyword, pageSize, currPage);
		session.setAttribute("fruitList", fruitList);
		response.sendRedirect("index.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)//�����ѯ����
			throws IOException, ServletException {
		HttpSession session = request.getSession() ;
		int currPage = 1 ;
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		session.setAttribute("keyword", keyword);
		
		int pageSize = 5 ;	
		int pageCount =fruitBiz.getPageCount(keyword, pageSize);
		session.setAttribute("pageCount", pageCount);

		if(currPage>pageCount){
			currPage--;
		}

		session.setAttribute("currPage", currPage);

		List<Fruit> fruitList = fruitBiz.getFruitList(keyword, pageSize, currPage);
				
		session.setAttribute("fruitList", fruitList);
		response.sendRedirect("index.jsp");
	}
}
/*
JSP����9�����ö���session,request,response,out,application
���ö�����jsp�в���Ҫnew�����ܹ�ֱ��ʹ�õĶ���������ö���

*/