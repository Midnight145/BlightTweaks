package co.nidmight.blighttweaks.recipes.removals;

import net.blay09.mods.cookingforblockheads.CookingForBlockheads;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.rwtema.extrautils.ExtraUtils;

import co.nidmight.blighttweaks.recipes.helpers.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import co.nidmight.blighttweaks.recipes.helpers.ThermalEditorUtil;
import cofh.thermalexpansion.block.TEBlocks;
import cofh.thermalexpansion.item.TEAugments;
import cofh.thermalfoundation.item.TFItems;
import cpw.mods.fml.common.registry.GameRegistry;
import mcp.mobius.betterbarrels.BetterBarrels;
import mods.natura.common.NContent;
import noppes.npcs.CustomItems;

public class DisabledItems implements IGameEditor {

    @Override
    public void apply() {
        // MFR
        // couldn't be assed to figure out how mfr registers its items, so just hardcoding the names here.
        Item mfrMachine0 = GameRegistry.findItem("MineFactoryReloaded", "machine.0");
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(mfrMachine0, 1, 7)); // Block Breaker
        Item mfrMachine1 = GameRegistry.findItem("MineFactoryReloaded", "machine.1");
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(mfrMachine1, 1, 6)); // Steam Boiler
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(mfrMachine1, 1, 10)); // BioReactor
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(mfrMachine1, 1, 11)); // BioFuel Generator

        Item augment = TEAugments.itemAugment;
        int[] metas = { 48, 49, 64, 65, 66, 80, 81, 82 };
        for (int meta : metas) {
            RecipeEditorUtil.removeRecipeByOutput(new ItemStack(augment, 1, meta));
        }

        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(TEBlocks.blockDevice, 1, 3)); // Terrain Smasher

        RecipeEditorUtil.removeRecipeByOutput(TFItems.lexicon);

        // Natura
        Item barleyFood = NContent.plantItem;
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(barleyFood, 1, 1)); // Natura flour
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(barleyFood, 1, 2)); // Natura flour
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(barleyFood, 1, 4)); // Natura Sulfur

        // AE2
        var ae2Api = appeng.core.Api.INSTANCE;
        var ae2Blocks = ae2Api.definitions()
            .blocks();
        RecipeEditorUtil.removeRecipeByOutput(
            ae2Blocks.skyCompass()
                .maybeBlock()
                .get());
        ThermalEditorUtil.removePulverizerRecipeByInput(
            new ItemStack(
                ae2Blocks.skyStone()
                    .maybeBlock()
                    .get()));

        // JABBA
        RecipeEditorUtil.removeRecipeByOutput(BetterBarrels.itemMoverDiamond);

        // CustomNPCs
        RecipeEditorUtil.removeRecipeByOutput(CustomItems.wand);
        RecipeEditorUtil.removeRecipeByOutput(GameRegistry.findItem("customnpcs", "npcMagicWand")); // why is this not a field :sob:

        // Thaumic Tinkerer
        // I'm not dealing with TT's metaitem registry nonsense, so just hardcoding the item names here
        Item wardSlab = GameRegistry.findItem("ThaumicTinkerer", "wardSlab");
        RecipeEditorUtil.removeShapedRecipeByOutput(new ItemStack(wardSlab, 1, 0));
        Item kamiResource = GameRegistry.findItem("ThaumicTinkerer", "kamiResource");
        RecipeEditorUtil.removeShapedRecipeByOutput(new ItemStack(kamiResource, 1, 3)); // useless ichorium nuggets

        // ExtraUtilities
        Block darkPortal = ExtraUtils.portal;
        RecipeEditorUtil.removeRecipeByOutput(darkPortal);

        // Cooking for Blockheads
        Item recipebook = CookingForBlockheads.itemRecipeBook;
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(recipebook, 1, 3));
    }

    @Override
    public Priority getPriority() {
        return Priority.HIGHEST;
    }
}
