package co.nidmight.blighttweaks.common.network;

import co.nidmight.blighttweaks.BTStrings;
import co.nidmight.blighttweaks.common.network.handler.ArmorBoostPacketHandler;
import co.nidmight.blighttweaks.common.network.packet.ToggleArmorBoost;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import io.netty.channel.ChannelHandler;

@ChannelHandler.Sharable
public class BlightCoreNetwork {

    private static final BlightCoreNetwork INSTANCE = new BlightCoreNetwork();
    private SimpleNetworkWrapper networkWrapper;

    public static void init() {
        INSTANCE.networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(BTStrings.MOD_ID);
        INSTANCE.networkWrapper.registerMessage(ArmorBoostPacketHandler.class, ToggleArmorBoost.class, 0, Side.SERVER);

        FMLCommonHandler.instance()
            .bus()
            .register(INSTANCE);
    }

    public static void sendToServer(IMessage packet) {
        INSTANCE.networkWrapper.sendToServer(packet);
    }

}
