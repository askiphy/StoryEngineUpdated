package ru.bananus.storyengine;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.bananus.storyengine.Dialog.Bench;
import ru.bananus.storyengine.Dialog.Dialog;
import ru.bananus.storyengine.Entity.InitEntity;
import ru.bananus.storyengine.Entity.NPC.NpcEntity;
import ru.bananus.storyengine.Entity.Story.NPCBuilder;
import ru.bananus.storyengine.Utils.StoryUtils;

import java.io.Serializable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventListener {

    @SubscribeEvent
    public static void RegisterAttributes(EntityAttributeCreationEvent event){
        event.put(InitEntity.ASKIPHY.get(), NpcEntity.setAttributes());
    }

}

