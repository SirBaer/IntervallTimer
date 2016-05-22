package com.timer.bko.intervalltimer;

import com.timer.bko.intervalltimer.tasks.ITask;

import java.util.List;

/**
 * Created by bko on 17.05.2016.
 */
public class TaskLoop implements Runnable {

    private Object lock = new Object();
    private List<ITask> taskList;

    public TaskLoop(List<ITask> aTaskList) {
        this.taskList = aTaskList;
    }

    @Override
    public void run() {
        for (ITask currentTask : this.taskList) {
            currentTask.execute();
        }
    }
}