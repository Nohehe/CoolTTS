package com.errison.tom.tts.utils;

/**
 * 字符工具类
 *
 */
public class StringUtils {
	
	
	public static String excludeNoneReadable(String string){
		if (invalidStr(string)) {
			return string;
		}
		return string.replaceAll("^[a-zA-Z0-9\u4E00-\u9FA5]+$", "");
	}
	
	public static String excludeNum(String string){
		if (invalidStr(string)) {
			return string;
		}
		return string.replaceAll("[^0-9]", "");
	}
	
	public static String excludeLetter(String string){
		if (invalidStr(string)) {
			return string;
		}
		return string.replaceAll("[^a-zA-Z]", "");
	}
	
	public static boolean invalidStr(String string){
		return string == null || string.isEmpty();
	}



}
