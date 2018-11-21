package com.errison.tom.tts.parse;

import com.errison.tom.tts.exception.ParseTextException;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.py.Pinyin;

import java.util.List;

/**
 * 文本解析成语音
 */
public class TextParser {
	
	/**
	 * Get every char of Reading text
	 * 
	 * @param text
	 * @return
	 * @throws IllegalArgumentException	 text empty or null or too large
	 */
	public static List<Pinyin> parse(String text) throws ParseTextException{
		if (text == null || text.isEmpty()) {
			throw new ParseTextException("No readable words!");
		}
		if (text.length() > 500){
		    throw new ParseTextException("文本过大，请选择小一些的文本");
        }
        return HanLP.convertToPinyinList(text);
	}


}
