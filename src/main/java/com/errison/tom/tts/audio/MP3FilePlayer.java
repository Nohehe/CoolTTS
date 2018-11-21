package com.errison.tom.tts.audio;

import com.errison.tom.tts.exception.PlayAudioException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * MP3格式语音文件播放器
 *
 */
public class MP3FilePlayer implements AudioFilePlayer {

    // MP3音频文件存储位置
    public static final String RESOURCE_BASE = new File("src/main/resources/audio_data/zh_mp3").getAbsolutePath();

    // MP3文件通用文件后缀
    private static final String MP3_SUFFIX = ".mp3";


    /**
     * play audio file ,just skip unknown pronunciation
     * @param pronunciation
     */
	public synchronized void play(String pronunciation) throws PlayAudioException{
        try {
            String path = getAudioFilePath(pronunciation);
            if (path == null)
                return;
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(path));
            Player player = new Player(buffer);
            player.play();
        } catch (FileNotFoundException e) {
            throw new PlayAudioException(e.getMessage());
        } catch (JavaLayerException e) {
            throw new PlayAudioException(e.getMessage());
        }
    }

    /**
     * 确认发音文件
     *
     * 空字符串和非中文字符不支持
     *
     * @param pronunciation
     * @return
     */
    private String getAudioFilePath(String pronunciation) {
        if (pronunciation == null || pronunciation.isEmpty() || pronunciation.startsWith("none"))
            return null;
        return (RESOURCE_BASE + File.separator + pronunciation + MP3_SUFFIX);
    }


    public void play(String[] files) throws PlayAudioException{
        for(String file : files){
            play(file);
        }
    }
	
}
