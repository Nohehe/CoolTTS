package com.errison.tom.tts.audio;


import com.errison.tom.tts.exception.PlayAudioException;

public interface AudioFilePlayer {
	

	/**
	 * play a audio file
	 * @param file
	 */
	void play(String file) throws PlayAudioException;


    /**
     * play a list of audio file
     * @param files
     */
    void play(String[] files) throws PlayAudioException;

	
}
