package com.shenhai.say.util;

import org.apache.log4j.Logger;

public class LoggerUtil {
	private static Logger log=Logger.getRootLogger();
	public static void debug(String msg) {
		log.debug(msg);
	}

	public static void info(String msg) {
		log.info(msg);
	}

	public static void error(String msg, Throwable e) {
		log.error(msg, e);
	}


}
