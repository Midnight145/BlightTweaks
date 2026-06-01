package co.nidmight.blighttweaks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ChestGenHooks;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.nidmight.blighttweaks.common.blocks.Blocks;
import co.nidmight.blighttweaks.common.compat.ThaumcraftRecipes;
import co.nidmight.blighttweaks.common.items.Items;
import co.nidmight.blighttweaks.common.network.BlightCoreNetwork;
import co.nidmight.blighttweaks.common.proxy.CommonProxy;
import co.nidmight.blighttweaks.recipes.RecipeHandler;
import cpw.mods.fml.common.Loader;
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
        if (Loader.isModLoaded("blightbuster")) {
            BlightbusterAPI.registerCustomNpcPurificationMapping("TaintedOcelot", EntityOcelot.class);
            BlightbusterAPI.registerCustomNpcPurificationMapping("TaintedWolf", EntityWolf.class);
            BlightbusterAPI.registerCustomNpcPurificationMapping("TaintedTownsfolk", EntityVillager.class);
        }
        RecipeHandler handler = new RecipeHandler();
        handler.build();
        handler.applyEditors();
    }

    @Mod.EventHandler()
    public void missingMappings(FMLMissingMappingsEvent event) throws Exception {
        List<String> ignoredMappings = Arrays.asList(
            "Baubles:Ring",
            "AWWayofTime:itemBloodMagicBook",
            "extracells:*",
            "thaumicenergistics:thaumicenergistics.block.essentia.cell.workbench",
            "thaumicenergistics:wireless.essentia.terminal");

        HashMap<String, Item> remaps = new HashMap<>();
        remaps.put("blightbuster:boundRing", Items.boundRing);
        remaps.put("blightbuster:researchnote", Items.alienTome);
        remaps.put("blightbuster:worldOreKiller", Items.worldOreKiller);

        loop: for (FMLMissingMappingsEvent.MissingMapping mapping : event.getAll()) {
            logger.info("Found missing mapping: {}", mapping.name);
            for (String ignored : ignoredMappings) {
                if (mapping.name.startsWith(ignored) && (mapping.name.equals(ignored) || ignored.endsWith(":"))) {
                    logger.info("Ignoring mapping {}", mapping.name);
                    mapping.ignore();
                    continue loop;
                }
            }

            if (remaps.containsKey(mapping.name)) {
                logger.info(
                    "Remapping {} to {}",
                    mapping.name,
                    remaps.get(mapping.name)
                        .getUnlocalizedName());
                mapping.remap(remaps.get(mapping.name));
            }
            logger.log(Level.WARN, "Unknown missing mapping: {}", mapping.name);
        }
    }
}
