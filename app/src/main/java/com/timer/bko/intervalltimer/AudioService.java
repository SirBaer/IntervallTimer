package com.timer.bko.intervalltimer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class AudioService extends Service implements  MediaPlayer.OnPreparedListener {

    public static final String ACTION = "ACTION";
    public static final String SPEAK = "SPEAK";
    public static final String START = "START";
    public static final String STOP = "STOP";
    public static final String PAUSE = "PAUSE";

//    private TextToSpeech textToSpeech;

    private boolean ttsInitialized = false;

    public AudioService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate()");
        //textToSpeech = new TextToSpeech(getApplicationContext(), this);
    }

    @Override
    public void onDestroy() {
//        textToSpeech.stop();
//        textToSpeech.shutdown();
//        ttsInitialized = false;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String actionString = intent.getStringExtra(ACTION);
        switch (actionString) {
            case SPEAK: {
                break;
            }
            case START: {
                break;
            }
            case STOP: {
                break;
            }
            case PAUSE: {
                break;
            }
            default:
        }

        return START_NOT_STICKY;
    }


    private void speak(String announcement) {
//        final int speak = textToSpeech.speak(announcement, TextToSpeech.QUEUE_ADD, null, null);
//        if(ttsInitialized) {
//            if(null != textToSpeech) {
//            }
//        }
    }
//
//    @Override
//    public void onInit(int status) {
//        if (status != TextToSpeech.ERROR) {
//            textToSpeech.setLanguage(Locale.GERMANY);
//            ttsInitialized = true;
//        }
//    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}
