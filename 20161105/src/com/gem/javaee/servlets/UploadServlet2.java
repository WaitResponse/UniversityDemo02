package com.gem.javaee.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet2 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//1.创建DiskFileItemFactory
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//2.创建ServletFileUpload
		ServletFileUpload fileUpload =new ServletFileUpload(factory);
		//3.解析Request(实质上就是分割解析字符串)
		try {
			List<FileItem>fileItemList=fileUpload.parseRequest(request);
			for(FileItem fileItem:fileItemList){
				if(fileItem.isFormField()){
					//普通的文本域
					String name=fileItem.getFieldName();
					String value=fileItem.getString();
				}else{
					//文件域(获得流，然后输出到磁盘上)
					InputStream is=fileItem.getInputStream();
					byte[] bytes=new byte[1024];
					int len=-1;
					
					String path=request.getSession().getServletContext().getRealPath("/");
					String name=fileItem.getName();
					String uuid=UUID.randomUUID().toString();
					//.substring是截取字符串的方法
					String fileName=path+"upload\\"+name.substring(0,name.lastIndexOf("."))+"_"+uuid+".jpg";
					System.out.println(fileName);
					try {
						fileItem.write(new File(fileName));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			
			}
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
