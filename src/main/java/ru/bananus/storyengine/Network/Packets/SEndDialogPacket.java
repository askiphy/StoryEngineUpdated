package ru.bananus.storyengine.Network.Packets;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import ru.bananus.storyengine.Dialog.Dialog;
import ru.bananus.storyengine.Network.Network;
import ru.bananus.storyengine.Utils.SerializableRunnable;

import java.util.function.Supplier;

public class SEndDialogPacket {
    private final String end;
    private final byte[] instance;
    public SEndDialogPacket(String end, byte[] instance) {
        this.end = end;
        this.instance = instance;
    }

    public SEndDialogPacket(PacketBuffer buf) {
        this.end = buf.readUtf();
        this.instance = buf.readByteArray();
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeUtf(end);
        buf.writeByteArray(instance);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            Dialog dialog = (Dialog) Network.toObj(this.instance);
            SerializableRunnable runnable = (SerializableRunnable) Network.toObj(dialog.runnable);
            runnable.run();
        });
        return true;
    }
}
