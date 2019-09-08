package com.accp.demo;

public class ChickenWingFactory  implements IFactory{

	@Override
	public IChickenWing getChickenWing(String name) {
		if("kfc".equals(name)) {
			return new KFCChickenWing();
		}else if("M".equals(name)) {
			return new MChickenWing();
		}
		return null;
	}

}
