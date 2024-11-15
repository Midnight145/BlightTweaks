package co.nidmight.blighttweaks.common.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import co.nidmight.blighttweaks.common.network.BlightCoreNetwork;
import co.nidmight.blighttweaks.common.network.packet.ToggleArmorBoost;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeybindHandler {

    public static KeyBinding armorBoost = new KeyBinding("Toggle Armor Boost", 37, "key.categories.misc");
    public static boolean isBoostEnabled;

    public KeybindHandler() {
        ClientRegistry.registerKeyBinding(armorBoost);
    }

    @SubscribeEvent
    public void onKeyDown(InputEvent.KeyInputEvent event) {
        if (KeybindHandler.armorBoost.isPressed()) {
            isBoostEnabled = !isBoostEnabled;
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            String username = player.getCommandSenderName();
            player.addChatMessage(new ChatComponentText(isBoostEnabled ? "Boost enabled" : "Boost disabled"));
            BlightCoreNetwork.sendToServer(new ToggleArmorBoost(isBoostEnabled, username.length(), username));
        }
    }
}
