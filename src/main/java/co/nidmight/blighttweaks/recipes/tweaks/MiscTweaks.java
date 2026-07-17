package co.nidmight.blighttweaks.recipes.tweaks;

import java.util.Arrays;

import net.blay09.mods.cookingforblockheads.CookingForBlockheads;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import co.nidmight.blighttweaks.recipes.helpers.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import cofh.thermalfoundation.item.TFItems;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.natura.common.NContent;
import tconstruct.library.TConstructRegistry;

public class MiscTweaks implements IGameEditor {

    @Override
    public void apply() {
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(Items.string));
        GameRegistry
            .addRecipe(new ShapelessOreRecipe(new ItemStack(Items.string), "cropCotton", "cropCotton", "cropCotton"));
        GameRegistry.addShapelessRecipe(new ItemStack(NContent.seeds, 1, 1), new ItemStack(NContent.plantItem, 1, 3));

        // misc recipe book recipe tweaks
        Item recipebook = CookingForBlockheads.itemRecipeBook;
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(recipebook, 1, 1));
        GameRegistry.addRecipe(
            new ShapelessRecipes(
                new ItemStack(recipebook, 1, 1),
                Arrays.asList(new ItemStack(recipebook), new ItemStack(Blocks.crafting_table))));
        RecipeEditorUtil.addTooltip(new ItemStack(recipebook), "Will hang for a couple of", "seconds when first opened.");

        // make CFB tool racks cheaper like in newer versions and use any wood type
        Block toolrack = CookingForBlockheads.blockToolRack;
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(toolrack));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(new ItemStack(toolrack), "WWW", "I I", 'W', "pressurePlateWood", 'I', "nuggetIron"));

        // iron gear casting recipe
        Item gearCast = GameRegistry.findItem("TConstruct", "gearCast");
        TConstructRegistry.getTableCasting()
            .addCastingRecipe(
                new ItemStack(TFItems.itemMaterial, 1, 12),
                new FluidStack(FluidRegistry.getFluid("iron.molten"), 576),
                new ItemStack(gearCast),
                false,
                20);


        OreDictionary.registerOre("steelPickaxeQuest", GameRegistry.findItem("Metallurgy", "steel.pickaxe"));
        ItemStack pickaxeHead = GameRegistry.findItemStack("TConstruct", "pickaxeHead", 1);
        pickaxeHead.setItemDamage(16);
        OreDictionary.registerOre("steelPickaxeQuest", pickaxeHead);
    }

    @Override
    public Priority getPriority() {
        return Priority.HIGH; // needs to run before tabularasa adds its string recipe in
    }
}
