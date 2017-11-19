package conm.gem.java;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class HelloServlet extends GenericServlet{
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1){
		int count=1;
		count++;
		System.out.println("ÎÒÊÇÄãµù:"+count);		
	}
}