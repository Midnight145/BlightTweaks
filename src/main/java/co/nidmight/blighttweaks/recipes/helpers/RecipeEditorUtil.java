package co.nidmight.blighttweaks.recipes.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
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

    static final RecipeEditorUtil instance = new RecipeEditorUtil();
    CachedR oreDictionary = new CachedR(OreDictionary.class);
    HashMap<ItemStackKey, List<String>> tooltipMap = new HashMap<>();

    List<ArrayList<ItemStack>> idToStack = oreDictionary.get("idToStack", List.class);

    CraftingManager manager = CraftingManager.getInstance();

    public RecipeEditorUtil() {
        if (instance != null) {
            throw new IllegalStateException("RecipeEditorUtil instance already exists!");
        }
        MinecraftForge.EVENT_BUS.register(this);
    }

    public boolean removeItemFromOreDict(String oreName, ItemStack stack) {
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

    public boolean removeItemFromOreDict(String oreName, Item item) {
        return removeItemFromOreDict(oreName, new ItemStack(item));
    }

    public static RecipeEditorUtil getInstance() {
        return instance;
    }

    public boolean removeRecipeByOutput(@Nonnull ItemStack output) {
        return removeRecipeByOutput(output, recipe -> true);
    }

    public boolean removeRecipeByOutput(@Nonnull ItemStack output, Predicate predicate) {
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

    public boolean removeRecipeByOutput(Item item) {
        return removeRecipeByOutput(new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE));
    }

    public boolean removeRecipeByOutput(Block block) {
        return removeRecipeByOutput(new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
    }

    public boolean removeShapedRecipeByOutput(@Nonnull ItemStack output) {
        return removeRecipeByOutput(output, PredicateUtil.isAnyInstanceOf(ShapedRecipes.class, ShapedOreRecipe.class));
    }

    public boolean removeShapelessRecipeByOutput(@Nonnull ItemStack output) {
        return removeRecipeByOutput(
            output,
            PredicateUtil.isAnyInstanceOf(ShapelessRecipes.class, ShapelessOreRecipe.class));
    }

    public boolean addTooltip(ItemStack stack, String... tooltips) {
        List<String> tooltips_ = tooltipMap.computeIfAbsent(ItemStackKey.of(stack), k -> new ArrayList<>());
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

    public boolean addTooltip(Item item, String... tooltip) {
        return addTooltip(new ItemStack(item), tooltip);
    }

    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        if (event.itemStack == null) return;
        List<String> tooltips = tooltipMap.get(ItemStackKey.of(event.itemStack));
        if (tooltips != null) {
            event.toolTip.addAll(tooltips);
        }
    }

    public boolean removeSmeltingRecipeByOutput(@Nonnull ItemStack output) {
        try {
            boolean removed = PredicateUtil.removeItemsFromMapValues(
//                CachedR.of(FurnaceRecipes.smelting())
//                    .get(ObfInfo.SMELTING_LIST, Map.class),
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

    public void removeSmeltingRecipeByOutput(Item bread) {
        removeSmeltingRecipeByOutput(new ItemStack(bread, 1, OreDictionary.WILDCARD_VALUE));
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
        if (!(o instanceof ItemStackKey)) return false;
        ItemStackKey k = (ItemStackKey) o;
        return item == k.item && damage == k.damage;
    }

    @Override
    public int hashCode() {
        return hash;
    }
}
