package ru.bananus.storyengine.Entity.NPC;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import ru.bananus.storyengine.Dialog.Bench;
import ru.bananus.storyengine.Dialog.DialogGui;
import ru.bananus.storyengine.Network.Network;
import ru.bananus.storyengine.Network.Packets.SEndDialogPacket;

import java.util.Objects;

public class NpcEditorGui extends Screen {
    protected NpcEditorGui(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }

    int y = 50;

    @Override
    protected void init() {
        TextFieldWidget skin = new TextFieldWidget(font, this.width / 2 -75, this.height / + y, 1, 1, new StringTextComponent("Название скина"));
        this.addWidget(new TextFieldWidget(font, this.width / 2 -75, this.height / + y, 1, 1, new StringTextComponent("Название скина")));
        this.addWidget(new TextFieldWidget(font, this.width / 2 -75, this.height / + y, 1, 1, new StringTextComponent("Модель")));
        skin.tick();
        y+=35;
        super.init();
    }
}
