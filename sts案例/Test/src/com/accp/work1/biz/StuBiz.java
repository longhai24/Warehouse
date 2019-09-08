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
* <p>Description:ҵ���߼������� </p>  
* @author Apple 

* @date 2019��4��2��
 */
	
 
public class StuBiz {
	private StuDao sd = new StuDao();
	
	public ArrayList<Stu> selectAllList(){
		return sd.selectAllList();
	}
	public ArrayList<Stu> NselectAllList(String tname){
		//��ȡδ����ļ���
		ArrayList<Stu> list = sd.selectAllList();
		//����util������򷽷���δ����ļ��Ͻ�������
		Collections.sort(list, new MyComparator(tname));
		//����������ļ���
		return list;
	}

}
