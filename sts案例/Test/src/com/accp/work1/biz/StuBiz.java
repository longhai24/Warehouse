package com.accp.work1.biz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.accp.work1.dao.StuDao;
import com.accp.work1.entity.Stu;
import com.accp.work1.util.MyComparator;

/**
 * 
* <p>Title: StuBiz</p>  
* <p>Description:业务逻辑操作类 </p>  
* @author Apple 

* @date 2019年4月2日
 */
	
 
public class StuBiz {
	private StuDao sd = new StuDao();
	
	public ArrayList<Stu> selectAllList(){
		return sd.selectAllList();
	}
	public ArrayList<Stu> NselectAllList(String tname){
		//获取未排序的集合
		ArrayList<Stu> list = sd.selectAllList();
		//调用util类的排序方法对未排序的集合进行排序
		Collections.sort(list, new MyComparator(tname));
		//返回排完序的集合
		return list;
	}

}
