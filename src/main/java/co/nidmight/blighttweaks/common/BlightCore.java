package co.nidmight.blighttweaks.common;

import co.nidmight.blighttweaks.common.handlers.ChunkHandler;
import co.nidmight.blighttweaks.common.handlers.FoodHandler;
import co.nidmight.blighttweaks.common.handlers.InteractHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import noppes.npcs.CustomItems;
import noppes.npcs.blocks.BlockBlood;

@Mod(modid = BTStrings.MOD_ID, name = BTStrings.MOD_NAME, version = BTStrings.VERSION)
public class BlightCore {

    public static final String MODID = "blighttweaks";
    public static final String MODNAME = "BlightTweaks";
    public static final String VERSION = "1.4.0";

    @Mod.EventHandler()
    public void init(FMLInitializationEvent event) {
        new FoodHandler();
        new InteractHandler();
        new ChunkHandler();
    }

    @Mod.EventHandler()
    public void postInit(FMLPostInitializationEvent event) {
        if (CustomItems.blood instanceof BlockBlood) { // take account for config being disabled
            CustomItems.blood.setHardness(.5f);
        }
    }
}
