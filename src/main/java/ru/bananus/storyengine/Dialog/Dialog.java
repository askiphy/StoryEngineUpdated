package ru.bananus.storyengine.Dialog;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import ru.bananus.storyengine.Network.Network;
import ru.bananus.storyengine.Network.Packets.SDialogPacket;
import ru.bananus.storyengine.Utils.SerializableRunnable;

import java.io.Serializable;
import java.util.Objects;

public class Dialog implements Serializable {
    String herosay;
    Bench[] benches;
    byte[] instance;
    public byte[] runnable;

    public Dialog(int id, Serializable runnable) {
        this.herosay = "end." + id;
        SerializableRunnable runnable1 = new SerializableRunnable(runnable);
        this.runnable = Network.toByte(runnable1);
        this.instance = Network.toByte(this);
    }

    public Dialog(String heroSay, Bench[] benches){
        this.herosay = heroSay;
        this.benches = benches;

    }


    public void show(PlayerEntity entity) {
        if (entity.level.isClientSide) {
            Minecraft minecraft = Minecraft.getInstance();
            minecraft.setScreen(new DialogGui(herosay, benches));
        }
        else {
            for (ServerPlayerEntity player : entity.getServer().getPlayerList().getPlayers()) {
                if (entity instanceof ServerPlayerEntity) {
                    Network.sendToPlayer(new SDialogPacket(herosay, Network.toByte(benches)), player);
                }
            }
        }
    }

    public String getSpeaker() {
        return herosay;
    }

}
