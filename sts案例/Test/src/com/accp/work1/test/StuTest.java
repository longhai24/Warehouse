package com.accp.work1.test;

import com.accp.work1.dao.StuDao;
import com.accp.work1.entity.Stu;

/**
 * 
* <p>Title: StuTest</p>  
* <p>Description:������ </p>  
* @author Apple 

* @date 2019��4��2��
 */
public class StuTest {

	/**
	 * 
	 * <p>Title: main</p>  
	 * <p>Description: </p>  
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuDao sdao = new StuDao();
		for (Stu sg : sdao.selectAllList()) {
			System.out.println(sg);
		}
	}

}
