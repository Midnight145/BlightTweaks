package co.nidmight.blighttweaks.recipes.removals;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;

import co.nidmight.blighttweaks.recipes.framework.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;

public class ExecutiveMandate2625B implements IGameEditor {

    @Override
    public void apply() {
        final String tooltip1 = EnumChatFormatting.DARK_RED + "Use is "
            + EnumChatFormatting.BOLD
            + "prohibited"
            + EnumChatFormatting.DARK_RED
            + " under "
            + EnumChatFormatting.BOLD
            + "Executive Mandate 2625b"
            + EnumChatFormatting.DARK_RED
            + ".";
        final String tooltip2 = EnumChatFormatting.DARK_RED + "This item will "
            + EnumChatFormatting.BOLD
            + "self-destruct"
            + EnumChatFormatting.DARK_RED
            + " when used.";
        // spotless:off
        Item[] items = new Item[] { Items.wooden_axe, Items.wooden_hoe, Items.wooden_pickaxe, Items.wooden_shovel,
            Items.wooden_sword, Items.stone_axe, Items.stone_hoe, Items.stone_pickaxe, Items.stone_shovel,
            Items.stone_sword, Items.iron_axe, Items.iron_hoe, Items.iron_pickaxe, Items.iron_shovel, Items.iron_sword,
            Items.golden_axe, Items.golden_hoe, Items.golden_pickaxe, Items.golden_shovel, Items.golden_sword,
            Items.diamond_axe, Items.diamond_hoe, Items.diamond_pickaxe, Items.diamond_shovel, Items.diamond_sword };
        // spotless:on
        RecipeEditorUtil util = RecipeEditorUtil.getInstance();
        for (Item item : items) {
            util.removeRecipeByOutput(item);
            util.addTooltip(item, tooltip1);
            util.addTooltip(item, tooltip2);
        }
    }

    @Override
    public Priority getPriority() {
        return Priority.HIGHEST;
    }
}
