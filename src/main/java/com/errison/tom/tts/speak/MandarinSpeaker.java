package com.errison.tom.tts.speak;


import java.io.File;

import com.errison.tom.tts.audio.AudioFilePlayer;
import com.errison.tom.tts.audio.CommonAudioFilePlayer;
import com.errison.tom.tts.parse.LineParser;
import com.errison.tom.tts.parse.AudioFileParser;
import com.errison.tom.tts.parse.PronunciationParser;
import com.errison.tom.tts.utils.FileUtils;

public class MandarinSpeaker implements LanguageSpeaker {
	
	private PronunciationParser pronunciationParser;
	
	private AudioFileParser audioFileParser;
	
	private AudioFilePlayer player;
	
	public MandarinSpeaker(){
		try {
			pronunciationParser = new 
					PronunciationParser(FileUtils.BASE_DIR + "zh.json");
			audioFileParser = new AudioFileParser(FileUtils.BASE_DIR + "zh_wav" + File.separator, ".wav");
			player = new CommonAudioFilePlayer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public void speak(String text) {
		// TODO Auto-generated method stub
	    char[] chars = LineParser.parse(text);
		for(char ch: chars){
			speakAWord(String.valueOf(ch));
		}
	}
	
	private void speakAWord(String word){
		String pronunciation = pronunciationParser.getPronnuciation(word);
		String audioFile = audioFileParser.getOggFile(pronunciation);
		player.play(audioFile);
	}
	
	public static void main(String[] args) {
		MandarinSpeaker speaker = new MandarinSpeaker();
		speaker.speak("张小宝你在干什么哈哈哈");

	}

}
