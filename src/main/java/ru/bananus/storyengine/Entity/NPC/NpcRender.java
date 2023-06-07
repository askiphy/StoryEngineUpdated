package ru.bananus.storyengine.Entity.NPC;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import ru.bananus.storyengine.StoryEngine;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class NpcRender extends GeoEntityRenderer<NpcEntity> {
    public NpcRender(EntityRendererManager renderManager) {
        super(renderManager, new NpcModel());
    }

    public ResourceLocation getEntityTexture(NpcEntity entity) {
        return new ResourceLocation(StoryEngine.MODID, "textures/entity/npc.png");
    }

}
