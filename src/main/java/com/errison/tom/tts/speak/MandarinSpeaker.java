package com.errison.tom.tts.speak;


import java.io.File;

import com.errison.tom.tts.audio.AudioFilePlayer;
import com.errison.tom.tts.audio.CommonAudioFilePlayer;
import com.errison.tom.tts.parse.LineParser;
import com.errison.tom.tts.parse.AudioFileParser;
import com.errison.tom.tts.parse.PronunciationParser;
import com.errison.tom.tts.utils.FileUtils;


/**
 * Mandarin tts
 */
public class MandarinSpeaker implements LanguageSpeaker {
	
	private PronunciationParser pronunciationParser;
	
	private AudioFileParser audioFileParser;
	
	private AudioFilePlayer player;
	
	public MandarinSpeaker(){
		try {
			pronunciationParser = new 
					PronunciationParser(FileUtils.RESOURCE_BASE +  "zh.json");
			audioFileParser = new AudioFileParser(FileUtils.RESOURCE_BASE + "zh_mp3" + File.separator, ".mp3");
			player = new CommonAudioFilePlayer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void speak(String text) {
	    char[] chars = LineParser.parse(text);
		for(char ch: chars){
			speakAWord(String.valueOf(ch));
		}
	}
	
	private void speakAWord(String word){
		String pronunciation = pronunciationParser.getPronunciation(word);
		String audioFile = audioFileParser.getAudioFile(pronunciation);
		player.play(audioFile);
	}
	
	public static void main(String[] args) {
		MandarinSpeaker speaker = new MandarinSpeaker();
		speaker.speak("歌未竟东方白" );

	}

}
