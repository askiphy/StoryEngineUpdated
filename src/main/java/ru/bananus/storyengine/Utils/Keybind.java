package ru.bananus.storyengine.Utils;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class Keybind {
    public static final String KEY_CATEGORY_STORY = "key.category.storyengine.story";
    public static final String KEY_NPC = "key.storyengine.continue";

    public static final KeyBinding NPC_DIALOG = new KeyBinding(KEY_NPC, KeyConflictContext.IN_GAME,
            InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_STORY);
}
