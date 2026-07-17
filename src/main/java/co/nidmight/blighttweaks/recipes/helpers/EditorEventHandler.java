package co.nidmight.blighttweaks.recipes.helpers;

import java.util.HashMap;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class EditorEventHandler {

    private static EditorEventHandler instance = new EditorEventHandler();
    private static HashMap<IRecipe, Tuple<ItemStack, ItemStack>> transformReplaceMap = new HashMap<>();
    static HashMap<ItemStackKey, List<String>> tooltipMap = new HashMap<>();

    public static EditorEventHandler getInstance() {
        return instance;
    }

    public EditorEventHandler() {
        if (instance != null) {
            throw new IllegalStateException("EditorEventHandler instance already exists!");
        }
        instance = this;
        FMLCommonHandler.instance()
            .bus()
            .register(this);
    }

    public void addTransformReplace(IRecipe recipe, ItemStack toReplace, ItemStack replacement) {
        transformReplaceMap.put(recipe, new Tuple<>(toReplace, replacement));
    }

    @SubscribeEvent
    public void onItemCraft(PlayerEvent.ItemCraftedEvent event) {
        for (var entry : transformReplaceMap.entrySet()) {
            int width, height;
            width = height = (int) Math.sqrt(event.craftMatrix.getSizeInventory());
            InventoryCrafting crafting = new InventoryCrafting(null, width, height);
            for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
                crafting.setInventorySlotContents(i, event.craftMatrix.getStackInSlot(i));
            }

            IRecipe recipe = entry.getKey();
            if (recipe.matches(crafting, event.player.worldObj)) {
                event.player.inventory.addItemStackToInventory(
                    entry.getValue()
                        .getSecond());
            }
        }
    }

    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        if (event.itemStack == null) return;
        List<String> tooltips = tooltipMap.get(ItemStackKey.of(event.itemStack));
        if (tooltips != null) {
            event.toolTip.addAll(tooltips);
        }
    }
}
