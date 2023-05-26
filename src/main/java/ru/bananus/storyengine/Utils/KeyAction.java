package ru.bananus.storyengine.Utils;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.bananus.storyengine.StoryEngine;

import java.util.ArrayList;
import java.util.List;

public class KeyAction {
    List<Action> callbacks = new ArrayList<>();
    Thread thread;
    public KeyAction(){
    }


    public void add(Runnable func){
        callbacks.add(new Action(func, 0));
    }
    public void exec(){
        new Bind(this);
    }
}

