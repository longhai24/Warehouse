package cpm.accp.ping.util;

public class PwdUilt {
	/**
	 * �����㷨
	 * @return
	 */
	public String jiapwd(String p) {
		int pwd = Integer.parseInt(p);
		pwd = (pwd+250)*2;
		System.out.println("ԭ����"+p+"���ܺ�"+pwd);
		return String.valueOf(pwd);
	}
	/**
	 * �����㷨
	 * @return
	 */
	public String jiepwd(String p) {
		int pwd = Integer.parseInt(p);
		pwd = pwd/2-250;
		System.out.println("ԭ����"+p+"����"+pwd);
		return String.valueOf(pwd);
	}
}
