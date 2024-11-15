package co.nidmight.blighttweaks.common.network.handler;

import java.util.HashMap;

import co.nidmight.blighttweaks.common.network.packet.ToggleArmorBoost;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ArmorBoostPacketHandler implements IMessageHandler<ToggleArmorBoost, IMessage> {

    public static final HashMap<String, Boolean> enabledPlayers = new HashMap<>();

    @Override
    public IMessage onMessage(ToggleArmorBoost message, MessageContext ctx) {
        enabledPlayers.put(message.getUsername(), message.getToggle());
        return null;
    }
}
