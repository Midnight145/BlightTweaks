package co.nidmight.blighttweaks.recipes.tweaks;

import java.util.Arrays;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import co.nidmight.blighttweaks.recipes.framework.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.natura.common.NContent;

public class MiscTweaks implements IGameEditor {

    @Override
    public void apply() {
        RecipeEditorUtil util = RecipeEditorUtil.getInstance();
        util.removeRecipeByOutput(new ItemStack(Items.string));
        GameRegistry
            .addRecipe(new ShapelessOreRecipe(new ItemStack(Items.stick), "cropCotton", "cropCotton", "cropCotton"));
        GameRegistry.addShapelessRecipe(new ItemStack(NContent.seeds, 1, 1), new ItemStack(NContent.plantItem, 1, 3));

        // misc recipe book recipe tweaks
        Item recipebook = GameRegistry.findItem("cookingforblockheads", "recipebook");
        util.removeRecipeByOutput(new ItemStack(recipebook, 1, 1)); // remove the recipe for the crafting recipe book,
                                                                    // since it doesn't work and is just a placeholder
        GameRegistry.addRecipe(
            new ShapelessRecipes(
                new ItemStack(recipebook, 1, 1),
                Arrays.asList(new ItemStack(recipebook), new ItemStack(Blocks.crafting_table))));
        util.addTooltip(new ItemStack(recipebook), "Will hang for a couple of", "seconds when first opened.");

        // make CFB tool racks cheaper like in newer versions and use any wood type
        Item toolrack = GameRegistry.findItem("cookingforblockheads", "toolrack");
        util.removeRecipeByOutput(new ItemStack(toolrack));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(new ItemStack(toolrack), "WWW", "I I", 'W', "pressurePlateWood", 'I', "nuggetIron"));

    }

    @Override
    public Priority getPriority() {
        return Priority.HIGH; // needs to run before tabularasa adds its string recipe in
    }
}
