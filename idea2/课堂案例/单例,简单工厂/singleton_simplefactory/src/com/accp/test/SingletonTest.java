package com.accp.test;

import com.accp.singleton.Person;

public class SingletonTest {

	public static void main(String[] args) {
		// 匿名子类
		new Thread() {
			@Override
			public void run() {
				Person person1 = Person.getInstance();
				//........
				person1.showInfo();
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				Person person2 = Person.getInstance();
				person2.showInfo();
			}
		}.start();

	}
}
