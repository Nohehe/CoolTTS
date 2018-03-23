package com.errison.tom.tts.parse;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.errison.tom.tts.utils.FileUtils;
import com.errison.tom.tts.utils.StringUtils;


/**
 * Get the pronunciation of a word or letter
 *
 */
public class PronunciationParser {
	
	private HashMap<String, String> pronounceFileMap = new HashMap<String, String>();

	private  String mapFile;

	public PronunciationParser(String pronunciationMapFile) throws Exception{
		mapFile = pronunciationMapFile;
		initMap();
	}
	
	private void initMap() throws Exception{
		String pronunciations = FileUtils.readWholeFile(mapFile);
		pronounceFileMap = JSON.parseObject(pronunciations, new TypeReference<HashMap<String,String>>() {});
	}
	
	public String getPronunciation(String key){
		return StringUtils.formatAudioFileName(pronounceFileMap.get(key));
	}

}
