package ru.bananus.storyengine.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ru.bananus.storyengine.StoryEngine;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StoryEngine.MODID);


    public static final RegistryObject<Item> TEST = ITEMS.register("test",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
