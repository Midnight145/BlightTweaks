package co.nidmight.blighttweaks.recipes.tweaks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import co.nidmight.blighttweaks.recipes.helpers.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.LocalizationUtil;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import cpw.mods.fml.common.registry.GameRegistry;
import noppes.npcs.CustomItems;

public class CustomNPCItemTweaks implements IGameEditor {

    @Override
    public void apply() {
        RecipeEditorUtil.addTooltip(
            lookupItem("npcStoneReversedDagger"),
            StatCollector.translateToLocal("tooltip.npcStoneReversedDagger.desc.1"));
        RecipeEditorUtil.addTooltip(
            lookupItem("npcStoneReversedDagger"),
            StatCollector.translateToLocal("tooltip.npcStoneReversedDagger.desc.2"));

        RecipeEditorUtil.addTooltip(lookupItem("npcSlingshot"), StatCollector.translateToLocal("tooltip.npcSlingshot.desc.1"));
        RecipeEditorUtil.addTooltip(lookupItem("npcSlingshot"), StatCollector.translateToLocal("tooltip.npcSlingshot.desc.2"));
        RecipeEditorUtil.addTooltip(lookupItem("npcSlingshot"), StatCollector.translateToLocal("tooltip.npcSlingshot.desc.3"));

        RecipeEditorUtil.addTooltip(
            lookupItem("npcFullWoodenShield"),
            StatCollector.translateToLocal("tooltip.npcFullWoodenShield.desc.1"));
        RecipeEditorUtil.addTooltip(
            lookupItem("npcFullWoodenShield"),
            StatCollector.translateToLocal("tooltip.npcFullWoodenShield.desc.2"));

        RecipeEditorUtil.addTooltip(lookupItem("npcStoneShield"), StatCollector.translateToLocal("tooltip.npcStoneShield.desc.1"));
        RecipeEditorUtil.addTooltip(lookupItem("npcStoneShield"), StatCollector.translateToLocal("tooltip.npcStoneShield.desc.2"));

        RecipeEditorUtil.addTooltip(lookupItem("npcOcarina"), StatCollector.translateToLocal("tooltip.npcOcarina.desc.1"));
        RecipeEditorUtil.addTooltip(lookupItem("npcOcarina"), StatCollector.translateToLocal("tooltip.npcOcarina.desc.2"));

        RecipeEditorUtil.addTooltip(lookupItem("npcPendant"), StatCollector.translateToLocal("tooltip.npcPendant.desc.1"));
        RecipeEditorUtil.addTooltip(lookupItem("npcPendant"), StatCollector.translateToLocal("tooltip.npcPendant.desc.2"));

        RecipeEditorUtil.addTooltip(lookupItem("npcLocket"), StatCollector.translateToLocal("tooltip.npcPendant.desc.1"));
        RecipeEditorUtil.addTooltip(lookupItem("npcLocket"), StatCollector.translateToLocal("tooltip.npcPendant.desc.2"));

        RecipeEditorUtil.addTooltip(lookupItem("npcStatuette"), StatCollector.translateToLocal("tooltip.npcPendant.desc.1"));
        RecipeEditorUtil.addTooltip(lookupItem("npcStatuette"), StatCollector.translateToLocal("tooltip.npcPendant.desc.2"));

        Item harp = lookupItem("npcHarp");
        // customnpcs registers item in setUnlocalizedName for some awful reason so we have to do this bullshit
        LocalizationUtil.setLocalization(
            harp.getUnlocalizedName() + ".name",
            StatCollector.translateToLocal("item.blighttweaks.npcHarp.name"));
        RecipeEditorUtil.addTooltip(harp, StatCollector.translateToLocal("tooltip.npcHarp.desc.1"));
        RecipeEditorUtil.addTooltip(harp, StatCollector.translateToLocal("tooltip.npcHarp.desc.2"));

        Item crowbar = lookupItem("npcCrowbar");
        // spotless:off
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(crowbar), " CI", "CIC", "IC ", 'C', new ItemStack(Blocks.carpet, 1, 14), 'I', "ingotSteel"));
        // spotless:on
        RecipeEditorUtil.addTooltip(crowbar, StatCollector.translateToLocal("tooltip.crowbar.desc.1"));
        RecipeEditorUtil.addTooltip(crowbar, StatCollector.translateToLocal("tooltip.crowbar.desc.2"));
        RecipeEditorUtil.addTooltip(crowbar, StatCollector.translateToLocal("tooltip.crowbar.desc.3"));

        Item frenchHorn = lookupItem("npcFrenchHorn");
        GameRegistry.addRecipe(
            new ShapedOreRecipe(new ItemStack(frenchHorn), "  I", "INI", " II", 'I', "ingotBrass", 'N', "nuggetIron"));
        RecipeEditorUtil.addTooltip(frenchHorn, StatCollector.translateToLocal("tooltip.npcFrenchHorn.desc.1"));
        RecipeEditorUtil.addTooltip(frenchHorn, StatCollector.translateToLocal("tooltip.npcFrenchHorn.desc.2"));
        RecipeEditorUtil.addTooltip(frenchHorn, StatCollector.translateToLocal("tooltip.npcFrenchHorn.desc.3"));

        // Guns

        // spotless:off
        GameRegistry.addRecipe(new ShapedOreRecipe(CustomItems.gunWood, "WWL", " SW", 'W', "plankWood", 'L', new ItemStack(Blocks.lever), 'S', new ItemStack(Blocks.stone_button)));
        GameRegistry.addRecipe(new ShapedOreRecipe(CustomItems.gunStone, "CCL", " SW", 'C', "cobblestone", 'L', new ItemStack(Blocks.lever), 'S', new ItemStack(Blocks.stone_button), 'W', "plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(CustomItems.gunIron, "IIL", " SW", 'I', "ingotIron", 'L', new ItemStack(Blocks.lever), 'S', new ItemStack(Blocks.stone_button), 'W', "plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(CustomItems.gunGold, "GGL", " SW", 'G', "ingotGold", 'L', new ItemStack(Blocks.lever), 'S', new ItemStack(Blocks.stone_button), 'W', "plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(CustomItems.gunBronze, "BBL", " SW", 'B', "ingotBronze", 'L', new ItemStack(Blocks.lever), 'S', new ItemStack(Blocks.stone_button), 'W', "plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(CustomItems.gunDiamond, "DDL", " SW", 'D', "gemDiamond", 'L', new ItemStack(Blocks.lever), 'S', new ItemStack(Blocks.stone_button), 'W', "plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(CustomItems.gunEmerald, "EEL", " SW", 'E', "gemEmerald", 'L', new ItemStack(Blocks.lever), 'S', new ItemStack(Blocks.stone_button), 'W', "plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(CustomItems.gunMachine, "SSL", " BW", 'S', "ingotSteel", 'L', new ItemStack(Blocks.lever), 'B', new ItemStack(Blocks.stone_button), 'W', "plankWood"));
        // spotless:on

        RecipeEditorUtil.addTooltip(CustomItems.gunWood, String.format(StatCollector.translateToLocal("tooltip.npcGun.damage"), 5));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunStone,
            String.format(StatCollector.translateToLocal("tooltip.npcGun.damage"), 6));
        RecipeEditorUtil.addTooltip(CustomItems.gunIron, String.format(StatCollector.translateToLocal("tooltip.npcGun.damage"), 7));
        RecipeEditorUtil.addTooltip(CustomItems.gunGold, String.format(StatCollector.translateToLocal("tooltip.npcGun.damage"), 6));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunBronze,
            String.format(StatCollector.translateToLocal("tooltip.npcGun.damage"), 7));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunDiamond,
            String.format(StatCollector.translateToLocal("tooltip.npcGun.damage"), 8));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunEmerald,
            String.format(StatCollector.translateToLocal("tooltip.npcGun.damage"), 9));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunMachine,
            String.format(StatCollector.translateToLocal("tooltip.npcGun.damage"), 4));

        RecipeEditorUtil.addTooltip(
            CustomItems.gunWood,
            String.format(
                StatCollector.translateToLocal("tooltip.npcGun.onlyFires"),
                StatCollector.translateToLocal("tooltip.npcGunBulletWooden")));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunStone,
            String.format(
                StatCollector.translateToLocal("tooltip.npcGun.onlyFires"),
                StatCollector.translateToLocal("tooltip.npcGunBulletStone")));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunIron,
            String.format(
                StatCollector.translateToLocal("tooltip.npcGun.onlyFires"),
                StatCollector.translateToLocal("tooltip.npcGunBulletIron")));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunGold,
            String.format(
                StatCollector.translateToLocal("tooltip.npcGun.onlyFires"),
                StatCollector.translateToLocal("tooltip.npcGunBulletGold")));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunBronze,
            String.format(
                StatCollector.translateToLocal("tooltip.npcGun.onlyFires"),
                StatCollector.translateToLocal("tooltip.npcGunBulletBronze")));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunDiamond,
            String.format(
                StatCollector.translateToLocal("tooltip.npcGun.onlyFires"),
                StatCollector.translateToLocal("tooltip.npcGunBulletDiamond")));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunEmerald,
            String.format(
                StatCollector.translateToLocal("tooltip.npcGun.onlyFires"),
                StatCollector.translateToLocal("tooltip.npcGunBulletEmerald")));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunMachine,
            String.format(
                StatCollector.translateToLocal("tooltip.npcGun.onlyFires"),
                StatCollector.translateToLocal("tooltip.npcGunBulletMachine")));

        RecipeEditorUtil.addTooltip(CustomItems.gunWood, StatCollector.translateToLocal("tooltip.npcGun.highlyInaccurate"));
        RecipeEditorUtil.addTooltip(CustomItems.gunStone, StatCollector.translateToLocal("tooltip.npcGun.highlyInaccurate"));
        RecipeEditorUtil.addTooltip(CustomItems.gunIron, StatCollector.translateToLocal("tooltip.npcGun.highlyInaccurate"));
        RecipeEditorUtil.addTooltip(CustomItems.gunGold, StatCollector.translateToLocal("tooltip.npcGunGold.highlyInaccurate1"));
        RecipeEditorUtil.addTooltip(CustomItems.gunGold, StatCollector.translateToLocal("tooltip.npcGunGold.highlyInaccurate2"));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunBronze,
            StatCollector.translateToLocal("tooltip.npcGunBronze.highlyInaccurate1"));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunBronze,
            StatCollector.translateToLocal("tooltip.npcGunBronze.highlyInaccurate2"));
        RecipeEditorUtil.addTooltip(CustomItems.gunDiamond, StatCollector.translateToLocal("tooltip.npcGun.highlyInnacurate"));
        RecipeEditorUtil.addTooltip(CustomItems.gunEmerald, StatCollector.translateToLocal("tooltip.npcGun.highlyInaccurate"));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunMachine,
            StatCollector.translateToLocal("tooltip.npcGunMachine.highlyInaccurate1"));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunMachine,
            StatCollector.translateToLocal("tooltip.npcGunMachine.highlyInaccurate2"));
        RecipeEditorUtil.addTooltip(
            CustomItems.gunMachine,
            StatCollector.translateToLocal("tooltip.npcGunMachine.highlyInaccurate3"));

        // Bullets
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(CustomItems.bulletWood, 6),
                "plankWood",
                new ItemStack(Items.gunpowder)));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(CustomItems.bulletStone, 6),
                "cobblestone",
                new ItemStack(Items.gunpowder)));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(CustomItems.bulletIron, 6),
                "ingotIron",
                new ItemStack(Items.gunpowder)));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(CustomItems.bulletGold, 6),
                "ingotGold",
                new ItemStack(Items.gunpowder)));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(CustomItems.bulletBronze, 6),
                "ingotBronze",
                new ItemStack(Items.gunpowder)));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(CustomItems.bulletDiamond, 6),
                "gemDiamond",
                new ItemStack(Items.gunpowder)));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(CustomItems.bulletEmerald, 6),
                "gemEmerald",
                new ItemStack(Items.gunpowder)));
        GameRegistry.addRecipe(
            new ShapelessOreRecipe(
                new ItemStack(CustomItems.bulletBlack, 12),
                "ingotSteel",
                new ItemStack(Items.gunpowder)));

    }

    private Item lookupItem(String name) {
        return GameRegistry.findItem("customnpcs", name);
    }

    @Override
    public Priority getPriority() {
        return Priority.LOWEST;
    }
}
