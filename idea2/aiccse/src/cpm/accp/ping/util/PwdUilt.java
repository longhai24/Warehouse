package cpm.accp.ping.util;

public class PwdUilt {
	/**
	 * 加密算法
	 * @return
	 */
	public String jiapwd(String p) {
		int pwd = Integer.parseInt(p);
		pwd = (pwd+250)*2;
		System.out.println("原密码"+p+"加密后"+pwd);
		return String.valueOf(pwd);
	}
	/**
	 * 解密算法
	 * @return
	 */
	public String jiepwd(String p) {
		int pwd = Integer.parseInt(p);
		pwd = pwd/2-250;
		System.out.println("原密码"+p+"解密"+pwd);
		return String.valueOf(pwd);
	}
}
