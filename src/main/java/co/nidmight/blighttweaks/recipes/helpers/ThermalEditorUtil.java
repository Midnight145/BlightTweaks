package co.nidmight.blighttweaks.recipes.helpers;

import java.util.Map;
import java.util.function.Function;

import net.minecraft.item.ItemStack;

import co.nidmight.blighttweaks.BlightCore;
import cofh.thermalexpansion.util.crafting.PulverizerManager;

public class ThermalEditorUtil {

    private static final CachedR pulverizerRecipeMap = CachedR.of(PulverizerManager.class);
    private static final Map<PulverizerManager.ComparableItemStackPulverizer, PulverizerManager.RecipePulverizer> recipes = pulverizerRecipeMap
        .get("recipeMap", Map.class);

    public static Function<Object, ItemStack> RecipePulverizerOutputExtractor = obj -> {
        try {
            if (obj instanceof PulverizerManager.RecipePulverizer recipe) {
                return recipe.getPrimaryOutput();
            }
        } catch (Exception e) {
            BlightCore.logger.error(e.getMessage(), e);
        }
        return null;
    };

    public static boolean removePulverizerRecipeByOutput(ItemStack output) {
        int size = recipes.size();
        recipes.entrySet()
            .stream()
            .filter(
                entry -> PredicateUtil.compareItemAndMeta(output, RecipePulverizerOutputExtractor)
                    .test(entry.getValue()))
            .forEach(entry -> recipes.remove(entry.getKey()));
        return size != recipes.size();
    }

    public static boolean removePulverizerRecipeByInput(ItemStack input) {
        if (!PulverizerManager.removeRecipe(input)) {
            BlightCore.logger.warn("Failed to remove pulverizer recipe for input " + input.getUnlocalizedName());
            return false;
        }
        return true;
    }
}
