package co.nidmight.blighttweaks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ChestGenHooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.nidmight.blighttweaks.common.compat.ThaumcraftRecipes;
import co.nidmight.blighttweaks.common.compat.UBCIntegration;
import co.nidmight.blighttweaks.common.handlers.ChunkHandler;
import co.nidmight.blighttweaks.common.handlers.FoodHandler;
import co.nidmight.blighttweaks.common.handlers.InteractHandler;
import co.nidmight.blighttweaks.common.handlers.KeybindHandler;
import co.nidmight.blighttweaks.common.items.Items;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import noppes.npcs.CustomItems;
import noppes.npcs.blocks.BlockBlood;

@Mod(modid = BTStrings.MOD_ID, name = BTStrings.MOD_NAME, version = BTStrings.VERSION)
public class BlightCore {

    public static Logger logger = LogManager.getLogger(BTStrings.MOD_ID);

    @Mod.EventHandler()
    public void preInit(FMLPreInitializationEvent event) {
        Items.init();
        // Blocks.quartz_ore.setHarvestLevel("pickaxe", 2);
        UBCIntegration.register();
    }

    @Mod.EventHandler()
    public void init(FMLInitializationEvent event) {
        new FoodHandler();
        new InteractHandler();
        new ChunkHandler();
        new KeybindHandler();
    }

    @Mod.EventHandler()
    public void postInit(FMLPostInitializationEvent event) {
        if (CustomItems.blood instanceof BlockBlood) { // take account for config being disabled
            CustomItems.blood.setHardness(.5f);
        }
        ThaumcraftRecipes.init();
        ItemStack broadsword = GameRegistry.findItemStack("TConstruct", "broadsword", 1);
        if (broadsword != null) {
            broadsword.setItemDamage(-1);
            ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
                .removeItem(broadsword);
        }
    }

    @Mod.EventHandler()
    public void missingMappings(FMLMissingMappingsEvent event) throws Exception {
        for (FMLMissingMappingsEvent.MissingMapping mapping : event.getAll()) {
            logger.info("Found missing mapping: {}", mapping.name);
            if (mapping.name.equals("Baubles:Ring") || mapping.name.equals("AWWayofTime:itemBloodMagicBook")) {
                logger.info("Ignoring mapping {}", mapping.name);
                mapping.ignore();
            }
            if (!mapping.name.startsWith("blightbuster")) {
                continue;
            }
            switch (mapping.name) {
                case "blightbuster:boundRing":
                    logger.info("Remapping blightbuster:boundRing to {}", Items.boundRing.getUnlocalizedName());
                    mapping.remap(Items.boundRing);
                    break;
                case "blightbuster:researchnote":
                    logger.info("Remapping blightbuster:researchnote to {}", Items.alienTome.getUnlocalizedName());
                    mapping.remap(Items.alienTome);
                    break;
                case "blightbuster:worldOreKiller":
                    logger
                        .info("Remapping blightbuster:worldOreKiller to {}", Items.worldOreKiller.getUnlocalizedName());
                    mapping.remap(Items.worldOreKiller);
                    break;
                default:
                    logger.error("Unknown mapping: {}", mapping.name);
            }
        }
    }
}
