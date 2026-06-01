package co.nidmight.blighttweaks.recipes.helpers;

import java.util.function.Function;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import co.nidmight.blighttweaks.BlightCore;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;

public class ThaumcraftEditorUtil {

    public static Function<Object, ItemStack> IArcaneRecipeOutputExtractor = obj -> {
        try {
            if (obj instanceof IArcaneRecipe recipe) {
                return recipe.getRecipeOutput();
            }
        } catch (Exception e) {
            BlightCore.logger.error(e.getMessage(), e);
        }
        return null;
    };

    public static Function<Object, ItemStack> CrucibleRecipeExtractor = obj -> {
        try {
            if (obj instanceof CrucibleRecipe recipe) {
                return recipe.getRecipeOutput();
            }
        } catch (Exception e) {
            BlightCore.logger.error(e.getMessage(), e);
        }
        return null;
    };

    public static boolean removeThaumResearch(String researchKey) {
        ResearchItem item = ResearchCategories.getResearch(researchKey);
        item.setParents((String) null);
        item.setParentsHidden((String) null);
        item.setSiblings((String) null);
        ResearchCategories.researchCategories.get(item.category).research.remove(researchKey);
        return true;
    }

    public static boolean removeArcaneRecipeByOutput(ItemStack output) {
        return PredicateUtil.removeItemsFromList(
            ThaumcraftApi.getCraftingRecipes(),
            PredicateUtil.isAnyInstanceOf(IArcaneRecipe.class),
            PredicateUtil.compareItemAndMeta(output, IArcaneRecipeOutputExtractor));
    }

    public static boolean removeCrucibleRecipeByOutput(ItemStack output) {
        return PredicateUtil.removeItemsFromList(
            ThaumcraftApi.getCraftingRecipes(),
            PredicateUtil.isAnyInstanceOf(CrucibleRecipe.class),
            PredicateUtil.compareItemAndMeta(output, CrucibleRecipeExtractor));
    }

    public static void removeArcaneRecipeByOutput(Item output) {
        removeArcaneRecipeByOutput(new ItemStack(output, 1, OreDictionary.WILDCARD_VALUE));
    }
}
