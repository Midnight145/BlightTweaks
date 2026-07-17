package co.nidmight.blighttweaks.recipes.additions.thaumcraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.Tuple;
import cofh.thermalexpansion.block.TEBlocks;
import cofh.thermalfoundation.item.TFItems;
import cpw.mods.fml.common.registry.GameRegistry;
import talonos.blightbuster.blocks.BBBlock;
import talonos.blightbuster.items.BBItems;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.item.ModItems;

public class BlightbusterResearch implements IGameEditor {

    @Override
    public void apply() {

        // Silver Potion Research
        ResearchItem silverPotionResearch = new ResearchItem(
            "SILVERPOTION",
            "ALCHEMY",
            new AspectList().add(Aspect.WATER, 3)
                .add(Aspect.HEAL, 6)
                .add(Aspect.TAINT, 3)
                .add(Aspect.PLANT, 3),
            -1,
            -4,
            -2,
            new ItemStack(BBItems.silverPotion));
        silverPotionResearch.setParents("ETHEREALBLOOM");
        silverPotionResearch.setConcealed();
        IArcaneRecipe silverPotionRecipe = ThaumcraftApi.addArcaneCraftingRecipe(
            "SILVERPOTION",
            new ItemStack(BBItems.silverPotion, 6),
            new AspectList().add(Aspect.WATER, 15)
                .add(Aspect.ORDER, 24),
            "GLG",
            'G',
            new ItemStack(Items.glass_bottle),
            'L',
            new ItemStack(ConfigBlocks.blockMagicalLeaves, 1, 1));
        silverPotionResearch
            .setPages(new ResearchPage("tc.research_page.SILVERPOTION.1"), new ResearchPage(silverPotionRecipe));
        silverPotionResearch.registerResearchItem();

        // Purity Focus Research
        ResearchItem purityFocusResearch = new ResearchItem(
            "PURITYFOCUS",
            "ALCHEMY",
            new AspectList().add(Aspect.TOOL, 3)
                .add(Aspect.HEAL, 6)
                .add(Aspect.TAINT, 3)
                .add(Aspect.MAGIC, 3),
            -3,
            -4,
            2,
            new ItemStack(BBItems.purityFocus));
        purityFocusResearch.setParents("ETHEREALBLOOM");
        purityFocusResearch.setConcealed();
        IArcaneRecipe purityFocusRecipe = ThaumcraftApi.addArcaneCraftingRecipe(
            "PURITYFOCUS",
            new ItemStack(BBItems.purityFocus),
            new AspectList().add(Aspect.WATER, 5)
                .add(Aspect.ORDER, 8),
            "SQS",
            "QEQ",
            "SQS",
            'S',
            new ItemStack(ConfigItems.itemShard, 1, 4),
            'Q',
            new ItemStack(Items.quartz),
            'E',
            new ItemStack(ConfigBlocks.blockCustomPlant, 1, 4));
        purityFocusResearch.setPages(
            new ResearchPage("tc.research_page.PURITYFOCUS.BT.1"),
            new ResearchPage("tc.research_page.PURITYFOCUS.BT.2"),
            new ResearchPage(purityFocusRecipe),
            new ResearchPage("tc.research_page.PURITYFOCUS.basic_upgrades"),
            new ResearchPage("tc.research_page.PURITYFOCUS.architect"),
            new ResearchPage("tc.research_page.PURITYFOCUS.BT.vacuum"),
            new ResearchPage("tc.research_page.PURITYFOCUS.BT.curative"),
            new ResearchPage("tc.research_page.PURITYFOCUS.BT.blightBuster"));
        purityFocusResearch.registerResearchItem();

        // Dawn Totem Research
        ResearchItem dawnTotemResearch = new ResearchItem(
            "DAWNTOTEM",
            "ALCHEMY",
            new AspectList().add(Aspect.AURA, 6)
                .add(Aspect.HEAL, 8)
                .add(Aspect.TAINT, 3)
                .add(Aspect.MAGIC, 6),
            -2,
            -6,
            2,
            new ItemStack(BBBlock.dawnTotem));
        dawnTotemResearch.setParents("ETHEREALBLOOM", "INFUSION");
        dawnTotemResearch.setConcealed();
        InfusionRecipe dawnTotemRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "DAWNTOTEM",
            new ItemStack(BBBlock.dawnTotem),
            6,
            new AspectList().add(Aspect.HEAL, 32)
                .add(Aspect.LIFE, 48)
                .add(Aspect.LIGHT, 16)
                .add(Aspect.ARMOR, 32)
                .add(Aspect.ORDER, 48),
            new ItemStack(ConfigBlocks.blockMagicalLog, 1, 1),
            new ItemStack[] { new ItemStack(ConfigBlocks.blockCustomPlant, 1, 4),
                new ItemStack(ConfigBlocks.blockCustomPlant, 1, 4),
                new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 3),
                new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 3), new ItemStack(ConfigBlocks.blockCrystal, 1, 4) });
        dawnTotemResearch.setPages(new ResearchPage("tc.research_page.DAWNTOTEM.1"), new ResearchPage(dawnTotemRecipe));
        dawnTotemResearch.registerResearchItem();

        // Dawn Machine Research
        ResearchItem dawnMachineResearch = new ResearchItem(
            "DAWNMACHINE",
            "ALCHEMY",
            new AspectList().add(Aspect.MECHANISM, 32)
                .add(Aspect.AIR, 4)
                .add(Aspect.FIRE, 4)
                .add(Aspect.ORDER, 4)
                .add(Aspect.TREE, 4)
                .add(Aspect.AURA, 4)
                .add(Aspect.MIND, 4)
                .add(Aspect.CRAFT, 4)
                .add(Aspect.PLANT, 4)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.HEAL, 4)
                .add(Aspect.VOID, 4),
            -2,
            -8,
            4,
            new ItemStack(BBBlock.cyberTotem));
        dawnMachineResearch.setParents("DAWNTOTEM");
        List<ResearchPage> dawnMachinePages = new ArrayList<>();
        dawnMachinePages.add(new ResearchPage("tc.research_page.DAWNMACHINE.1"));

        Item itemMultiMaterial = GameRegistry.findItem("appliedenergistics2", "item.ItemMultiMaterial");
        ItemStack ichor = new ItemStack(GameRegistry.findItem("ThaumicTinkerer", "kamiResource"), 1, 0);
        ItemStack manaResource14 = new ItemStack(ModItems.manaResource, 1, 14);
        Block brMetalBlock = GameRegistry.findBlock("BigReactors", "BRMetalBlock");
        List<Tuple<ItemStack, ItemStack>> differingItems = Arrays.asList(
            new Tuple<>(ichor, ichor),
            new Tuple<>(manaResource14, manaResource14),
            new Tuple<>(
                new ItemStack(WayofTime.alchemicalWizardry.ModItems.baseItems, 1, 28),
                new ItemStack(WayofTime.alchemicalWizardry.ModItems.baseItems, 1, 29)),
            new Tuple<>(new ItemStack(brMetalBlock, 1, 4), new ItemStack(itemMultiMaterial, 1, 38)));

        for (Tuple<ItemStack, ItemStack> item : differingItems) {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                "DAWNMACHINE",
                new ItemStack(BBBlock.cyberTotem),
                10,
                new AspectList().add(Aspect.MECHANISM, 64)
                    .add(Aspect.AIR, 64)
                    .add(Aspect.FIRE, 64)
                    .add(Aspect.ORDER, 64)
                    .add(Aspect.TREE, 64)
                    .add(Aspect.AURA, 64)
                    .add(Aspect.MIND, 64)
                    .add(Aspect.PLANT, 64)
                    .add(Aspect.HEAL, 64)
                    .add(Aspect.VOID, 64),
                new ItemStack(BBBlock.dawnTotem),
                new ItemStack[] { new ItemStack(ConfigBlocks.blockJar), new ItemStack(TFItems.itemMaterial, 1, 139),
                    new ItemStack(TFItems.itemMaterial, 1, 138), new ItemStack(BBItems.purityFocus),
                    new ItemStack(BBItems.purityFocus), new ItemStack(ConfigBlocks.blockTube, 1, 3),
                    new ItemStack(ConfigBlocks.blockTube, 1, 3), new ItemStack(ModBlocks.pool),
                    new ItemStack(itemMultiMaterial, 1, 23), new ItemStack(itemMultiMaterial, 1, 23), item.getFirst(),
                    item.getSecond() });
            dawnMachinePages.add(new ResearchPage(recipe));
        }
        dawnMachinePages.add(new ResearchPage("tc.research_page.DAWNMACHINE.2"));
        dawnMachinePages.add(new ResearchPage("tc.research_page.DAWNMACHINE.3"));
        dawnMachinePages.add(new ResearchPage("tc.research_page.DAWNMACHINE.4"));
        dawnMachinePages.add(new ResearchPage("tc.research_page.DAWNMACHINE.5"));
        dawnMachinePages.add(new ResearchPage("tc.research_page.DAWNMACHINE.6"));
        dawnMachinePages.add(new ResearchPage("tc.research_page.DAWNMACHINE.7"));
        dawnMachinePages.add(new ResearchPage("tc.research_page.DAWNMACHINE.8"));
        dawnMachinePages.add(new ResearchPage("tc.research_page.DAWNMACHINE.9"));
        dawnMachineResearch.setPages(dawnMachinePages.toArray(new ResearchPage[0]));
        dawnMachineResearch.registerResearchItem();

        // Dawn Offering Research
        ResearchItem dawnOfferingResearch = new ResearchItem(
            "DAWNOFFERING",
            "ALCHEMY",
            new AspectList().add(Aspect.MECHANISM, 16)
                .add(Aspect.MOTION, 4)
                .add(Aspect.ELDRITCH, 4),
            -4,
            -8,
            4,
            new ItemStack(BBBlock.offering));
        dawnOfferingResearch.setParents("DAWNMACHINE");
        dawnOfferingResearch.setConcealed();
        Item diamondNugget = GameRegistry.findItem("Translocator", "diamondNugget");
        InfusionRecipe dawnOfferingRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "DAWNOFFERING",
            new ItemStack(BBBlock.offering),
            4,
            new AspectList().add(Aspect.MOTION, 8)
                .add(Aspect.ELDRITCH, 4),
            new ItemStack(Blocks.obsidian),
            new ItemStack[] { new ItemStack(diamondNugget) });
        dawnOfferingResearch
            .setPages(new ResearchPage("tc.research_page.DAWNOFFERING.1"), new ResearchPage(dawnOfferingRecipe));
        dawnOfferingResearch.registerResearchItem();

        // Dawn Charger Research
        ResearchItem dawnChargerResearch = new ResearchItem(
            "DAWNCHARGER",
            "ALCHEMY",
            new AspectList().add(Aspect.WATER, 3)
                .add(Aspect.HEAL, 6)
                .add(Aspect.TAINT, 3)
                .add(Aspect.PLANT, 3),
            -4,
            -6,
            7,
            new ItemStack(BBBlock.dawnCharger));
        dawnChargerResearch.setParents("DAWNOFFERING");
        dawnChargerResearch.setConcealed();
        IArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
            "DAWNCHARGER",
            new ItemStack(BBBlock.dawnCharger),
            new AspectList().add(Aspect.WATER, 25)
                .add(Aspect.ORDER, 25)
                .add(Aspect.EARTH, 25)
                .add(Aspect.ENTROPY, 25)
                .add(Aspect.FIRE, 25),
            "LLL",
            "LEL",
            "LLL",
            'L',
            new ItemStack(ConfigBlocks.blockMagicalLog, 1, 1),
            'E',
            new ItemStack(TEBlocks.blockFrame, 1, 7));
        dawnChargerResearch.setPages(new ResearchPage("tc.research_page.DAWNCHARGER.1"), new ResearchPage(recipe));
        dawnChargerResearch.registerResearchItem();
    }
}
