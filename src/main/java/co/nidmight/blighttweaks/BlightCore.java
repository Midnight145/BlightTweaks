package co.nidmight.blighttweaks;

import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ChestGenHooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.nidmight.blighttweaks.common.blocks.Blocks;
import co.nidmight.blighttweaks.common.compat.ThaumcraftRecipes;
import co.nidmight.blighttweaks.common.items.Items;
import co.nidmight.blighttweaks.common.network.BlightCoreNetwork;
import co.nidmight.blighttweaks.common.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import noppes.npcs.CustomItems;
import noppes.npcs.blocks.BlockBlood;
import talonos.blightbuster.api.BlightbusterAPI;

@Mod(modid = BTStrings.MOD_ID, name = BTStrings.MOD_NAME, version = BTStrings.VERSION)
public class BlightCore {

    public static Logger logger = LogManager.getLogger(BTStrings.MOD_ID);

    @SidedProxy(
        clientSide = "co.nidmight.blighttweaks.common.proxy.ClientProxy",
        serverSide = "co.nidmight.blighttweaks.common.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler()
    public void preInit(FMLPreInitializationEvent event) {
        Items.init();
        Blocks.init();
        proxy.preinit();
    }

    @Mod.EventHandler()
    public void init(FMLInitializationEvent event) {
        BlightCoreNetwork.init();
        proxy.init();
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
        BlightbusterAPI.registerCustomNpcPurificationMapping("TaintedWolf", EntityWolf.class);
        BlightbusterAPI.registerCustomNpcPurificationMapping("TaintedOcelot", EntityOcelot.class);
        BlightbusterAPI.registerCustomNpcPurificationMapping("TaintedTownsfolk", EntityVillager.class);
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
