package com.gem.qqzone.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.qqzone.biz.TopicBiz;
import com.gem.qqzone.biz.TopicBizImpl;
import com.gem.qqzone.biz.UserBiz;
import com.gem.qqzone.biz.impl.UserBizImpl;
import com.gem.qqzone.pojo.Topic;
import com.gem.qqzone.pojo.User;

public class IndexServlet extends HttpServlet{
	
	private UserBiz userBiz = new UserBizImpl();
	private TopicBiz topicBiz = new TopicBizImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operate = request.getParameter("operate");
		if("preIndex".equals(operate)){
			preIndex(request,response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	private void preIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		User currUser = (User) session.getAttribute("currUser");
		
		Set<User> friends = userBiz.getFriends(currUser);
		currUser.setFriends(friends);
		
		Set<Topic> topics = topicBiz.getTopics(currUser);
		currUser.setTopics(topics);
		
		session.setAttribute("currUser", currUser);			//currUser记录当前登录的用户
		session.setAttribute("currFriend", currUser);		//currFriend记录当前进入了谁的空间
		
		response.sendRedirect("index.jsp");
	}
	
}
