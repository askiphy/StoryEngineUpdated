package ru.bananus.storyengine.Scripts;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
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
import ru.bananus.storyengine.Voiceover.ModSoundEvents;

import java.io.Serializable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestScript {
    /*

    static PlayerEntity player;

    // Здесь пишутся диалоги

    @SubscribeEvent // Это обязательно для событий
    public void onBreak(BlockEvent.BreakEvent event) {
        player = event.getPlayer();
        event.setCanceled(true);
        player.level.playSound(player, player.getX(), player.getY(), player.getZ(), ModSoundEvents.VOICEOVER.get(), SoundCategory.VOICE, 1, 1);
    }
     */
}
