package ru.bananus.storyengine.Entity.NPC;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import ru.bananus.storyengine.StoryEngine;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class NpcRender extends GeoEntityRenderer<NpcEntity> {
    public NpcRender(EntityRendererManager renderManager) {
        super(renderManager, new NpcModel());
    }

    public ResourceLocation getEntityTexture(NpcEntity entity) {
        return new ResourceLocation(StoryEngine.MODID, "textures/entity/npc.png");
    }

}
