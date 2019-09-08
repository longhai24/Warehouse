package com.accp.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class MarkAnnotationTest extends Object {

	@SuppressWarnings("all")
	@Deprecated
	public static void show() {
		@SuppressWarnings("all")
		int num = 0;
		List data = new ArrayList();
		
	}
	
	@Override
	public String toString() {
		return "重写";
	}
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		new MarkAnnotationTest().show();
	}

}
