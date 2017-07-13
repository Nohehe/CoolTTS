package com.errison.tom.tts.parse;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.errison.tom.tts.utils.FileUtils;
import com.errison.tom.tts.utils.StringUtils;

public class PronunciationParser {
	
	private HashMap<String, String> pronunceFileMap = new HashMap<String, String>();

	private  String mapFile;

	public PronunciationParser(String pronuciationMapFile) throws Exception{
		mapFile = pronuciationMapFile;
		initMap();
	}
	
	private void initMap() throws Exception{
		String pronuceations = FileUtils.readWholeFile(mapFile);
		pronunceFileMap = JSON.parseObject(pronuceations, new TypeReference<HashMap<String,String>>() {});
	}
	
	public String getPronnuciation(String key){
		return StringUtils.formatOggFileName(pronunceFileMap.get(key));
	}

}
