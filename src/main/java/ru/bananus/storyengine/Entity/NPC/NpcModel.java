package ru.bananus.storyengine.Entity.NPC;

import net.minecraft.util.ResourceLocation;
import ru.bananus.storyengine.StoryEngine;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NpcModel extends AnimatedGeoModel<NpcEntity> {
    @Override
    public ResourceLocation getModelLocation(NpcEntity object) {
        return new ResourceLocation(StoryEngine.MODID, "geo/alex.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(NpcEntity object) {
        return new ResourceLocation(StoryEngine.MODID, "textures/entity/npc.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(NpcEntity animatable) {
        return new ResourceLocation(StoryEngine.MODID, "animations/npc.animation_1.json");
    }
}
