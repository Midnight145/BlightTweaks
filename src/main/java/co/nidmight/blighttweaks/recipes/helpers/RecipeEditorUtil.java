package co.nidmight.blighttweaks.recipes.helpers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nonnull;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import co.nidmight.blighttweaks.BlightCore;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RecipeEditorUtil {

    private static final List<ArrayList<ItemStack>> idToStack;
    static {
        try {
            Field field = OreDictionary.class.getDeclaredField("idToStack");
            field.setAccessible(true);
            //noinspection unchecked
            idToStack = (List<ArrayList<ItemStack>>) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to access OreDictionary.idToStack", e);
        }
    }

    private static final CraftingManager manager = CraftingManager.getInstance();

    public static boolean removeItemFromOreDict(String oreName, ItemStack stack) {
        int oreId = OreDictionary.getOreID(oreName);
        if (oreId == -1) {
            return false;
        }
        List<ItemStack> stacks = idToStack.get(oreId);
        if (stacks == null) {
            return false;
        }
        boolean removed = stacks.removeIf(s -> ItemStack.areItemStacksEqual(s, stack));
        if (removed) {
            BlightCore.logger.info(
                "Removed {} from ore dictionary entry {}",
                stack.getItem()
                    .getUnlocalizedName(),
                oreName);
        } else {
            BlightCore.logger.warn(
                "Failed to remove {} from ore dictionary entry {}: not found in entry",
                stack.getItem()
                    .getUnlocalizedName(),
                oreName);
        }
        return removed;
    }

    public static boolean removeItemFromOreDict(String oreName, Item item) {
        return removeItemFromOreDict(oreName, new ItemStack(item));
    }

    public static boolean removeRecipeByOutput(@Nonnull ItemStack output) {
        return removeRecipeByOutput(output, recipe -> true);
    }

    public static boolean removeRecipeByOutput(@Nonnull ItemStack output, Predicate predicate) {
        try {
            boolean removed = PredicateUtil.removeItemsFromList(
                manager.getRecipeList(),
                predicate,
                PredicateUtil.compareItemAndMeta(output, PredicateUtil.IRecipeOutputExtractor));
            if (!removed) {
                BlightCore.logger
                    .warn("Failed to remove {} from crafting manager: not found", output.getUnlocalizedName());
            } else {
                BlightCore.logger.info("Removed recipe(s) producing {}", output.getUnlocalizedName());
            }
            return removed;
        } catch (Exception e) {
            BlightCore.logger.error("Failed to remove recipe {} from crafting manager", output.getUnlocalizedName(), e);
            return false;
        }
    }

    public static boolean removeRecipeByOutput(Item item) {
        return removeRecipeByOutput(new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE));
    }

    public static boolean removeRecipeByOutput(Block block) {
        return removeRecipeByOutput(new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
    }

    public static boolean removeShapedRecipeByOutput(@Nonnull ItemStack output) {
        return removeRecipeByOutput(output, PredicateUtil.isAnyInstanceOf(ShapedRecipes.class, ShapedOreRecipe.class));
    }

    public static boolean removeShapelessRecipeByOutput(@Nonnull ItemStack output) {
        return removeRecipeByOutput(
            output,
            PredicateUtil.isAnyInstanceOf(ShapelessRecipes.class, ShapelessOreRecipe.class));
    }

    public static IRecipe getRecipeByOutput(@Nonnull ItemStack output, boolean compareStackSize) {
        try {
            IRecipe recipe;
            if (compareStackSize) {
                recipe = (IRecipe) PredicateUtil.findFirstItemInList(manager.getRecipeList(), object -> {
                    ItemStack recipeOutputStack = PredicateUtil.IRecipeOutputExtractor.apply(object);
                    return ItemStack.areItemStacksEqual(recipeOutputStack, output);
                });
            } else {
                recipe = (IRecipe) PredicateUtil.findFirstItemInList(
                    manager.getRecipeList(),
                    PredicateUtil.compareItemAndMeta(output, PredicateUtil.IRecipeOutputExtractor));
            }
            if (recipe == null) {
                BlightCore.logger
                    .warn("Failed to find recipe {} from crafting manager: not found", output.getUnlocalizedName());
            }
            return recipe;
        } catch (Exception e) {
            BlightCore.logger.error("Failed to find recipe {} from crafting manager", output.getUnlocalizedName(), e);
            return null;
        }
    }

    public static boolean addTooltip(ItemStack stack, String... tooltips) {
        List<String> tooltips_ = EditorEventHandler.tooltipMap.computeIfAbsent(ItemStackKey.of(stack), k -> new ArrayList<>());
        for (String tooltip : tooltips) {
            if (tooltips_.contains(tooltip)) {
                BlightCore.logger.warn("Tooltip {} already exists for {}", tooltip, stack.getDisplayName());
                return false;
            }
            tooltips_.add(tooltip);
            BlightCore.logger.info("Added tooltip {} to {}", tooltip, stack.getDisplayName());
        }

        return true;
    }

    public static boolean addTooltip(Item item, String... tooltip) {
        return addTooltip(new ItemStack(item), tooltip);
    }

    public static boolean removeSmeltingRecipeByOutput(@Nonnull ItemStack output) {
        try {
            boolean removed = PredicateUtil.removeItemsFromMapValues(
                FurnaceRecipes.smelting().smeltingList,
                PredicateUtil.compareItemAndMeta(output, PredicateUtil.MapEntryValueExtractor));
            if (!removed) {
                BlightCore.logger
                    .warn("Failed to remove {} from furnace recipes: not found", output.getUnlocalizedName());
            } else {
                BlightCore.logger.info("Removed furnace recipe(s) producing {}", output.getUnlocalizedName());
            }
            return removed;
        } catch (Exception e) {
            BlightCore.logger.error("Failed to remove {} from furnace recipes", output.getUnlocalizedName(), e);
            return false;
        }
    }

    public static void removeSmeltingRecipeByOutput(Item bread) {
        removeSmeltingRecipeByOutput(new ItemStack(bread, 1, OreDictionary.WILDCARD_VALUE));
    }

    public static ItemStack parseItemStack(String itemStack) {
        return parseItemStack(itemStack, 1);
    }

    public static ItemStack parseItemStack(String itemStack, int amount) {
        // Expected format: <modid:itemname[:meta]>
        itemStack = itemStack.substring(1, itemStack.length() - 1); // strip <>
        String[] parts = itemStack.split(":");
        if (parts.length < 2 || parts.length > 3) {
            throw new IllegalArgumentException("Invalid item stack format: " + itemStack);
        }
        String modId = parts[0];
        String itemName = parts[1];
        int meta = parts.length == 3 ? (parts[2].equals("*") ? OreDictionary.WILDCARD_VALUE : Integer.parseInt(parts[2])) : 0;

        ItemStack stack = GameRegistry.findItemStack(modId, itemName, amount);
        stack.setItemDamage(meta);
        return stack;
    }
}

/**
 * Quick hacky class to use ItemStacks as a key while ignoring stack size. Only considers item, metadata which is good
 * enough for our use case.
 */
final class ItemStackKey {

    private final Item item;
    private final int damage;
    private final int hash;

    public ItemStackKey(ItemStack stack) {
        this.item = stack.getItem();
        this.damage = stack.getItemDamage();
        this.hash = 31 * (item != null ? item.hashCode() : 0) + damage;
    }

    public static ItemStackKey of(ItemStack stack) {
        return new ItemStackKey(stack);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemStackKey k)) return false;
        return item == k.item && damage == k.damage;
    }

    @Override
    public int hashCode() {
        return hash;
    }
}
