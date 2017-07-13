package com.errison.tom.tts.audio;


public interface AudioFilePlayer {
	
	/**
	 * play a list of audio file
	 * @param files
	 */
	public void play(String[] files);
	
	/**
	 * play a audio file
	 * @param file
	 */
	public void play(String file);
	
}
