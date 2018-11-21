package com.errison.tom.tts.exception;

/***
 * 播放语音文件异常
 */
public class PlayAudioException extends  Exception{


    public PlayAudioException(){
        super();
    }

    public PlayAudioException(String message){
        super(message);
    }


}
