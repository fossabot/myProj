package com.esp.board;

public class VulnProtect {
	private static final VulnProtect instance = new VulnProtect();
	private String SecureArg;
	
	public static VulnProtect getInstance() {
		return instance;
	}
	
	public String test(String External_arg) {
		
		return SecureArg;
	}
}
