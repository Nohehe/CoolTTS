package com.errison.tom.tts.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class FileUtils {
	
	public static final String BASE_DIR = System.getProperty("user.dir") + File.separator
			+ "data" + File.separator;
	
	/**
	 * 读取整个文件 
	 * 
	 * @param file
	 * @return
	 */
	public static String readWholeFile(String file){
		StringBuilder sb = new StringBuilder();
		try {
			 BufferedReader br = new BufferedReader(new FileReader(file));
	         String s = null;
	         while((s = br.readLine())!=null){
	        	 sb.append(s);
	         }
	         br.close();    
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sb.toString();
	}
	

}
