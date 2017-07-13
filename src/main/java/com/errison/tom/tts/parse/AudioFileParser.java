package com.errison.tom.tts.parse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.errison.tom.tts.utils.FileUtils;

public class AudioFileParser {

	private HashMap<String, String> wordPronuceMap = new HashMap<String, String>();
	
	private static final String mapFile = FileUtils.BASE_DIR + "zh_list";
	
	
	private String audioFileFolder;
	private String audioFileSuffix;

	public AudioFileParser(String folder, String suffix) throws IOException {
		this.audioFileFolder = folder;
		this.audioFileSuffix = suffix;
		initMap();
	}

	private void initMap() throws IOException {
		List<String> lines = org.apache.commons.io.FileUtils.readLines(new File(mapFile), "UTF-8");
		for (String line : lines) {
			addEntry(line);
		}
	}

	/**
	 * add word and pronunciation map entry
	 * 
	 * @param line
	 */
	private void addEntry(String line) {
		// invalid line
		if (line.startsWith("//") || line.startsWith("'$'")
				|| !line.contains("\t")) {
			return;
		}

		String[] contents = line.split("\t");
		if (contents != null && contents.length == 2) {
			// first comes word
			// second is its pronunciation
			wordPronuceMap.put(contents[0], contents[1]);
		}
	}
	
	
	/**
	 * get word's pronunciation ogg file
	 * @param pronunciation
	 * @return
	 */
	public String getOggFile(String pronunciation){
		return audioFileFolder + pronunciation + audioFileSuffix;
	}

}
