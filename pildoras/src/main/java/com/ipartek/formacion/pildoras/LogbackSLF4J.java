package com.ipartek.formacion.pildoras;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//https://www.baeldung.com/spring-boot-logging

public class LogbackSLF4J {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(LogbackSLF4J.class.getName());

		// assume SLF4J is bound to logback in the current environment
		//LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		// print logback's internal status
		//StatusPrinter.print(lc);

		logger.error("error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");
	}
}
