package com.errison.tom.tts.audio;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CommonAudioFilePlayer implements AudioFilePlayer {
	
	// size of the byte buffer used to read/write the audio stream
    private static final int BUFFER_SIZE = 4096;

	public void play(String[] files) {
		for(String file : files){
			play(file);
		}
	}

    /**
     * play audio file ,just skip unknown pronunciation
     * @param filePath
     */
	public synchronized void play(String filePath) {
        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filePath));
            Player player = new Player(buffer);
            player.play();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
	
	
}
