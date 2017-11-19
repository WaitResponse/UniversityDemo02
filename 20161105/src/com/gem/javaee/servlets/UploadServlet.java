package com.gem.javaee.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

public class UploadServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//1.����DiskFileItemFactory
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//2.����ServletFileUpload
		ServletFileUpload fileUpload =new ServletFileUpload(factory);
		//3.����Request(ʵ���Ͼ��Ƿָ�����ַ���)
		try {
			List<FileItem>fileItemList=fileUpload.parseRequest(request);
			for(FileItem fileItem:fileItemList){
				if(fileItem.isFormField()){
					//��ͨ���ı���
					String name=fileItem.getFieldName();
					String value=fileItem.getString();
				}else{
					//�ļ���(�������Ȼ�������������)
					InputStream is=fileItem.getInputStream();
					byte[] bytes=new byte[1024];
					int len=-1;
					String path=request.getSession().getServletContext().getRealPath("/");
					
					OutputStream os=new FileOutputStream(path+"upload/"+"hello"+"_"+UUID.randomUUID().toString()+".jpg");//Ĭ����D:\apache-tomcat-6.0.14\binĿ¼��
					while((len=is.read(bytes))!=-1){
						os.write(bytes,0,len);
					}
					os.flush();
				}
			
			}
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
