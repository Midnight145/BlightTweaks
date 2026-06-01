package co.nidmight.blighttweaks.recipes.helpers;

import java.util.function.Function;

import net.minecraft.item.ItemStack;

import tconstruct.TConstruct;
import tconstruct.library.crafting.CastingRecipe;

public class TConstructEditorUtil {

    public static Function<Object, ItemStack> CastingRecipeOutputExtractor = obj -> {
        if (obj instanceof CastingRecipe recipe) {
            return recipe.getResult();
        }
        return null;
    };

    public static boolean removeTableRecipeByOutput(ItemStack output) {
        return PredicateUtil.removeItemsFromList(
            TConstruct.tableCasting.getCastingRecipes(),
            PredicateUtil.compareItemAndMeta(output, CastingRecipeOutputExtractor));
    }
}
