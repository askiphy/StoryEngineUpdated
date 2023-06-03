package ru.bananus.storyengine;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.bananus.storyengine.Entity.InitEntity;
import ru.bananus.storyengine.Entity.NPC.NpcEntity;

import java.util.List;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventListener {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(InitEntity.ASKIPHY.get(), NpcEntity.setAttributes());
    }


}

