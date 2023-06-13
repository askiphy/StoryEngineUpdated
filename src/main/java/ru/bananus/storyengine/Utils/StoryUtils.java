package ru.bananus.storyengine.Utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class StoryUtils {

    public static void sendMessage(PlayerEntity player, String name, String text) {
        player.sendMessage(new StringTextComponent(TextFormatting.BLUE + "[" + name + "]" + TextFormatting.RESET + " " + text), player.getUUID());
    }

    public static void executeCommand(PlayerEntity player, String command) {
        player.getServer().getCommands().performCommand(player.createCommandSourceStack(), "/" + command);
    }
}
