package co.nidmight.blighttweaks.recipes.removals;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import co.nidmight.blighttweaks.recipes.helpers.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.TConstructEditorUtil;
import co.nidmight.blighttweaks.recipes.helpers.ThaumcraftEditorUtil;
import thaumicenergistics.common.blocks.BlockEnum;
import thaumicenergistics.common.items.ItemEnum;

public class RemovedResearch implements IGameEditor {

    @Override
    public void apply() {
        ThaumcraftEditorUtil.removeThaumResearch("thaumicenergistics.TETHAUMGBOX");
        ThaumcraftEditorUtil.removeThaumResearch("thaumicenergistics.Pseudo.COREUSE");
        ThaumcraftEditorUtil.removeThaumResearch("thaumicenergistics.TEIRONGEARBOX");

        Item material = ItemEnum.MATERIAL.getItem();
        ItemStack materialStack = new ItemStack(material, 1, 2);
        ThaumcraftEditorUtil.removeArcaneRecipeByOutput(materialStack);
        TConstructEditorUtil.removeTableRecipeByOutput(materialStack);

        Block ironGearbox = BlockEnum.IRON_GEAR_BOX.getBlock();
        ThaumcraftEditorUtil.removeArcaneRecipeByOutput(Item.getItemFromBlock(ironGearbox));

        Block golemGearbox = BlockEnum.THAUMIUM_GEAR_BOX.getBlock();
        ThaumcraftEditorUtil.removeCrucibleRecipeByOutput(new ItemStack(golemGearbox));

    }

    @Override
    public Priority getPriority() {
        return Priority.HIGHEST;
    }
}
