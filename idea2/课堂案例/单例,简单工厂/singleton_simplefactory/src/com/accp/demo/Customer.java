package com.accp.demo;

public class Customer {

	public static void eatCW(String name) {
		IFactory factory=new ChickenWingFactory();
		IChickenWing cw=factory.getChickenWing(name);
		cw.showChickenWing();
	}
	
	public static void main(String[] args) {
		eatCW("Q");
	}

}
