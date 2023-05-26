package ru.bananus.storyengine.Utils;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.bananus.storyengine.StoryEngine;

import java.util.List;

@Mod.EventBusSubscriber(modid = StoryEngine.MODID, value = Dist.CLIENT)
public
class Bind {

    static KeyAction executer;
    static List<Action> callbacks;
    static int idAction = 0;

    public Bind(KeyAction executer) {
        this.executer = executer;
        callbacks = executer.callbacks;
    }


    @SubscribeEvent
    public static void onKeyInput(InputEvent event) {
        if (ru.bananus.storyengine.Utils.Keybind.NPC_DIALOG.consumeClick()) {
            try {
                callbacks.get(idAction).callback.run();
                idAction++;
            } catch (IndexOutOfBoundsException e) {
                executer = null;
            }

        }
    }
}