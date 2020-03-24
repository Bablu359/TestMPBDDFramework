package com.michaelpage.utils;

import org.apache.log4j.Logger;

public class LogFile {

	public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	
	

	// We can use it when starting tests
	public static void startLog(String testClassName) {
		APPLICATION_LOGS.info("Test is Starting...");
	}

	// We can use it when ending tests
	public static void endLog(String testClassName) {
		APPLICATION_LOGS.info("Test is Ending...");
	}

	// Info Level Logs
	public static void info(String message) {
		APPLICATION_LOGS.info(message);
	}

	// Warn Level Logs
	public static void warn(String message) {
		APPLICATION_LOGS.warn(message);
	}

	// Error Level Logs
	public static void error(String message) {
		APPLICATION_LOGS.error(message);
	}

	// Fatal Level Logs
	public static void fatal(String message) {
		APPLICATION_LOGS.fatal(message);
	}

	// Debug Level Logs
	public static void debug(String message) {
		APPLICATION_LOGS.debug(message);
	}

}
