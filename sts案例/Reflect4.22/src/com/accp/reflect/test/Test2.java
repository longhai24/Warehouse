package com.accp.reflect.test;

import java.lang.reflect.Method;

public class Test2 {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "       bcadefg              ";
		Class cla = num.getClass();
		try {
			
			Method clm = cla.getMethod("length");
			System.out.println(	"�ַ��ĳ��ȣ�"+clm.invoke(num));
			Method clm2 = cla.getMethod("indexOf", String.class);
			if ((int)clm2.invoke(num, "a") ==-1) {
				System.out.println("������a");
			}else {
				System.out.println("��a");
			}
			Method clm3 = cla.getMethod("trim");
			String num2 = (String)clm3.invoke(num);
			System.out.println("ȥ���ַ���ǰ��"+num);
			System.out.println("ȥ���ַ�����"+num2);
			System.out.println("���ַ��ĳ���"+clm.invoke(num2));
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
