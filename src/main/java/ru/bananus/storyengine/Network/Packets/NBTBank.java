package ru.bananus.storyengine.Network.Packets;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fml.network.PacketDistributor;
import ru.bananus.storyengine.Network.Network;

import java.util.Set;
import java.util.UUID;

public class NBTBank {
    public static enum Type {
        STRING,
        DOUBLE,
        INT,
        UUID
    }

    private final CompoundNBT clientData = new CompoundNBT();

    public void postOnClient(String nbt, Object val, Type type) {
        switch(type) {
            case STRING:
                clientData.putString(nbt, (String) val);
                break;
            case DOUBLE:
                clientData.putDouble(nbt, (double) val);
                break;
            case INT:
                clientData.putInt(nbt, (int) val);
                break;
            case UUID:
                clientData.putUUID(nbt, (UUID) val);
                break;
        }
    }

    public void flush(Entity entity) {
        Set<String> keys = clientData.getAllKeys();
        if(keys.size() == 0) return;
        String[] clientKeys = keys.toArray(new String[0]);
        Network.sendToPlayer(PacketDistributor.TRACKING_ENTITY.with(() -> entity), (PlayerEntity) entity);
        for(String cKey : clientKeys) clientData.remove(cKey);
    }
}
