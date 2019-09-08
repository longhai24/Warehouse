package com.tx.util;


import com.tx.pojo.tttr;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: apple
 * @date: 2019-05-30 16:09
 */
public class fw {
    public tttr sfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/image/";
        String sfile = "";
        tttr hou = new tttr();
        String url = req.getSession().getServletContext().getRealPath(path);
        boolean bol = ServletFileUpload.isMultipartContent(req);
        if (bol) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            try {
                List<FileItem> list = fileUpload.parseRequest(req);
                System.out.println(list);
                for (FileItem f : list) {
                    if (f.isFormField()) {
                        // 设置字符编码
                        String value = new String(f.getString().getBytes("iso-8859-1"), "utf-8");
						//投票标题
                        if (f.getFieldName().equals("title")) {
                            hou.setVotetitle(value);
						}
                        //投票介绍
                        if (f.getFieldName().equals("par")){
                            hou.setVoteparticulars(value);
                        }
                        //第一个选项
                        if (f.getFieldName().equals("va1")){
                            hou.setVoteoption1(value);
                            //第二个选项
                        }if (f.getFieldName().equals("va2")){
                            hou.setVoteoption2(value);
                          //第三个选项
                        }if (f.getFieldName().equals("va3")){
                            hou.setVoteoption3(value);
                        }
                        //第四个选项
                        if (f.getFieldName().equals("va4")){
                            hou.setVoteoption4(value);
                        }
                    } else {
                        String name = f.getName();
                        String uuid = UUID.randomUUID().toString();
                        String sufxName = name.substring(name.lastIndexOf("."), name.length());
                        File file = new File(url + "/" + uuid + sufxName);
                        try {
                            f.write(file);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
					hou.setVotepic(path.substring(1, path.length()) + uuid + sufxName);
                        System.out.println("文件+" + sfile);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
        }
        System.out.println("文件上传中**********");
        return hou;
    }
}
