package co.nidmight.blighttweaks.recipes.removals;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import co.nidmight.blighttweaks.recipes.framework.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import co.nidmight.blighttweaks.recipes.helpers.ThermalEditorUtil;
import cpw.mods.fml.common.registry.GameRegistry;
import noppes.npcs.CustomItems;

public class DisabledItems implements IGameEditor {

    @Override
    public void apply() {
        RecipeEditorUtil util = RecipeEditorUtil.getInstance();
        // MFR
        Item mfrMachine0 = GameRegistry.findItem("MineFactoryReloaded", "machine.0"); // couldn't be assed to figure out
                                                                                      // how mfr registers its items, so
                                                                                      // just hardcoding the name here
        util.removeRecipeByOutput(new ItemStack(mfrMachine0, 1, 7)); // Block Breaker

        Item mfrMachine1 = GameRegistry.findItem("MineFactoryReloaded", "machine.1");
        util.removeRecipeByOutput(new ItemStack(mfrMachine1, 1, 6)); // Steam Boiler
        util.removeRecipeByOutput(new ItemStack(mfrMachine1, 1, 10)); // BioReactor
        util.removeRecipeByOutput(new ItemStack(mfrMachine1, 1, 11)); // BioFuel Generator

        Item augment = GameRegistry.findItem("ThermalExpansion", "augment"); // same for TE augments
        int[] metas = { 48, 49, 64, 65, 66, 80, 81, 82 };
        for (int meta : metas) {
            util.removeRecipeByOutput(new ItemStack(augment, 1, meta));
        }

        Item teDevice = GameRegistry.findItem("ThermalExpansion", "Device");
        util.removeRecipeByOutput(new ItemStack(teDevice, 1, 3)); // Terrain Smasher

        Item lexicon = GameRegistry.findItem("ThermalFoundation", "lexicon");
        util.removeRecipeByOutput(lexicon);

        // Natura
        Item barleyFood = GameRegistry.findItem("Natura", "barleyFood");
        util.removeRecipeByOutput(new ItemStack(barleyFood, 1, 1)); // Natura flour
        util.removeRecipeByOutput(new ItemStack(barleyFood, 1, 2)); // Natura flour
        util.removeRecipeByOutput(new ItemStack(barleyFood, 1, 4)); // Natura Sulfur

        // AE2
        ItemStack blockSkyCompass = GameRegistry.findItemStack("appliedenergistics2", "tile.BlockSkyCompass", 1);
        if (blockSkyCompass == null) {
            throw new IllegalStateException("Failed to find BlockSkyCompass from AE2, cannot remove recipe for it");
        }
        util.removeRecipeByOutput(blockSkyCompass);
        ItemStack blockSkyStone = GameRegistry.findItemStack("appliedenergistics2", "tile.BlockSkyStone", 1);
        ThermalEditorUtil.removePulverizerRecipeByInput(blockSkyStone);

        // JABBA
        Item moverDiamond = GameRegistry.findItem("JABBA", "moverDiamond");
        util.removeRecipeByOutput(moverDiamond);

        // CustomNPCs
        util.removeRecipeByOutput(CustomItems.wand);
        util.removeRecipeByOutput(GameRegistry.findItem("customnpcs", "npcMagicWand")); // why is this not a field :sob:

        // Thaumic Tinkerer
        Item wardSlab = GameRegistry.findItem("ThaumicTinkerer", "wardSlab");
        util.removeShapedRecipeByOutput(new ItemStack(wardSlab, 1, 0));
        Item kamiResource = GameRegistry.findItem("ThaumicTinkerer", "kamiResource");
        util.removeShapedRecipeByOutput(new ItemStack(kamiResource, 1, 3)); // useless ichorium nuggets

        // ExtraUtilities
        Item darkPortal = GameRegistry.findItem("ExtraUtilities", "dark_portal"); // disable deep dark portal
        util.removeRecipeByOutput(darkPortal);

        // Cooking for Blockheads
        Item recipebook = GameRegistry.findItem("cookingforblockheads", "recipebook"); // this shows disabled items
        util.removeRecipeByOutput(new ItemStack(recipebook, 1, 3));
    }

    @Override
    public Priority getPriority() {
        return Priority.HIGHEST;
    }
}
