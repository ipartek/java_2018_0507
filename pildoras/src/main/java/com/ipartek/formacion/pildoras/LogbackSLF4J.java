package com.ipartek.formacion.pildoras;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class LogbackSLF4J {

	public static void main(String[] args) {
		 
		
		Logger logger = LoggerFactory.getLogger(LogbackSLF4J.class.getName());
		
		
		//LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		//StatusPrinter.print(lc);
		
		logger.error("Error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");
		
		

	}

}
