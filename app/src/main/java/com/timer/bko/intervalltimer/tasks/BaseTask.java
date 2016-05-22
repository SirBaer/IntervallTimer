package com.timer.bko.intervalltimer.tasks;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by bko on 20.05.2016.
 */
public abstract class BaseTask implements ITask {
    private Object lock = new Object();
    int duration = 0;

    private Context context;

    BaseTask(Context aContext) {
        context = aContext;
    }

    public void setDuration(int aDurationInSeconds) {
        this.duration = aDurationInSeconds;
    }

    public int getDuration() {
        return this.duration;
    }

    protected void doBaseCycling() {
        try {
            for (int i = 0; i < this.duration; i++) {
                    Thread.sleep(1000);
                Intent returnIntent = new Intent("STATUS_MESSAGE");
                returnIntent.putExtra("CURRENT_STATUS", Integer.toString(i));
                this.context.sendBroadcast(returnIntent);
                    Log.d("doBaseCycling", "Iteration: " + Integer.toString(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
