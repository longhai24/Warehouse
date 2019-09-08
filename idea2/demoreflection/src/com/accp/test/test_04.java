package com.accp.test;

import java.util.Scanner;

import com.accp.dao.CommonDao;
import com.accp.entity.Book;
import com.accp.entity.depp;

public class test_04 {

	public static void main(String[] args) throws Exception {
		CommonDao dao = new CommonDao();
		Book b = new Book(3, "大海", "书籍");
		depp d = new depp(1, "", "大哥");
		// 查询
		 for (depp dd : dao.select(new depp().getClass())) {
			 System.out.println(dd.getNamed());
		 }
		// 删除
		// int i = dao.delete(d);
		// if(i>0) {
		// System.out.println("删除成功");
		// }
		// 新增
//		 int i = dao.into(d);
//		 if(i>0) {
//		 System.out.println("新增成功");
//		 }
		// 修改
//		int i = dao.update(d);
//		if (i > 0) {
//			System.out.println("修改成功");
//		}

	}

}
