package co.nidmight.blighttweaks.recipes.helpers;

import javax.annotation.Nullable;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import com.pam.harvestcraft.ItemRegistry;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigItems;
import vazkii.botania.common.item.ModItems;

public class ManaCookieDoughRecipe implements IRecipe {

    private final Aspect requiredAspect;
    private final ItemStack output;

    public ManaCookieDoughRecipe(@Nullable Aspect requiredAspect, ItemStack output) {
        this.requiredAspect = requiredAspect;
        this.output = output;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World world) {
        if (inv.getSizeInventory() < 9) {
            return false;
        }

        // FFF
        if (!isItem(inv.getStackInSlot(0), ItemRegistry.flourItem)) return false;
        if (!isItem(inv.getStackInSlot(1), ItemRegistry.flourItem)) return false;
        if (!isItem(inv.getStackInSlot(2), ItemRegistry.flourItem)) return false;

        // TBT
        if (!isMatchingBean(inv.getStackInSlot(3))) return false;
        if (!isItem(inv.getStackInSlot(4), ItemRegistry.butterItem)) return false;
        if (!isMatchingBean(inv.getStackInSlot(5))) return false;

        // TMT
        if (!isMatchingBean(inv.getStackInSlot(6))) return false;
        if (!isItem(inv.getStackInSlot(7), ModItems.manaBottle)) return false;
        if (!isMatchingBean(inv.getStackInSlot(8))) return false;

        return true;
    }

    private boolean isMatchingBean(ItemStack stack) {
        if (stack == null || stack.getItem() != ConfigItems.itemManaBean) {
            return false;
        }

        AspectList aspects = ThaumcraftEditorUtil.getAspectsFromManaBean(stack);

        if (aspects.size() != 1) {
            return false;
        }

        return requiredAspect == null || aspects.getAspects()[0] == requiredAspect;
    }

    private boolean isItem(ItemStack stack, Item item) {
        return stack != null && stack.getItem() == item;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return output.copy();
    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output;
    }
}
