package com.timer.bko.intervalltimer.tasks;

import android.content.Context;
import android.util.Log;

/**
 * Created by bko on 17.05.2016.
 */
public class WorkTask extends MusicTask {

    public WorkTask(Context aContext, int aDuration) {
        super(aContext);
        setDuration(aDuration);
    }

    @Override
    public void execute() {
        Log.d("WorkTask", "WorkTask start!");
        doBaseCycling();
        Log.d("WorkTask", "WorkTask stop!");
    }
}
