package co.nidmight.blighttweaks.recipes.helpers;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cofh.lib.util.WeightedRandomItemStack;
import powercrystals.minefactoryreloaded.MFRRegistry;

public class MFREditorUtil {



    public void removeLaserOre(Item item) {
        MFREditorUtil.removeLaserOre(new ItemStack(item));
    }

    public static void removeLaserOre(ItemStack itemStack) {
        PredicateUtil.removeItemsFromList(
            MFRRegistry.getLaserOres(),
            PredicateUtil.compareItemAndMeta(
                itemStack,
                obj -> obj instanceof WeightedRandomItemStack stack ? stack.getStack() : null));
    }

    public static void removePreferredOre(int focus, String itemStackString) {
        ItemStack itemStack = RecipeEditorUtil.parseItemStack(itemStackString);
        PredicateUtil.removeItemsFromList(
            MFRRegistry.getLaserPreferredOres(focus),
            PredicateUtil.compareItemAndMeta(
                itemStack,
                obj -> obj instanceof ItemStack stack ? stack : null));
    }

    public static void addPreferredOre(int focus, String itemStackString) {
        ItemStack itemStack = RecipeEditorUtil.parseItemStack(itemStackString);
        MFRRegistry.addLaserPreferredOre(focus, itemStack);
    }
}
