package co.nidmight.blighttweaks.common;

import co.nidmight.blighttweaks.common.handlers.ChunkHandler;
import co.nidmight.blighttweaks.common.handlers.FoodHandler;
import co.nidmight.blighttweaks.common.handlers.InteractHandler;
import co.nidmight.blighttweaks.common.items.Items;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import noppes.npcs.CustomItems;
import noppes.npcs.blocks.BlockBlood;

@Mod(modid = BTStrings.MOD_ID, name = BTStrings.MOD_NAME, version = BTStrings.VERSION)
public class BlightCore {

    @Mod.EventHandler()
    public void preInit(FMLInitializationEvent event) {
        Items.init();
    }   

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

    @Mod.EventHandler
    public void missingMappings(FMLMissingMappingsEvent event) {
        for (FMLMissingMappingsEvent.MissingMapping mapping : event.getAll()) {
            if (!mapping.name.startsWith("blightbuster")) {
                continue;
            }
            switch (mapping.name) {
                case "blightbuster:boundRing":
                    mapping.remap(Items.boundRing);
                    break;
                case "blightbuster:researchNote":
                    mapping.remap(Items.alienTome);
                    break;
                case "blightbuster:worldOreKiller":
                    mapping.remap(Items.worldOreKiller);
                    break;
                default:
                    break;
            }
        }
    }
}
