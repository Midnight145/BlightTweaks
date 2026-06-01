package co.nidmight.blighttweaks.recipes.helpers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;

import co.nidmight.blighttweaks.BlightCore;

public class PredicateUtil {

    public static Function<Object, ItemStack> IRecipeOutputExtractor = obj -> {
        try {
            if (obj instanceof IRecipe recipe) {
                return recipe.getRecipeOutput();
            }
        } catch (Exception e) {
            BlightCore.logger.error(e.getMessage(), e);
        }
        return null;
    };

    public static Function<Object, ItemStack> MapEntryValueExtractor = obj -> {
        try {
            if (obj instanceof Map.Entry<?, ?>entry) {
                Object value = entry.getValue();
                if (value instanceof ItemStack stack) {
                    return stack;
                }
            }
        } catch (Exception e) {
            BlightCore.logger.error(e.getMessage(), e);
        }
        return null;
    };

    public static Predicate compareItemAndMeta(ItemStack output, Function<Object, ItemStack> extractor) {
        return object -> {

            ItemStack recipeOutputStack = extractor.apply(object);
            if (recipeOutputStack == null || output == null) {
                return false;
            }
            boolean isWildcard = output.getItemDamage() == OreDictionary.WILDCARD_VALUE;
            return recipeOutputStack.getItem() == output.getItem()
                && ((recipeOutputStack.getItemDamage() == output.getItemDamage()) || isWildcard);
        };
    }

    public static Predicate isAnyInstanceOf(Class<?>... clazz) {
        return recipe -> {
            if (recipe == null || clazz == null) {
                return false;
            }
            for (Class<?> c : clazz) {
                if (c != null && c.isAssignableFrom(recipe.getClass())) {
                    return true;
                }
            }
            return false;
        };
    }

    @SafeVarargs
    public static boolean removeItemsFromList(List list, Predicate... predicates) {
        if (list == null || predicates == null || predicates.length == 0) return false;
        Predicate combined = Arrays.stream(predicates)
            .filter(Objects::nonNull)
            .reduce(t -> true, Predicate::and);
        return list.removeIf(combined);
    }

    public static boolean removeItemsFromMapValues(Map<?, ?> map, Predicate... predicates) {
        if (map == null || predicates == null || predicates.length == 0) return false;
        Predicate combined = Arrays.stream(predicates)
            .filter(Objects::nonNull)
            .reduce(t -> true, Predicate::and);
        boolean removed = false;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getValue() != null && combined.test(entry.getValue())) {
                map.remove(entry.getKey());
                removed = true;
            }
        }
        return removed;
    }
}
