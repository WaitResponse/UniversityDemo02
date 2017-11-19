package com.gem.javaee.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContext销毁了。。。");

	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContext被创建了。。。");
	}

}
