package com.errison.tom.tts.speak;


import java.io.File;
import java.util.List;

import com.errison.tom.tts.audio.AudioFilePlayer;
import com.errison.tom.tts.audio.MP3FilePlayer;
import com.errison.tom.tts.exception.ParseTextException;
import com.errison.tom.tts.exception.PlayAudioException;
import com.errison.tom.tts.parse.TextParser;
import com.hankcs.hanlp.dictionary.py.Pinyin;


/**
 * 普通话转语音
 *
 */
public class MandarinSpeaker implements LanguageSpeaker {


	
	private AudioFilePlayer player;
	
	public MandarinSpeaker(){

		player = new MP3FilePlayer();
		
	}

	public void speak(String text) {
	    try {
            List<Pinyin> pinyinList = TextParser.parse(text);
            for(Pinyin pinyin: pinyinList){
                speakAWord(pinyin.toString());
            }
        } catch (ParseTextException pte) {
            pte.printStackTrace();
        }catch (PlayAudioException pae){
	        pae.printStackTrace();
        }

    }
	
	private void speakAWord(String word) throws PlayAudioException {
		player.play(word);
	}
	
	public static void main(String[] args) {
		MandarinSpeaker speaker = new MandarinSpeaker();
		speaker.speak("歌未竟，东方白" );


	}

}
