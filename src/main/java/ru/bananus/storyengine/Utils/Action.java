package ru.bananus.storyengine.Utils;

class Action{
    Runnable callback;
    int timer;
    public Action(Runnable callback, int timer){
        this.callback = callback;
        this.timer = timer;
    }
    @Override
    public String toString() {
        return "Action{" +
                "callback=" + callback +
                ", timer=" + timer +
                '}';
    }
}
