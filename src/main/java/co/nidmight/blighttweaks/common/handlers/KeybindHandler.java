package co.nidmight.blighttweaks.common.handlers;

import net.minecraft.client.settings.KeyBinding;

import cpw.mods.fml.client.registry.ClientRegistry;

public class KeybindHandler {

    public static KeyBinding armorBoost = new KeyBinding("Toggle Armor Boost", 37, "key.categories.misc");

    public KeybindHandler() {
        ClientRegistry.registerKeyBinding(armorBoost);
    }
}
