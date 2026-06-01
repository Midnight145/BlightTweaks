package co.nidmight.blighttweaks.recipes.removals;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import co.nidmight.blighttweaks.recipes.framework.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.TConstructEditorUtil;
import co.nidmight.blighttweaks.recipes.helpers.ThaumcraftEditorUtil;
import cpw.mods.fml.common.registry.GameRegistry;

public class RemovedResearch implements IGameEditor {

    @Override
    public void apply() {
        ThaumcraftEditorUtil.removeThaumResearch("thaumicenergistics.TETHAUMGBOX");
        ThaumcraftEditorUtil.removeThaumResearch("thaumicenergistics.Pseudo.COREUSE");
        ThaumcraftEditorUtil.removeThaumResearch("thaumicenergistics.TEIRONGEARBOX");

        Item material = GameRegistry.findItem("thaumicenergistics", "material");
        ItemStack materialStack = new ItemStack(material, 1, 2);
        ThaumcraftEditorUtil.removeArcaneRecipeByOutput(materialStack);
        TConstructEditorUtil.removeTableRecipeByOutput(materialStack);

        Item gearbox = GameRegistry.findItem("thaumicenergistics", "thaumicenergistics.block.gear.box");
        ThaumcraftEditorUtil.removeArcaneRecipeByOutput(gearbox);

        Item golemGearbox = GameRegistry.findItem("thaumicenergistics", "thaumicenergistics.block.golem.gear.box");
        ThaumcraftEditorUtil.removeCrucibleRecipeByOutput(new ItemStack(golemGearbox));

    }

    @Override
    public Priority getPriority() {
        return Priority.HIGHEST;
    }
}
