package com.gem.qqzone.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.qqzone.biz.TopicBiz;
import com.gem.qqzone.biz.TopicBizImpl;
import com.gem.qqzone.biz.UserBiz;
import com.gem.qqzone.biz.impl.UserBizImpl;
import com.gem.qqzone.pojo.Topic;
import com.gem.qqzone.pojo.User;
import com.gem.qqzone.util.StringUtil;

public class TopicServlet extends HttpServlet {
	
	private TopicBiz topicBiz = new TopicBizImpl();
	private UserBiz userBiz = new UserBizImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operate = request.getParameter("operate");
		if("topics".equals(operate)){
			topics(request,response);
		}else if("detail".equals(operate)){
			detail(request, response);
		}
	}
	
	private void topics(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uidStr = request.getParameter("uid");
		if(StringUtil.isNotEmpty(uidStr)){
			int uid = Integer.parseInt(uidStr);
			User user = userBiz.getUser(uid);
			Set<Topic> topics = topicBiz.getTopics(user);
			user.setTopics(topics);
			request.getSession().setAttribute("currFriend", user);
			response.sendRedirect("frames/main.jsp");
		}
	}
	
	private void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Topic topic = topicBiz.getTopic(id);
		request.setAttribute("topic", topic);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
}