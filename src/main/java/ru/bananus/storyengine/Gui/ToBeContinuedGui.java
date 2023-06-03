package ru.bananus.storyengine.Gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import ru.bananus.storyengine.Dialog.Bench;
import ru.bananus.storyengine.Dialog.DialogGui;
import ru.bananus.storyengine.Network.Network;
import ru.bananus.storyengine.Network.Packets.SEndDialogPacket;
import ru.bananus.storyengine.StoryEngine;

import java.util.Objects;

public class ToBeContinuedGui extends Screen {

    ResourceLocation TBC = new ResourceLocation(StoryEngine.MODID, "textures/gui/tbc_gui.png");

    public ToBeContinuedGui() {
        super(new StringTextComponent("tbc"));
    }

    @Override
    protected void init() {
        super.init();
    }


    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        renderBackground(matrixStack);
        fillGradient(matrixStack, 0, 0, width, height, 0xFF_000000, 0xFF_000000);
        drawCenteredString(matrixStack, this.font, "Продолжение следует", this.width / 2, 85, 16777215);
        this.blit(matrixStack, this.width / 2 - 100, this.height / 2 - 100, 0, 0, 200, 200);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override
    public boolean isPauseScreen() {
        return true;
    }
}
