package co.nidmight.blighttweaks.recipes.tweaks;

import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import cofh.thermalexpansion.util.crafting.FurnaceManager;
import cofh.thermalexpansion.util.crafting.PulverizerManager;
import cofh.thermalexpansion.util.crafting.SmelterManager;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;

import com.pam.harvestcraft.ItemRegistry;

import appeng.core.Api;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.MFREditorUtil;
import cofh.thermalfoundation.block.TFBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import powercrystals.minefactoryreloaded.MFRRegistry;
import thaumcraft.common.config.ConfigBlocks;

public class MFRTweaks implements IGameEditor {

    @Override
    public void apply() {
        Block mfrStainedGlass = GameRegistry.findBlock("MineFactoryReloaded", "stainedglass.block");
        OreDictionary.getOres("blockGlass")
            .removeIf(stack -> stack.getItem() == Item.getItemFromBlock(mfrStainedGlass));
        OreDictionary.getOres("blockGlassWhite")
            .remove(new ItemStack(mfrStainedGlass));
        OreDictionary.getOres("blockGlassOrange")
            .remove(new ItemStack(mfrStainedGlass, 1, 1));
        OreDictionary.getOres("blockGlassMagenta")
            .remove(new ItemStack(mfrStainedGlass, 1, 2));
        OreDictionary.getOres("blockGlassLightBlue")
            .remove(new ItemStack(mfrStainedGlass, 1, 3));
        OreDictionary.getOres("blockGlassYellow")
            .remove(new ItemStack(mfrStainedGlass, 1, 4));
        OreDictionary.getOres("blockGlassLime")
            .remove(new ItemStack(mfrStainedGlass, 1, 5));
        OreDictionary.getOres("blockGlassPink")
            .remove(new ItemStack(mfrStainedGlass, 1, 6));
        OreDictionary.getOres("blockGlassGray")
            .remove(new ItemStack(mfrStainedGlass, 1, 7));
        OreDictionary.getOres("blockGlassLightGray")
            .remove(new ItemStack(mfrStainedGlass, 1, 8));
        OreDictionary.getOres("blockGlassCyan")
            .remove(new ItemStack(mfrStainedGlass, 1, 9));
        OreDictionary.getOres("blockGlassPurple")
            .remove(new ItemStack(mfrStainedGlass, 1, 10));
        OreDictionary.getOres("blockGlassBlue")
            .remove(new ItemStack(mfrStainedGlass, 1, 11));
        OreDictionary.getOres("blockGlassBrown")
            .remove(new ItemStack(mfrStainedGlass, 1, 12));
        OreDictionary.getOres("blockGlassGreen")
            .remove(new ItemStack(mfrStainedGlass, 1, 13));
        OreDictionary.getOres("blockGlassRed")
            .remove(new ItemStack(mfrStainedGlass, 1, 14));
        OreDictionary.getOres("blockGlassBlack")
            .remove(new ItemStack(mfrStainedGlass, 1, 15));

        // Laser Ore Removals

        for (int i = 0; i <= 6; i++) {
            MFREditorUtil.removeLaserOre(new ItemStack(TFBlocks.blockOre, 1, i));
        }

        Block netherOre0 = GameRegistry.findBlock("NetherOres", "tile.netherores.ore.0");
        Block netherOre1 = GameRegistry.findBlock("NetherOres", "tile.netherores.ore.1");
        for (int i = 0; i <= 15; i++) {
            MFREditorUtil.removeLaserOre(new ItemStack(netherOre1, 1, i));
            MFREditorUtil.removeLaserOre(new ItemStack(netherOre0, 1, i));
        }

        MFREditorUtil.removeLaserOre(new ItemStack(Api.INSTANCE.blocks().blockQuartzOre.block()));

        Block yelloriteOre = GameRegistry.findBlock("BigReactors", "YelloriteOre");
        MFREditorUtil.removeLaserOre(new ItemStack(yelloriteOre));

        Block baseOre = GameRegistry.findBlock("Metallurgy", "base.ore");
        Block enderOre = GameRegistry.findBlock("Metallurgy", "ender.ore");
        Block fantasyOre = GameRegistry.findBlock("Metallurgy", "fantasy.ore");
        Block metallurgyNetherOre = GameRegistry.findBlock("Metallurgy", "nether.ore");
        Block preciousOre = GameRegistry.findBlock("Metallurgy", "precious.ore");
        Block utilityOre = GameRegistry.findBlock("Metallurgy", "utility.ore");

        MFREditorUtil.removeLaserOre(new ItemStack(baseOre, 1, 2));

        MFREditorUtil.removeLaserOre(new ItemStack(enderOre));
        MFREditorUtil.removeLaserOre(new ItemStack(enderOre, 1, 1));
        int[] metasToRemove = { 1, 2, 4, 5, 6, 8, 11, 14 };
        for (int meta : metasToRemove) {
            MFREditorUtil.removeLaserOre(new ItemStack(fantasyOre, 1, meta));
        }

        for (int i = 0; i <= 9; i++) {
            MFREditorUtil.removeLaserOre(new ItemStack(metallurgyNetherOre, 1, i));
        }

        MFREditorUtil.removeLaserOre(new ItemStack(preciousOre, 1, 1));

        for (int i = 0; i <= 5; i++) {
            MFREditorUtil.removeLaserOre(new ItemStack(utilityOre, 1, i));
        }

        MFREditorUtil.removeLaserOre(new ItemStack(Blocks.coal_ore));
        MFREditorUtil.removeLaserOre(new ItemStack(Blocks.diamond_ore));
        MFREditorUtil.removeLaserOre(new ItemStack(Blocks.emerald_ore));
        MFREditorUtil.removeLaserOre(new ItemStack(Blocks.glowstone));
        MFREditorUtil.removeLaserOre(new ItemStack(Blocks.gold_ore));
        MFREditorUtil.removeLaserOre(new ItemStack(Blocks.iron_ore));
        MFREditorUtil.removeLaserOre(new ItemStack(Blocks.lapis_ore));
        MFREditorUtil.removeLaserOre(new ItemStack(Blocks.quartz_ore));
        MFREditorUtil.removeLaserOre(new ItemStack(Blocks.redstone_ore));

        Block searedBrickBlock = GameRegistry.findBlock("TConstruct", "SearedBrick");

        MFREditorUtil.removeLaserOre(new ItemStack(searedBrickBlock, 1, 1));
        MFREditorUtil.removeLaserOre(new ItemStack(searedBrickBlock, 1, 2));
        MFREditorUtil.removeLaserOre(new ItemStack(searedBrickBlock, 1, 5));

        MFREditorUtil.removeLaserOre(new ItemStack(ConfigBlocks.blockCustomOre));
        MFREditorUtil.removeLaserOre(new ItemStack(ConfigBlocks.blockCustomOre, 1, 7));

        // Laser Ore (re)additions
        MFRRegistry.registerLaserOre(36, new ItemStack(Api.INSTANCE.blocks().blockQuartzOre.block()));
        MFRRegistry.registerLaserOre(4, new ItemStack(Api.INSTANCE.blocks().blockQuartzOreCharged.block()));

        MFRRegistry.registerLaserOre(5, new ItemStack(yelloriteOre));

        MFRRegistry.registerLaserOre(75, new ItemStack(ItemRegistry.saltItem));

        MFRRegistry.registerLaserOre(40, new ItemStack(baseOre));
        MFRRegistry.registerLaserOre(35, new ItemStack(baseOre, 1, 1));
        MFRRegistry.registerLaserOre(20, new ItemStack(baseOre, 1, 2));

        MFRRegistry.registerLaserOre(8, new ItemStack(enderOre));
        MFRRegistry.registerLaserOre(15, new ItemStack(enderOre, 1, 1));

        MFRRegistry.registerLaserOre(50, new ItemStack(fantasyOre));
        MFRRegistry.registerLaserOre(55, new ItemStack(fantasyOre, 1, 1));
        MFRRegistry.registerLaserOre(50, new ItemStack(fantasyOre, 1, 2));
        MFRRegistry.registerLaserOre(45, new ItemStack(fantasyOre, 1, 4));
        MFRRegistry.registerLaserOre(40, new ItemStack(fantasyOre, 1, 5));
        MFRRegistry.registerLaserOre(35, new ItemStack(fantasyOre, 1, 6));
        MFRRegistry.registerLaserOre(30, new ItemStack(fantasyOre, 1, 7));
        MFRRegistry.registerLaserOre(25, new ItemStack(fantasyOre, 1, 8));
        MFRRegistry.registerLaserOre(20, new ItemStack(fantasyOre, 1, 11));
        MFRRegistry.registerLaserOre(15, new ItemStack(fantasyOre, 1, 13));
        MFRRegistry.registerLaserOre(10, new ItemStack(fantasyOre, 1, 14));

        MFRRegistry.registerLaserOre(28, new ItemStack(metallurgyNetherOre));
        MFRRegistry.registerLaserOre(24, new ItemStack(metallurgyNetherOre, 1, 1));
        MFRRegistry.registerLaserOre(20, new ItemStack(metallurgyNetherOre, 1, 2));
        MFRRegistry.registerLaserOre(17, new ItemStack(metallurgyNetherOre, 1, 3));
        MFRRegistry.registerLaserOre(16, new ItemStack(metallurgyNetherOre, 1, 4));
        MFRRegistry.registerLaserOre(14, new ItemStack(metallurgyNetherOre, 1, 5));
        MFRRegistry.registerLaserOre(12, new ItemStack(metallurgyNetherOre, 1, 6));
        MFRRegistry.registerLaserOre(10, new ItemStack(metallurgyNetherOre, 1, 7));
        MFRRegistry.registerLaserOre(9, new ItemStack(metallurgyNetherOre, 1, 8));
        MFRRegistry.registerLaserOre(9, new ItemStack(metallurgyNetherOre, 1, 9));

        MFRRegistry.registerLaserOre(40, new ItemStack(preciousOre));
        MFRRegistry.registerLaserOre(25, new ItemStack(preciousOre, 1, 1));
        MFRRegistry.registerLaserOre(15, new ItemStack(preciousOre, 1, 2));

        MFRRegistry.registerLaserOre(35, new ItemStack(utilityOre));
        MFRRegistry.registerLaserOre(20, new ItemStack(utilityOre, 1, 1));
        MFRRegistry.registerLaserOre(35, new ItemStack(utilityOre, 1, 2));
        MFRRegistry.registerLaserOre(25, new ItemStack(utilityOre, 1, 3));
        MFRRegistry.registerLaserOre(35, new ItemStack(utilityOre, 1, 4));
        MFRRegistry.registerLaserOre(20, new ItemStack(utilityOre, 1, 5));

        MFRRegistry.registerLaserOre(150, new ItemStack(Blocks.coal_ore));
        MFRRegistry.registerLaserOre(50, new ItemStack(Blocks.diamond_ore));
        MFRRegistry.registerLaserOre(35, new ItemStack(Blocks.emerald_ore));
        MFRRegistry.registerLaserOre(65, new ItemStack(Blocks.glowstone));
        MFRRegistry.registerLaserOre(70, new ItemStack(Blocks.gold_ore));
        MFRRegistry.registerLaserOre(130, new ItemStack(Blocks.iron_ore));
        MFRRegistry.registerLaserOre(80, new ItemStack(Blocks.lapis_ore));
        MFRRegistry.registerLaserOre(70, new ItemStack(Blocks.quartz_ore));
        MFRRegistry.registerLaserOre(90, new ItemStack(Blocks.redstone_ore));
        MFRRegistry.registerLaserOre(1, new ItemStack(Items.fish));

        MFRRegistry.registerLaserOre(30, new ItemStack(netherOre0));
        MFRRegistry.registerLaserOre(10, new ItemStack(netherOre0, 1, 1));
        MFRRegistry.registerLaserOre(14, new ItemStack(netherOre0, 1, 2));
        MFRRegistry.registerLaserOre(26, new ItemStack(netherOre0, 1, 3));
        MFRRegistry.registerLaserOre(16, new ItemStack(netherOre0, 1, 4));
        MFRRegistry.registerLaserOre(18, new ItemStack(netherOre0, 1, 5));
        MFRRegistry.registerLaserOre(8, new ItemStack(netherOre0, 1, 6));
        MFRRegistry.registerLaserOre(7, new ItemStack(netherOre0, 1, 7));
        MFRRegistry.registerLaserOre(7, new ItemStack(netherOre0, 1, 8));
        MFRRegistry.registerLaserOre(5, new ItemStack(netherOre0, 1, 9));
        MFRRegistry.registerLaserOre(6, new ItemStack(netherOre0, 1, 10));
        MFRRegistry.registerLaserOre(10, new ItemStack(netherOre0, 1, 13));
        MFRRegistry.registerLaserOre(10, new ItemStack(netherOre0, 1, 14));
        MFRRegistry.registerLaserOre(10, new ItemStack(netherOre0, 1, 15));

        MFRRegistry.registerLaserOre(3, new ItemStack(netherOre1));
        MFRRegistry.registerLaserOre(4, new ItemStack(netherOre1, 1, 1));
        MFRRegistry.registerLaserOre(10, new ItemStack(netherOre1, 1, 2));
        MFRRegistry.registerLaserOre(20, new ItemStack(netherOre1, 1, 5));
        MFRRegistry.registerLaserOre(6, new ItemStack(netherOre1, 1, 7));
        MFRRegistry.registerLaserOre(15, new ItemStack(netherOre1, 1, 11));
        MFRRegistry.registerLaserOre(15, new ItemStack(netherOre1, 1, 13));
        MFRRegistry.registerLaserOre(20, new ItemStack(netherOre1, 1, 14));
        MFRRegistry.registerLaserOre(12, new ItemStack(netherOre1, 1, 15));

        MFRRegistry.registerLaserOre(10, new ItemStack(searedBrickBlock, 1, 1));
        MFRRegistry.registerLaserOre(12, new ItemStack(searedBrickBlock, 1, 2));
        MFRRegistry.registerLaserOre(60, new ItemStack(searedBrickBlock, 1, 5));

        MFRRegistry.registerLaserOre(65, new ItemStack(ConfigBlocks.blockCustomOre));
        MFRRegistry.registerLaserOre(5, new ItemStack(ConfigBlocks.blockCustomOre, 1, 1));
        MFRRegistry.registerLaserOre(40, new ItemStack(ConfigBlocks.blockCustomOre, 1, 2));
        MFRRegistry.registerLaserOre(20, new ItemStack(ConfigBlocks.blockCustomOre, 1, 3));
        MFRRegistry.registerLaserOre(40, new ItemStack(ConfigBlocks.blockCustomOre, 1, 4));
        MFRRegistry.registerLaserOre(30, new ItemStack(ConfigBlocks.blockCustomOre, 1, 5));
        MFRRegistry.registerLaserOre(10, new ItemStack(ConfigBlocks.blockCustomOre, 1, 6));
        MFRRegistry.registerLaserOre(75, new ItemStack(ConfigBlocks.blockCustomOre, 1, 7));

        MFRRegistry.registerLaserOre(30, new ItemStack(TFBlocks.blockOre, 1, 3));
        MFRRegistry.registerLaserOre(20, new ItemStack(TFBlocks.blockOre, 1, 4));

        // Remove preferred ores
        MFREditorUtil.removePreferredOre(0, "<Metallurgy:precious.ore>");
        MFREditorUtil.removePreferredOre(0, "<Metallurgy:utility.ore:2>");
        MFREditorUtil.removePreferredOre(0, "<minecraft:quartz_ore>");
        MFREditorUtil.removePreferredOre(0, "<NetherOres:tile.netherores.ore.1:13>");
        MFREditorUtil.removePreferredOre(0, "<NetherOres:tile.netherores.ore.1:14>");
        MFREditorUtil.removePreferredOre(0, "<NetherOres:tile.netherores.ore.1:3>");
        MFREditorUtil.removePreferredOre(0, "<TConstruct:SearedBrick:5>");

        MFREditorUtil.removePreferredOre(1, "<NetherOres:tile.netherores.ore.0:6>");
        MFREditorUtil.removePreferredOre(1, "<NetherOres:tile.netherores.ore.1:11>");
        MFREditorUtil.removePreferredOre(1, "<TConstruct:SearedBrick:2>");
        MFREditorUtil.removePreferredOre(1, "<Thaumcraft:blockCustomOre:7>");
        MFREditorUtil.removePreferredOre(1, "<ThermalFoundation:Ore>");

        MFREditorUtil.removePreferredOre(3, "<minecraft:diamond_ore>");
        MFREditorUtil.removePreferredOre(3, "<NetherOres:tile.netherores.ore.0:1>");
        MFREditorUtil.removePreferredOre(3, "<NetherOres:tile.netherores.ore.0:12>");
        MFREditorUtil.removePreferredOre(3, "<NetherOres:tile.netherores.ore.1>");
        MFREditorUtil.removePreferredOre(3, "<NetherOres:tile.netherores.ore.1:4>");
        MFREditorUtil.removePreferredOre(3, "<ThermalFoundation:Ore:5>");
        MFREditorUtil.removePreferredOre(4, "<BigReactors:YelloriteOre>");
        MFREditorUtil.removePreferredOre(4, "<Metallurgy:utility.ore>");
        MFREditorUtil.removePreferredOre(4, "<minecraft:glowstone>");
        MFREditorUtil.removePreferredOre(4, "<minecraft:gold_ore>");
        MFREditorUtil.removePreferredOre(4, "<NetherOres:tile.netherores.ore.0:2>");
        MFREditorUtil.removePreferredOre(4, "<NetherOres:tile.netherores.ore.1:5>");
        MFREditorUtil.removePreferredOre(5, "<minecraft:emerald_ore>");
        MFREditorUtil.removePreferredOre(5, "<NetherOres:tile.netherores.ore.0:11>");
        MFREditorUtil.removePreferredOre(5, "<NetherOres:tile.netherores.ore.0:8>");
        MFREditorUtil.removePreferredOre(5, "<NetherOres:tile.netherores.ore.1:12>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:base.ore:2>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:ender.ore>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:ender.ore:1>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:fantasy.ore>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:fantasy.ore:1>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:fantasy.ore:11>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:fantasy.ore:14>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:fantasy.ore:2>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:fantasy.ore:4>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:fantasy.ore:5>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:fantasy.ore:6>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:fantasy.ore:8>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:nether.ore>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:nether.ore:1>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:nether.ore:2>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:nether.ore:3>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:nether.ore:4>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:nether.ore:5>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:nether.ore:6>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:nether.ore:7>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:nether.ore:8>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:nether.ore:9>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:utility.ore:1>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:utility.ore:4>");
        MFREditorUtil.removePreferredOre(6, "<Metallurgy:utility.ore:5>");
        MFREditorUtil.removePreferredOre(7, "<NetherOres:tile.netherores.ore.0:9>");
        MFREditorUtil.removePreferredOre(7, "<NetherOres:tile.netherores.ore.1:2>");
        MFREditorUtil.removePreferredOre(7, "<ThermalFoundation:Ore:2>");
        MFREditorUtil.removePreferredOre(8, "<Metallurgy:utility.ore:3>");
        MFREditorUtil.removePreferredOre(8, "<NetherOres:tile.netherores.ore.0:7>");
        MFREditorUtil.removePreferredOre(8, "<NetherOres:tile.netherores.ore.1:1>");
        MFREditorUtil.removePreferredOre(8, "<NetherOres:tile.netherores.ore.1:15>");
        MFREditorUtil.removePreferredOre(8, "<ThermalFoundation:Ore:1>");
        MFREditorUtil.removePreferredOre(8, "<ThermalFoundation:Ore:4>");
        MFREditorUtil.removePreferredOre(9, "<appliedenergistics2:tile.OreQuartz>");
        MFREditorUtil.removePreferredOre(10, "<NetherOres:tile.netherores.ore.0:10>");
        MFREditorUtil.removePreferredOre(10, "<ThermalFoundation:Ore:3>");
        MFREditorUtil.removePreferredOre(11, "<minecraft:lapis_ore>");
        MFREditorUtil.removePreferredOre(11, "<NetherOres:tile.netherores.ore.0:15>");
        MFREditorUtil.removePreferredOre(11, "<NetherOres:tile.netherores.ore.0:4>");
        MFREditorUtil.removePreferredOre(11, "<NetherOres:tile.netherores.ore.1:7>");
        MFREditorUtil.removePreferredOre(11, "<TConstruct:SearedBrick:1>");
        MFREditorUtil.removePreferredOre(11, "<ThermalFoundation:Ore:6>");
        MFREditorUtil.removePreferredOre(12, "<minecraft:iron_ore>");
        MFREditorUtil.removePreferredOre(12, "<NetherOres:tile.netherores.ore.0:3>");
        MFREditorUtil.removePreferredOre(13, "<NetherOres:tile.netherores.ore.0:14>");
        MFREditorUtil.removePreferredOre(13, "<NetherOres:tile.netherores.ore.1:8>");
        MFREditorUtil.removePreferredOre(14, "<minecraft:redstone_ore>");
        MFREditorUtil.removePreferredOre(14, "<NetherOres:tile.netherores.ore.0:13>");
        MFREditorUtil.removePreferredOre(14, "<NetherOres:tile.netherores.ore.0:5>");
        MFREditorUtil.removePreferredOre(14, "<Thaumcraft:blockCustomOre>");
        MFREditorUtil.removePreferredOre(15, "<minecraft:coal_ore>");
        MFREditorUtil.removePreferredOre(15, "<NetherOres:tile.netherores.ore.0>");
        MFREditorUtil.removePreferredOre(15, "<NetherOres:tile.netherores.ore.1:10>");
        MFREditorUtil.removePreferredOre(15, "<NetherOres:tile.netherores.ore.1:6>");
        MFREditorUtil.removePreferredOre(15, "<NetherOres:tile.netherores.ore.1:9>");

        // Add preferred ores
        MFREditorUtil.addPreferredOre(0, "<harvestcraft:salt>");
        MFREditorUtil.addPreferredOre(0, "<minecraft:quartz_ore>");
        MFREditorUtil.addPreferredOre(1, "<Metallurgy:utility.ore>");
        MFREditorUtil.addPreferredOre(1, "<Metallurgy:utility.ore:1>");
        MFREditorUtil.addPreferredOre(1, "<Metallurgy:utility.ore:2>");
        MFREditorUtil.addPreferredOre(1, "<Metallurgy:utility.ore:3>");
        MFREditorUtil.addPreferredOre(1, "<Metallurgy:utility.ore:4>");
        MFREditorUtil.addPreferredOre(1, "<Metallurgy:utility.ore:5>");
        MFREditorUtil.addPreferredOre(1, "<minecraft:glowstone>");
        MFREditorUtil.addPreferredOre(1, "<minecraft:redstone_ore>");
        MFREditorUtil.addPreferredOre(1, "<Thaumcraft:blockCustomOre:7>");
        MFREditorUtil.addPreferredOre(2, "<Metallurgy:fantasy.ore:11>");
        MFREditorUtil.addPreferredOre(2, "<Metallurgy:fantasy.ore:13>");
        MFREditorUtil.addPreferredOre(2, "<Metallurgy:fantasy.ore:14>");
        MFREditorUtil.addPreferredOre(2, "<Metallurgy:fantasy.ore:6>");
        MFREditorUtil.addPreferredOre(2, "<Metallurgy:fantasy.ore:7>");
        MFREditorUtil.addPreferredOre(3, "<minecraft:diamond_ore>");
        MFREditorUtil.addPreferredOre(3, "<NetherOres:tile.netherores.ore.0:1>");
        MFREditorUtil.addPreferredOre(4, "<BigReactors:YelloriteOre>");
        MFREditorUtil.addPreferredOre(4, "<minecraft:coal_ore>");
        MFREditorUtil.addPreferredOre(5, "<minecraft:fish>");
        MFREditorUtil.addPreferredOre(6, "<Metallurgy:nether.ore>");
        MFREditorUtil.addPreferredOre(6, "<Metallurgy:nether.ore:1>");
        MFREditorUtil.addPreferredOre(6, "<Metallurgy:nether.ore:2>");
        MFREditorUtil.addPreferredOre(6, "<Metallurgy:nether.ore:3>");
        MFREditorUtil.addPreferredOre(6, "<Metallurgy:nether.ore:4>");
        MFREditorUtil.addPreferredOre(6, "<Metallurgy:nether.ore:5>");
        MFREditorUtil.addPreferredOre(6, "<Metallurgy:nether.ore:6>");
        MFREditorUtil.addPreferredOre(6, "<Metallurgy:nether.ore:7>");
        MFREditorUtil.addPreferredOre(6, "<Metallurgy:nether.ore:8>");
        MFREditorUtil.addPreferredOre(6, "<Metallurgy:nether.ore:9>");
        MFREditorUtil.addPreferredOre(7, "<Metallurgy:base.ore:2>");
        MFREditorUtil.addPreferredOre(7, "<Metallurgy:precious.ore>");
        MFREditorUtil.addPreferredOre(7, "<minecraft:gold_ore>");
        MFREditorUtil.addPreferredOre(7, "<minecraft:iron_ore>");
        MFREditorUtil.addPreferredOre(7, "<TConstruct:SearedBrick:5>");
        MFREditorUtil.addPreferredOre(7, "<Thaumcraft:blockCustomOre>");
        MFREditorUtil.addPreferredOre(8, "<Metallurgy:base.ore:0>");
        MFREditorUtil.addPreferredOre(8, "<Metallurgy:base.ore:1>");
        MFREditorUtil.addPreferredOre(8, "<Metallurgy:precious.ore:1>");
        MFREditorUtil.addPreferredOre(8, "<Metallurgy:precious.ore:2>");
        MFREditorUtil.addPreferredOre(8, "<ThermalFoundation:Ore:3>");
        MFREditorUtil.addPreferredOre(8, "<ThermalFoundation:Ore:4>");
        MFREditorUtil.addPreferredOre(9, "<appliedenergistics2:tile.OreQuartz>");
        MFREditorUtil.addPreferredOre(9, "<appliedenergistics2:tile.OreQuartzCharged>");
        MFREditorUtil.addPreferredOre(10, "<Thaumcraft:blockCustomOre:1>");
        MFREditorUtil.addPreferredOre(10, "<Thaumcraft:blockCustomOre:2>");
        MFREditorUtil.addPreferredOre(10, "<Thaumcraft:blockCustomOre:3>");
        MFREditorUtil.addPreferredOre(10, "<Thaumcraft:blockCustomOre:4>");
        MFREditorUtil.addPreferredOre(10, "<Thaumcraft:blockCustomOre:5>");
        MFREditorUtil.addPreferredOre(10, "<Thaumcraft:blockCustomOre:6>");
        MFREditorUtil.addPreferredOre(11, "<minecraft:lapis_ore>");
        MFREditorUtil.addPreferredOre(11, "<NetherOres:tile.netherores.ore.0:15>");
        MFREditorUtil.addPreferredOre(11, "<NetherOres:tile.netherores.ore.0:4>");
        MFREditorUtil.addPreferredOre(12, "<Metallurgy:fantasy.ore>");
        MFREditorUtil.addPreferredOre(12, "<Metallurgy:fantasy.ore:1>");
        MFREditorUtil.addPreferredOre(12, "<Metallurgy:fantasy.ore:2>");
        MFREditorUtil.addPreferredOre(12, "<Metallurgy:fantasy.ore:4>");
        MFREditorUtil.addPreferredOre(12, "<Metallurgy:fantasy.ore:5>");
        MFREditorUtil.addPreferredOre(12, "<Metallurgy:fantasy.ore:8>");
        MFREditorUtil.addPreferredOre(13, "<minecraft:emerald_ore>");
        MFREditorUtil.addPreferredOre(13, "<NetherOres:tile.netherores.ore.0:14>");
        MFREditorUtil.addPreferredOre(13, "<NetherOres:tile.netherores.ore.0:8>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.0>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.0:10>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.0:13>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.0:2>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.0:3>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.0:5>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.0:6>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.0:7>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.0:9>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.1>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.1:1>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.1:11>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.1:13>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.1:14>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.1:15>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.1:2>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.1:5>");
        MFREditorUtil.addPreferredOre(14, "<NetherOres:tile.netherores.ore.1:7>");
        MFREditorUtil.addPreferredOre(14, "<TConstruct:SearedBrick:1>");
        MFREditorUtil.addPreferredOre(14, "<TConstruct:SearedBrick:2>");
        MFREditorUtil.addPreferredOre(15, "<Metallurgy:ender.ore>");
        MFREditorUtil.addPreferredOre(15, "<Metallurgy:ender.ore:1>");

        // foci tooltips
        for (int meta = 0; meta <= 15; meta++) {
            ItemStack stack = new ItemStack(GameRegistry.findItem("MineFactoryReloaded", "laserFocus"), 1, meta);
            stack.setStackDisplayName(StatCollector.translateToLocal("blighttweaks.laserFocus" + meta));
            if (meta == 5) {
                // fish focus has 3 lines
                RecipeEditorUtil.addTooltip(stack, StatCollector.translateToLocal("tooltip.laserFocus" + meta + ".1"), StatCollector.translateToLocal("tooltip.laserFocus" + meta + ".2"), StatCollector.translateToLocal("tooltip.laserFocus" + meta + ".3"));
                continue;
            }
            RecipeEditorUtil.addTooltip(stack, StatCollector.translateToLocal("tooltip.laserFocus" + meta + ".1"), StatCollector.translateToLocal("tooltip.laserFocus" + meta + ".2"));
        }

        // laser drill ore recipe unification
        FurnaceManager.addRecipe(1600, RecipeEditorUtil.parseItemStack("<NetherOres:tile.netherores.ore.0:14>"), RecipeEditorUtil.parseItemStack("<ExtraTiC:chunk:165>", 2), true);
        FurnaceManager.addRecipe(1600, RecipeEditorUtil.parseItemStack("<NetherOres:tile.netherores.ore.0:15>"), RecipeEditorUtil.parseItemStack("<customnpcs:npcSaphire>", 2), true);
        PulverizerManager.addRecipe(3200, RecipeEditorUtil.parseItemStack("<NetherOres:tile.netherores.ore.0:14>"), RecipeEditorUtil.parseItemStack("<ExtraTiC:chunk:165>", 5), RecipeEditorUtil.parseItemStack("<minecraft:netherrack>"), 15);
        PulverizerManager.addRecipe(3200, RecipeEditorUtil.parseItemStack("<NetherOres:tile.netherores.ore.0:15>"), RecipeEditorUtil.parseItemStack("<customnpcs:npcSaphire>", 5), RecipeEditorUtil.parseItemStack("<minecraft:netherrack>"), 15);
        SmelterManager.addRecipe(3200, RecipeEditorUtil.parseItemStack("<NetherOres:tile.netherores.ore.0:14>"), RecipeEditorUtil.parseItemStack("<minecraft:sand>"), RecipeEditorUtil.parseItemStack("<ExtraTiC:chunk:165>", 2), RecipeEditorUtil.parseItemStack("<ThermalExpansion:material:515>"), 10);
        SmelterManager.addRecipe(3200, RecipeEditorUtil.parseItemStack("<NetherOres:tile.netherores.ore.0:15>"), RecipeEditorUtil.parseItemStack("<minecraft:sand>"), RecipeEditorUtil.parseItemStack("<customnpcs:npcSaphire>", 2), RecipeEditorUtil.parseItemStack("<ThermalExpansion:material:515>"), 10);
        SmelterManager.addRecipe(7200, RecipeEditorUtil.parseItemStack("<NetherOres:tile.netherores.ore.0:14>"), RecipeEditorUtil.parseItemStack("<ThermalExpansion:material:515>"), RecipeEditorUtil.parseItemStack("<ExtraTiC:chunk:165>", 3), RecipeEditorUtil.parseItemStack("<ThermalExpansion:material:514>"), 100);
        SmelterManager.addRecipe(7200, RecipeEditorUtil.parseItemStack("<NetherOres:tile.netherores.ore.0:15>"), RecipeEditorUtil.parseItemStack("<ThermalExpansion:material:515>"), RecipeEditorUtil.parseItemStack("<customnpcs:npcSaphire>", 3), RecipeEditorUtil.parseItemStack("<ThermalExpansion:material:514>"), 100);
    }
}
