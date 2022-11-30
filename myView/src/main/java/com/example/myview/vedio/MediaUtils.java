package com.example.myview.vedio;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

public class MediaUtils {

    public static MediaPlayer createMedia(Context context, String url){
        MediaPlayer mediaplayer = MediaPlayer.create(context, Uri.parse(url));
        mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        return mediaplayer;
    }
    public static MediaPlayer createMedia(Context context,int ResId){
        MediaPlayer mediaplayer = MediaPlayer.create(context,ResId);
        mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        return mediaplayer;
    }
    public static MediaPlayer createMedia(Context context, AssetFileDescriptor assetFileDescriptor){
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(
                    assetFileDescriptor.getFileDescriptor(),
                    assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength());/*使用MediaPlayer加载指定的声音文件.*/
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mediaPlayer;
    }
    public static void prepareMedia(MediaPlayer mediaplayer,
                                    MediaPlayer.OnPreparedListener onPreparedListener,
                                    MediaPlayer.OnErrorListener onErrorListener,
                                    MediaPlayer.OnCompletionListener onCompletionListener){
        mediaplayer.setOnPreparedListener(onPreparedListener);
        mediaplayer.setOnErrorListener(onErrorListener);
        mediaplayer.setOnCompletionListener(onCompletionListener);
        mediaplayer.prepareAsync();
    }

    //播放方法
    public static void play(MediaPlayer mediaplayer) {
        mediaplayer.start();
    }
    //暂停
    public static void pause(MediaPlayer mediaplayer) {
        mediaplayer.pause();
    }
    //判断是否正在播放中
    public static boolean isplay(MediaPlayer mediaplayer) {
        return mediaplayer.isPlaying();
    }
    //获取播放时长
    public static long getduring(MediaPlayer mediaplayer) {
        return mediaplayer.getDuration();
    }
    //获取当前的播放进度
    public static long getcurrentduring(MediaPlayer mediaplayer) {
        return mediaplayer.getCurrentPosition();
    }
    //获取位置
    public static int position(int current) {
        return current;
    }
    //更上进度，设置进度..
    public static void curento(int position, MediaPlayer mediaplayer) {
        mediaplayer.seekTo(position);
    }
    //关闭播放器
    public static void closeMedia(MediaPlayer mediaplayer) {
        if (mediaplayer != null) {
            mediaplayer.stop();
            mediaplayer.reset();
            mediaplayer.release();
            mediaplayer = null;
        }
    }
}