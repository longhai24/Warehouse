package com.accp.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//url=>fe
public class feupdate extends HttpServlet {public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	doPost(req, resp);
}

public String sfile(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	String path = "/static/imgs/";
	String sfile = "";
	String url = req.getSession().getServletContext().getRealPath(path);
		boolean bol = ServletFileUpload.isMultipartContent(req);
		if(bol){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			try {
				List<FileItem> list = fileUpload.parseRequest(req);
				System.out.println(list);
				for(FileItem f : list){
					if(f.isFormField()){
//						设置字符编码
//						String value = new String(f.getString().getBytes("iso-8859-1"),"utf-8");
//						System.out.println(value+"�����ֵ"+f.getFieldName());
//						if(f.getFieldName().equals("name")){
//							song.setListName(value);
//						}
//						if(f.getFieldName().equals("share")){
//							song.setInfo(value);
//						}
						
					}else{
						String name = f.getName();
						String uuid = UUID.randomUUID().toString();
						String sufxName = name.substring(name.lastIndexOf("."), name.length());
						File file = new File(url+"/"+uuid+sufxName);
						try {
							f.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						sfile = path.substring(1,path.length())+uuid+sufxName;
						System.out.println("文件+"+sfile);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else{
		}
		System.out.println("文件上传中**********");
		return sfile;
	}
}
