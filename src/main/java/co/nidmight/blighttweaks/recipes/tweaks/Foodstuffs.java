package co.nidmight.blighttweaks.recipes.tweaks;

import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.pam.harvestcraft.ItemRegistry;

import co.nidmight.blighttweaks.recipes.helpers.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import cofh.thermalexpansion.util.crafting.FurnaceManager;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.natura.common.NContent;
import tconstruct.armor.TinkerArmor;
import tconstruct.library.crafting.DryingRackRecipes;

public class Foodstuffs implements IGameEditor {

    @Override
    public void apply() {
        // Oredict fixes

        OreDictionary.registerOre("listAllberry", new ItemStack(NContent.berryItem, 1, 0));
        OreDictionary.registerOre("listAllberry", new ItemStack(NContent.berryItem, 1, 1));
        OreDictionary.registerOre("listAllberry", new ItemStack(NContent.berryItem, 1, 2));
        OreDictionary.registerOre("listAllberry", new ItemStack(NContent.berryItem, 1, 3));

        OreDictionary.registerOre("listAllgrain", new ItemStack(NContent.plantItem)); // register Natura barley as a
                                                                                      // grain for HarvestCraft recipes

        // Re-adding a few removed recipes in HarvestCraftRemovals, either for balance or oredict
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.freshwaterItem), "listAllwater"));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(ItemRegistry.vegemiteItem),
                new ItemStack(ItemRegistry.potItem),
                "listAllsugar",
                "listAllwater",
                new ItemStack(ItemRegistry.spiceleafItem),
                new ItemStack(NContent.plantItem, 1, 0)));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(new ItemStack(ItemRegistry.flourItem), "toolMortarandpestle", "listAllgrain"));
        RecipeEditorUtil.removeRecipeByOutput(Items.cake);

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(Items.cake),
                "MMM",
                "SBS",
                'M',
                "listAllmilk",
                'S',
                "listAllsugar",
                'B',
                "foodBatter"));

        // Primitive Bread Modifications
        RecipeEditorUtil.removeRecipeByOutput(Items.bread);
        ItemStack primitiveBread = new ItemStack(Items.bread);
        NBTTagCompound tag = new NBTTagCompound();
        NBTTagCompound display = new NBTTagCompound();
        display.setString("Name", "Primitive Bread");
        NBTTagList lore = new NBTTagList();
        lore.appendTag(new NBTTagString("Kinda rough. Try grinding it into"));
        lore.appendTag(new NBTTagString("flour then baking it instead!"));
        display.setTag("Lore", lore);
        tag.setTag("display", display);
        primitiveBread.setTagCompound(tag);

        GameRegistry.addRecipe(new ShapedOreRecipe(primitiveBread, "GGG", 'G', "listAllgrain"));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(new ItemStack(ItemRegistry.flourItem), "toolMortarandpestle", "listAllgrain"));

        FurnaceManager.addTERecipe(800, new ItemStack(ItemRegistry.flourItem), new ItemStack(Items.bread));

        RecipeEditorUtil.removeSmeltingRecipeByOutput(Items.bread);
        List<ItemStack> items = OreDictionary.getOres("foodFlour");
        for (ItemStack item : items) {
            ItemStack input = item.copy();
            input.stackSize = 1;
            FurnaceRecipes.smelting()
                .func_151394_a(input, new ItemStack(Items.bread), .1f);
        }

        // Tooltips
        ItemRegistry.snickersbarItem.setUnlocalizedName("blighttweaks.snickersbar");
        RecipeEditorUtil.addTooltip(
            ItemRegistry.snickersbarItem,
            "Tastes horrible, but is completely immune",
            "to the effects of diminishing returns!");

        RecipeEditorUtil.addTooltip(
            ItemRegistry.sunflowerseedsItem,
            "Cannot be planted.",
            "At least Driskel gave",
            "us a bunch of them...");

        // Misc. drying recipes

        // why the hell is this in TinkerArmor??? why not in TinkerWorld with SpecialFood, StrangeFood???
        Item jerky = TinkerArmor.jerky;
        DryingRackRecipes.addDryingRecipe(new ItemStack(ItemRegistry.muttonrawItem), 6000, new ItemStack(jerky, 1, 3));
        DryingRackRecipes.addDryingRecipe(new ItemStack(Items.fish, 1, 1), 6000, new ItemStack(jerky, 1, 4));

    }

    @Override
    public Priority getPriority() {
        return Priority.NORMAL;
    }
}
