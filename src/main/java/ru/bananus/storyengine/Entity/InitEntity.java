package ru.bananus.storyengine.Entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ru.bananus.storyengine.Entity.NPC.NpcEntity;
import ru.bananus.storyengine.StoryEngine;

public class InitEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, StoryEngine.MODID);

    public static final RegistryObject<EntityType<NpcEntity>> ASKIPHY =
            ENTITY_TYPES.register("askiphy",
                    () -> EntityType.Builder.of(NpcEntity::new, EntityClassification.CREATURE)
                            .build(new ResourceLocation(StoryEngine.MODID, "askiphy").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
