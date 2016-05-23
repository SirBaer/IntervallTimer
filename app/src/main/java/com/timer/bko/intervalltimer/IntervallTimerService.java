package com.timer.bko.intervalltimer;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.IBinder;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.timer.bko.intervalltimer.tasks.ITask;
import com.timer.bko.intervalltimer.tasks.WorkTask;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import static android.support.v4.app.ActivityCompat.requestPermissions;

public class IntervallTimerService extends Service {

    public static final String REPITITIONS = "REPITITIONS";
    public static final String PAUSE_TRACK = "PAUSE_TRACK";

    public static final String CURRENT_STATUS = "CURRENT_STATUS";
    public static final String STATUS_MESSAGE = "STATUS_MESSAGE";



    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate()");
    }

    @Override
    public void onDestroy() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int repetions = intent.getIntExtra(REPITITIONS, 0);

        Intent returnIntent = new Intent(STATUS_MESSAGE);
        returnIntent.putExtra(CURRENT_STATUS, "Started");
        sendBroadcast(returnIntent);
        Thread thread = new Thread(new TaskLoop(getWorkoutList(repetions)));
        thread.start();

        return START_NOT_STICKY;
    }

    private List<ITask> getWorkoutList(int aNumberOfSets) {
        List<ITask> workoutList = new LinkedList<ITask>();
        for(int i = 0; i <= aNumberOfSets; i++) {
            workoutList.add(new WorkTask(this.getApplicationContext(), 20));
            workoutList.add(new WorkTask(this.getApplicationContext(), 10));
        }
        return workoutList;
    }


}

