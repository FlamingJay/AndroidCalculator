package com.example.calculator.controler;

import android.content.Context;
import android.media.SoundPool;
import android.util.Log;

import java.util.HashMap;

public class SoundPlayer {
    private static final String TAG = "SoundPlayer";
    private static final int MAX_SOUNDS = 3;
    private Context appContext;
    private SoundPool soundPool;
    private HashMap<Integer,Integer> soundMap = new HashMap<>();

    public SoundPlayer(Context appContext) {
        this.appContext = appContext;
        soundPool = new SoundPool.Builder().setMaxStreams(MAX_SOUNDS).build();
    }

    /**
     * 播放音频
     * @param resId 音频文件 R.raw.xxx
     */
    public void play(int resId) {
        int soundID = soundPool.load(appContext, resId, 1);
        // 该方法防止sample not ready错误
        soundPool.setOnLoadCompleteListener((soundPool, sampleId, status) -> {
            int streamId = soundPool.play(
                    soundID,  //声音id
                    1, //左声道：0.0f ~ 1.0f
                    1, //右声道：0.0f ~ 1.0f
                    1, //播放优先级：0表示最低优先级
                    0, //循环模式：0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次
                    1);//播放速度：1是正常，范围从0~2
            soundMap.put(resId,streamId);
        });
    }

    /**
     * 停止
     * @param resId
     */
    public void stop(int resId) {
        if (soundPool != null) {
            Integer mStreamID = soundMap.get(resId);
            if(mStreamID != null){
                soundPool.stop(mStreamID);
            }
        }
    }

    /**
     * 资源释放
     */
    public void release() {
        Log.d(TAG, "Cleaning resources..");
        if (soundPool != null) {
            soundPool.autoPause();
            soundPool.release();
        }
    }


}
