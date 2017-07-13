package com.errison.tom.tts.parse;


public class LineParser {
	
	/**
	 * Get every char of Reading text
	 * 
	 * @param text
	 * @return
	 * @throws IllegalArgumentException	 text empty or null
	 */
	public static char[] parse(String text) throws IllegalArgumentException{
		if (text == null || text.isEmpty()) {
			throw new IllegalArgumentException("No readable words!");
		}
		return text.toCharArray();
	}
	
	

}
