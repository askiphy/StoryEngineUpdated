package ru.bananus.storyengine.Scripts;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.bananus.storyengine.Dialog.Bench;
import ru.bananus.storyengine.Dialog.Dialog;
import ru.bananus.storyengine.Entity.InitEntity;
import ru.bananus.storyengine.Entity.NPC.NpcEntity;
import ru.bananus.storyengine.Entity.Story.NPCBuilder;
import ru.bananus.storyengine.Utils.DelayedActions;
import ru.bananus.storyengine.Utils.KeyAction;
import ru.bananus.storyengine.Utils.StoryUtils;


import java.io.Serializable;
import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Script {
    /*
    static PlayerEntity player;

    static Dialog negr = new Dialog("Привет. Как дела?", new Bench[] {
            new Bench("Норм",
                    new Dialog(1, (Serializable & Runnable) () -> {
                        DelayedActions delayedActions = new DelayedActions();
                        delayedActions.addS(() -> StoryUtils.sendMessage(player, "Аскипи", "У меня тоже"), 2);
                        delayedActions.exec();
                    })),

            new Bench("Замечательно! А у тебя?",
                    new Dialog(2, (Serializable & Runnable) () -> {
                        DelayedActions delayedActions = new DelayedActions();
                        delayedActions.addS(() -> StoryUtils.sendMessage(player, "Аскипи", "Тоже норм, кста я гей"), 2);
                        delayedActions.exec();
                    })),

            new Bench("Я гей!",
                    new Dialog(3, (Serializable & Runnable) () -> {
                        DelayedActions delayedActions = new DelayedActions();
                        delayedActions.addS(() -> StoryUtils.sendMessage(player, "Аскипи", "Я тоже, иди ко мне сладкий)"), 2);
                        delayedActions.exec();
                    })),
    });
    static Dialog dialog = new Dialog("Привет. Хочешь я создам NPC?", new Bench[]{
            new Bench("Да",
                    new Dialog(1, (Serializable & Runnable) ()-> {
                        NPCBuilder npc = new NPCBuilder(new NpcEntity(InitEntity.ASKIPHY.get(), player.level), new BlockPos(player.getX()-2, player.getY(), player.getZ()));
                        npc.moveEntity(new Vector3d(player.getX(), player.getY(), player.getZ()), 0.5f);
                        DelayedActions delayedActions = new DelayedActions();
                        delayedActions.addS(() -> StoryUtils.sendMessage(player, "Аскипи", "Привет. Как дела?"), 2);
                        delayedActions.addS(() -> negr.show(player), 2);
                        delayedActions.exec();
                    })),
            new Bench("Нет",
                    new Dialog(2, (Serializable & Runnable) () -> {
                        NPCBuilder npc = new NPCBuilder(new NpcEntity(InitEntity.ASKIPHY.get(), player.level), new BlockPos(player.getX()-8, player.getY(), player.getZ()));
                        DelayedActions delayedActions = new DelayedActions();
                        delayedActions.addS(() -> StoryUtils.sendMessage(player, "История", "А мне пофиг, я всё равно создам"), 2);
                        delayedActions.addS(() -> StoryUtils.sendMessage(player, "История", "Эй раб!"), 2);
                        delayedActions.addS(() -> StoryUtils.sendMessage(player, "Аскипи", "Да?"), 2);
                        delayedActions.addS(() -> StoryUtils.sendMessage(player, "История", "Иди сюда!"), 2);
                        delayedActions.addS(() -> npc.moveEntity(new Vector3d(player.getX(), player.getY(), player.getZ()), 0.5f), 2);
                        delayedActions.addS(() -> StoryUtils.sendMessage(player, "Подсказка", "Нажмите h"), 2);
                        delayedActions.exec();
                        KeyAction keyAction = new KeyAction();
                        keyAction.add(() -> StoryUtils.sendMessage(player, "Аскипи", "Привет! Как дела?"));
                        keyAction.add(() -> negr.show(player));
                        keyAction.exec();
                    }))});


    @SubscribeEvent
    public void onSleep(BlockEvent.BreakEvent event) {
        event.setCanceled(true);
        player = event.getPlayer();
        dialog.show(player);
    }
     */
}
