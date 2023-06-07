package ru.bananus.storyengine.Utils;

import java.util.ArrayList;
import java.util.List;

public class DelayedActions {
    List<Action> callbacks = new ArrayList<>();
    boolean Run = true;
    int idAction = 0;
    Thread thread;
    public DelayedActions(){
    }

    public void addNullTaskS(int second){
        callbacks.add(new Action(null, second*1000));
    }

    public void addNullTaskH(int hour){
        callbacks.add(new Action(null, hour*1000));
    }

    public void addNullTask(int millisecond){
        callbacks.add(new Action(null, millisecond));
    }
    public void add(Runnable func, int millisecond){
        callbacks.add(new Action(func, millisecond));
    }
    public void addS(Runnable func, int second){
        callbacks.add(new Action(func, second*1000));
    }
    public void stop(){
        this.Run = false;
    }
    public void exec(){
        thread = new Thread(()-> {
            while (Run) {
                Action action = callbacks.get(idAction);
                if (action.callback != null) {
                    action.callback.run();
                }
                try {
                    Thread.sleep(action.timer);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                idAction++;
                if (idAction == callbacks.size()) {
                    Run = false;
                    idAction = 0;
                }
            }
        });
        thread.start();
    }
}
