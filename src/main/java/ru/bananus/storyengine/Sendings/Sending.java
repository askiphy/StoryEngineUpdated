package ru.bananus.storyengine.Sendings;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import ru.bananus.storyengine.Utils.DelayedActions;
import ru.bananus.storyengine.Voiceover.ModSoundEvents;

public class Sending {

    int id;
    String name;
    String text;

    public Sending(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public void showSending(PlayerEntity player) {
        player.getServer().getCommands().performCommand(player.createCommandSourceStack(), "/gamerule sendCommandFeedback false");
        player.getServer().getCommands().performCommand(player.createCommandSourceStack(), "/playsound storyengine:sending voice @a ~ ~ ~ 1 1");
        Minecraft.getInstance().gui.setOverlayMessage(new StringTextComponent("Пасхалка №" + id + " найдена!"), false);
        DelayedActions delayedActions = new DelayedActions();
        delayedActions.addS(() -> player.sendMessage(new StringTextComponent(TextFormatting.GOLD + "[Система пасхалок] " + TextFormatting.RESET + "Пасхалка №" + id + " найдена! Название: " + name), player.getUUID()), 2);
        delayedActions.addS(() -> player.sendMessage(new StringTextComponent(TextFormatting.GOLD + "[Система пасхалок] " + TextFormatting.RESET + text), player.getUUID()), 3);
        delayedActions.exec();
    }
}
