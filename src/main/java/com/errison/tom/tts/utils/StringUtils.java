package com.errison.tom.tts.utils;

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

	/**
	 *
	 *
	 * @param src
	 * @return
	 */
	public static String formatAudioFileName(String src){
		if (!invalidStr(src)) {
			src = src.substring(2, src.length() - 2);
		}
		return src;
	}

}
