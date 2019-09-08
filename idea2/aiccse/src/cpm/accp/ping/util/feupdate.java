package cpm.accp.ping.util;

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
	String path = "/static/dynamic/";
	String sfile = "";
	//获取服务器的文件转移的位置
	//将服务器中的当前项目根目录拼接/upload
	String url = req.getSession().getServletContext().getRealPath(path);
		//1、如何去提取文件
		/**
		 * 判别请求的类型数据结构是否是：Multipart
		 */
		boolean bol = ServletFileUpload.isMultipartContent(req);
		if(bol){
			//才能处理文件
			//在这个地方干事
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//他干事：fileUpload：处理文件
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			//将请求内的内容转换成认识的内容
			try {
				//包含的请求中的所有内容数据，文件数据和文本数据
				List<FileItem> list = fileUpload.parseRequest(req);
				System.out.println(list);
				for(FileItem f : list){
					//区分文件和非文件
					//true:表示非文件，false表示文件
					if(f.isFormField()){
//						文本
//						String value = new String(f.getString().getBytes("iso-8859-1"),"utf-8");
//						System.out.println(value+"输出的值"+f.getFieldName());
//						if(f.getFieldName().equals("name")){
//							song.setListName(value);
//						}
//						if(f.getFieldName().equals("share")){
//							song.setInfo(value);
//						}
						
					}else{
						//文件来了。。当时我需要转移，转移到浏览器（用户能看）能看到
						String name = f.getName();
						String uuid = UUID.randomUUID().toString();
						String sufxName = name.substring(name.lastIndexOf("."), name.length());
						//转到本项目的某个目录位置
						File file = new File(url+"/"+uuid+sufxName);
						try {
							f.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						sfile = path.substring(1,path.length())+uuid+sufxName;
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else{
			//处理不了文件
		}
		System.out.println("文件上传中......");
		return sfile;
	}
}
