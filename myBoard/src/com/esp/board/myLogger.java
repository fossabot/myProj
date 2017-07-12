package com.esp.board;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myLogger {
	private static final Logger LOGGER = Logger.getLogger(myLogger.class.getName());
	private FileHandler fileHanlder;
	private static final myLogger instance = new myLogger();
	
	public myLogger() {
		addFileHandler(LOGGER);
	}
	
	public static myLogger getInstance() {
		return instance;
	}
	
	public static Logger getLogger () {
		return LOGGER;
	}

	private void addFileHandler(Logger logger2) {
		try {
			fileHanlder = new FileHandler(myLogger.class.getName() + ".log");
			
		} catch (SecurityException | IOException e) {
			LOGGER.log(Level.SEVERE, null, e);
		}
		
	}
}
