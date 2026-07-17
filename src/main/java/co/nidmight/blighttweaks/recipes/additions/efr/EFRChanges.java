package co.nidmight.blighttweaks.recipes.additions.efr;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import co.nidmight.blighttweaks.recipes.helpers.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import co.nidmight.blighttweaks.recipes.helpers.ThaumcraftEditorUtil;
import cofh.thermalexpansion.util.crafting.PulverizerManager;
import cpw.mods.fml.common.registry.GameRegistry;
import ganymedes01.etfuturum.ModBlocks;
import ganymedes01.etfuturum.ModItems;
import tconstruct.library.crafting.Smeltery;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;

public class EFRChanges implements IGameEditor {

    @Override
    public void apply() {
        // spotless:off
        // EU2 --> EFR --> EU2 smooth quartz variants
        ItemStack efrSmoothQuartz = ModBlocks.SMOOTH_QUARTZ.newItemStack();
        ItemStack eu2SmoothQuartz = new ItemStack(GameRegistry.findItem("ExtraUtilities", "decorativeBlock1"), 1, 2);
        GameRegistry.addShapelessRecipe(efrSmoothQuartz, eu2SmoothQuartz);
        GameRegistry.addShapelessRecipe(eu2SmoothQuartz, efrSmoothQuartz);

        // Aspect all the things
        ThaumcraftApi.registerEntityTag(
            "etfuturum.new_boat",
            new AspectList().add(Aspect.WATER, 4)
                .add(Aspect.TRAVEL, 4)
                .add(Aspect.VOID, 4)
                .add(Aspect.TREE, 6));
        ThaumcraftApi.registerEntityTag(
            "etfuturum.chest_boat",
            new AspectList().add(Aspect.WATER, 4)
                .add(Aspect.TRAVEL, 4)
                .add(Aspect.VOID, 4)
                .add(Aspect.TREE, 6));
        ThaumcraftApi.registerEntityTag(
            "etfuturum.wooden_armorstand",
            new AspectList().add(Aspect.TREE, 4)
                .add(Aspect.ARMOR, 1));
        ThaumcraftEditorUtil.setItemAspects(
            ModItems.BAMBOO_RAFT.newItemStack(),
            new AspectList().add(Aspect.WATER, 4)
                .add(Aspect.TRAVEL, 4)
                .add(Aspect.TREE, 3));
        ThaumcraftEditorUtil.setItemAspects(
            ModItems.BAMBOO_CHEST_RAFT.newItemStack(),
            new AspectList().add(Aspect.WATER, 4)
                .add(Aspect.TRAVEL, 4)
                .add(Aspect.VOID, 4)
                .add(Aspect.TREE, 6));
        ThaumcraftEditorUtil.addItemAspects(
            ModItems.SPRUCE_CHEST_BOAT.newItemStack(),
            new AspectList().add(Aspect.VOID, 4)
                .add(Aspect.TREE, 3));
        ThaumcraftEditorUtil.addItemAspects(
            ModItems.ACACIA_CHEST_BOAT.newItemStack(),
            new AspectList().add(Aspect.VOID, 4)
                .add(Aspect.TREE, 3));
        ThaumcraftEditorUtil.addItemAspects(
            ModItems.BIRCH_CHEST_BOAT.newItemStack(),
            new AspectList().add(Aspect.VOID, 4)
                .add(Aspect.TREE, 3));
        ThaumcraftEditorUtil.addItemAspects(
            ModItems.DARK_OAK_CHEST_BOAT.newItemStack(),
            new AspectList().add(Aspect.VOID, 4)
                .add(Aspect.TREE, 3));
        ThaumcraftEditorUtil.addItemAspects(
            ModItems.JUNGLE_CHEST_BOAT.newItemStack(),
            new AspectList().add(Aspect.VOID, 4)
                .add(Aspect.TREE, 3));
        ThaumcraftEditorUtil.addItemAspects(
            ModItems.OAK_CHEST_BOAT.newItemStack(),
            new AspectList().add(Aspect.VOID, 4)
                .add(Aspect.TREE, 3));
        ThaumcraftEditorUtil
            .addItemAspects(ModBlocks.OBSERVER.newItemStack(), new AspectList().add(Aspect.getAspect("invidia"), 2)); // Match
                                                                                                                      // comparator
        ThaumcraftEditorUtil.addItemAspects(ModBlocks.LANTERN.newItemStack(), new AspectList().add(Aspect.LIGHT, 2));
        ThaumcraftEditorUtil
            .addItemAspects(ModBlocks.COMPOSTER.newItemStack(), new AspectList().add(Aspect.EXCHANGE, 2));
        ThaumcraftEditorUtil.addItemAspects(ModBlocks.BARREL.newItemStack(), new AspectList().add(Aspect.VOID, 4)); // Match
                                                                                                                    // chest
        ThaumcraftEditorUtil.addItemAspects(
            ModBlocks.IRON_TRAPDOOR.newItemStack(),
            new AspectList().add(Aspect.MECHANISM, 2)
                .add(Aspect.MOTION, 1)); // Match iron door
        ThaumcraftEditorUtil.setItemAspects(
            ModBlocks.END_BRICKS.newItemStack(1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.EARTH, 1)
                .add(Aspect.DARKNESS, 1));
        ThaumcraftEditorUtil.setItemAspects(
            ModBlocks.COARSE_DIRT.newItemStack(1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.EARTH, 2));
        ThaumcraftEditorUtil.setItemAspects(
            ModBlocks.BLACKSTONE.newItemStack(1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.EARTH, 1)
                .add(Aspect.DARKNESS, 1));
        ThaumcraftEditorUtil.setItemAspects(
            ModBlocks.GILDED_BLACKSTONE.newItemStack(),
            new AspectList().add(Aspect.GREED, 1)
                .add(Aspect.DARKNESS, 1));
        ThaumcraftEditorUtil.setItemAspects(
            ModBlocks.POLISHED_BLACKSTONE_PRESSURE_PLATE.newItemStack(),
            new AspectList().add(Aspect.DARKNESS, 1)
                .add(Aspect.MECHANISM, 1)
                .add(Aspect.SENSES, 1));
        ThaumcraftEditorUtil.setItemAspects(
            ModItems.HONEYCOMB.newItemStack(),
            new AspectList().add(Aspect.ORDER, 2)
                .add(Aspect.HUNGER, 1)); // Match Natura
        ThaumcraftEditorUtil.setItemAspects(
            ModItems.HONEY_BOTTLE.newItemStack(),
            new AspectList().add(Aspect.HUNGER, 2)
                .add(Aspect.TRAP, 1)
                .add(Aspect.HEAL, 1));
        ThaumcraftEditorUtil.setItemAspects(
            ModBlocks.HONEY_BLOCK.newItemStack(),
            new AspectList().add(Aspect.HUNGER, 7)
                .add(Aspect.TRAP, 3)
                .add(Aspect.HEAL, 3));
        ThaumcraftEditorUtil.setItemAspects(
            ModItems.END_CRYSTAL.newItemStack(),
            new AspectList().add(Aspect.ELDRITCH, 3)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.HEAL, 3)); // Match entity
        ThaumcraftEditorUtil.setItemAspects(
            ModItems.DYE.newItemStack(1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.SENSES, 1));
        ThaumcraftEditorUtil
            .addItemAspects(ModItems.WOODEN_ARMORSTAND.newItemStack(), new AspectList().add(Aspect.ARMOR, 1));
        ThaumcraftEditorUtil.addItemAspects(
            ModBlocks.BANNER.newItemStack(1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.SENSES, 2));
        ThaumcraftApi.registerObjectTag(
            "bedWood",
            new AspectList().add(Aspect.CLOTH, 6)
                .add(Aspect.getAspect("desidia"), 4)
                .add(Aspect.CRAFT, 3));

        // Turn chains into iron
        Item thermalFoundationMaterial = GameRegistry.findItem("ThermalFoundation", "material");
        PulverizerManager.addRecipe(
            3000,
            ModBlocks.CHAIN.newItemStack(),
            new ItemStack(thermalFoundationMaterial),
            new ItemStack(ConfigItems.itemNugget, 2),
            100);
        Smeltery.addMelting(
            ModBlocks.CHAIN.newItemStack(),
            Blocks.iron_block,
            0,
            600,
            new FluidStack(FluidRegistry.getFluid("iron.molten"), 160));

        // Blackstone Thaum Research
        ResearchItem blackstoneResearch = new ResearchItem(
            "BLACKSTONE",
            "ARTIFICE",
            new AspectList().add(Aspect.EARTH, 4)
                .add(Aspect.DARKNESS, 3)
                .add(Aspect.GREED, 1),
            5,
            -4,
            0,
            ModBlocks.BLACKSTONE.newItemStack());
        blackstoneResearch.setSecondary();
        blackstoneResearch.setParents("ARCANESTONE");

        IArcaneRecipe blackstoneRecipe = ThaumcraftApi.addArcaneCraftingRecipe(
            "BLACKSTONE",
            ModBlocks.BLACKSTONE.newItemStack(),
            new AspectList().add(Aspect.ENTROPY, 5),
            " S ",
            "SIS",
            " S ",
            'S',
            new ItemStack(GameRegistry.findBlock("MineFactoryReloaded", "stone"), 4, 2),
            'I',
            new ItemStack(ConfigItems.itemShard, 1, 4));
        CrucibleRecipe gildstoneRecipe = ThaumcraftApi.addCrucibleRecipe(
            "BLACKSTONE",
            ModBlocks.GILDED_BLACKSTONE.newItemStack(),
            ModBlocks.BLACKSTONE.newItemStack(),
            new AspectList().add(Aspect.GREED, 1));

        blackstoneResearch.setPages(
            new ResearchPage("BLACKSTONE", "tc.research_page.BLACKSTONE.1"),
            new ResearchPage(blackstoneRecipe),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.BLACKSTONE.newItemStack(1, 1), false)),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.BLACKSTONE.newItemStack(1, 2), false)),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.BLACKSTONE.newItemStack(1, 4), false)),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.BLACKSTONE_WALL.newItemStack(1, 0), false)),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.BLACKSTONE_WALL.newItemStack(1, 1), false)),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.BLACKSTONE_WALL.newItemStack(1, 2), false)),
            new ResearchPage("BLACKSTONE", "tc.research_page.BLACKSTONE.2"),
            new ResearchPage(gildstoneRecipe));
        blackstoneResearch.registerResearchItem();

        // Elytra Research
        ResearchItem elytraResearch = new ResearchItem(
            "ELYTRA",
            "ARTIFICE",
            new AspectList().add(Aspect.FLIGHT, 4)
                .add(Aspect.MOTION, 4)
                .add(Aspect.ELDRITCH, 3)
                .add(Aspect.ARMOR, 0)
                .add(Aspect.MAGIC, 0),
            3,
            6,
            5,
            ModItems.ELYTRA.newItemStack());
        elytraResearch.setConcealed();
        elytraResearch.setParents("HOVERGIRDLE");

        InfusionRecipe elytraRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "ELYTRA",
            ModItems.ELYTRA.newItemStack(),
            7,
            new AspectList().add(Aspect.FLIGHT, 64)
                .add(Aspect.MOTION, 32)
                .add(Aspect.AIR, 32)
                .add(Aspect.ELDRITCH, 16),
            new ItemStack(ConfigItems.itemGirdleHover),
            new ItemStack[] { new ItemStack(Items.feather), new ItemStack(Items.leather),
                new ItemStack(Items.ender_eye), new ItemStack(Items.leather),
                new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(Items.feather), new ItemStack(Items.leather),
                new ItemStack(Items.ender_eye), new ItemStack(Items.leather),
                new ItemStack(ConfigItems.itemShard, 1, 0) });

        elytraResearch.setPages(
            new ResearchPage("tc.research_page.ELYTRA.1"),
            new ResearchPage(elytraRecipe),
            new ResearchPage("tc.research_page.ELYTRA.2"),
            new ResearchPage("tc.research_page.ELYTRA.3"),
            new ResearchPage("tc.research_page.ELYTRA.4"));
        elytraResearch.registerResearchItem();

        ResearchItem chorusFlowerResearch = new ResearchItem(
            "CHORUSFLOWER",
            "ARTIFICE",
            new AspectList().add(Aspect.SENSES, 3)
                .add(Aspect.PLANT, 3)
                .add(Aspect.ELDRITCH, 3)
                .add(Aspect.LIFE, 3)
                .add(Aspect.TRAVEL, 0),
            4,
            6,
            5,
            ModBlocks.CHORUS_FLOWER.newItemStack());
        chorusFlowerResearch.setConcealed();
        chorusFlowerResearch.setParents("ELYTRA");

        InfusionRecipe chorusFlowerRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "CHORUSFLOWER",
            ModBlocks.CHORUS_FLOWER.newItemStack(),
            2,
            new AspectList().add(Aspect.SENSES, 8)
                .add(Aspect.PLANT, 8)
                .add(Aspect.ELDRITCH, 8)
                .add(Aspect.LIFE, 8)
                .add(Aspect.TRAVEL, 8),
            new ItemStack(Items.reeds),
            new ItemStack[] { new ItemStack(Items.ender_pearl), new ItemStack(Blocks.end_stone) });

        chorusFlowerResearch.setPages(
            new ResearchPage("tc.research_page.CHORUSFLOWER.1"),
            new ResearchPage(chorusFlowerRecipe),
            new ResearchPage("tc.research_page.CHORUSFLOWER.2"),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.PURPUR_BLOCK.newItemStack(), false)),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.PURPUR_SLAB.newItemStack(), false)),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.PURPUR_PILLAR.newItemStack(), false)),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.PURPUR_STAIRS.newItemStack(), false)),
            new ResearchPage(RecipeEditorUtil.getRecipeByOutput(ModBlocks.END_ROD.newItemStack(), false)));
        chorusFlowerResearch.registerResearchItem();

        // Oredict all the things
        // todo: replace with actual item
        Item locker = GameRegistry.findItem("betterstorage", "locker");
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(locker));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(new ItemStack(locker), "WWW", "W T", "WWW", 'W', "plankWood", 'T', "trapdoorWood"));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(new ItemStack(locker), "WWW", "T W", "WWW", 'W', "plankWood", 'T', "trapdoorWood"));

        ItemStack thaumBlockMetalDevice5 = new ItemStack(ConfigBlocks.blockMetalDevice, 1, 5);
        RecipeEditorUtil.removeRecipeByOutput(thaumBlockMetalDevice5);
        GameRegistry.addRecipe(new ShapedOreRecipe(thaumBlockMetalDevice5, "AB", 'A', "barsIon", 'B', "trapdoorWood"));

        ThaumcraftEditorUtil.removeArcaneRecipeByOutput(ConfigBlocks.blockChestHungry);
        ThaumcraftApi.addArcaneCraftingRecipe(
            "HUNGRYCHEST",
            new ItemStack(ConfigBlocks.blockChestHungry),
            new AspectList().add(Aspect.AIR, 5)
                .add(Aspect.ORDER, 3)
                .add(Aspect.ENTROPY, 3),
            "WTW",
            "W W",
            "WWW",
            'W',
            "plankWood",
            'T',
            "trapdoorWood");

        Block eagerChest = tuhljin.automagy.blocks.ModBlocks.eagerChest;
        Item edible = tuhljin.automagy.items.ModItems.edible;
        ThaumcraftEditorUtil.removeArcaneRecipeByOutput(eagerChest);
        ThaumcraftApi.addArcaneCraftingRecipe(
            "EAGERCHEST",
            new ItemStack(eagerChest),
            new AspectList().add(Aspect.ORDER, 5)
                .add(Aspect.ENTROPY, 5),
            "PTP",
            "BEB",
            "BBB",
            'P',
            "plankWood",
            'T',
            "trapdoorWood",
            'E',
            new ItemStack(edible),
            'B',
            new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 6));

        Block greedyChest = tuhljin.automagy.blocks.ModBlocks.greedyChest;
        Item avaricePearl = tuhljin.automagy.items.ModItems.avaricePearl;
        ThaumcraftEditorUtil.removeArcaneRecipeByOutput(greedyChest);
        ThaumcraftApi.addArcaneCraftingRecipe(
            "GREEDYCHEST",
            new ItemStack(greedyChest),
            new AspectList().add(Aspect.AIR, 7)
                .add(Aspect.ORDER, 2)
                .add(Aspect.ENTROPY, 2),
            "BTB",
            "BAB",
            "BBB",
            'B',
            new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 6),
            'T',
            "trapdoorWood",
            'A',
            new ItemStack(avaricePearl));

        Block tenaciousChest = tuhljin.automagy.blocks.ModBlocks.tenaciousChest;
        ThaumcraftEditorUtil.removeArcaneRecipeByOutput(tenaciousChest);
        ThaumcraftApi.addArcaneCraftingRecipe(
            "TENACIOUSCHEST",
            new ItemStack(tenaciousChest),
            new AspectList().add(Aspect.AIR, 5)
                .add(Aspect.EARTH, 2)
                .add(Aspect.WATER, 2),
            "PTP",
            "PSP",
            "PPP",
            'P',
            "plankWood",
            'T',
            "trapdoorWood",
            'S',
            "slimeball");

        // Beetroot seed recipes
        CrucibleRecipe beetrootSeedRecipe = ThaumcraftApi.addCrucibleRecipe(
            "PLANTCONJURATION",
            ModItems.BEETROOT_SEEDS.newItemStack(),
            new ItemStack(Items.wheat_seeds),
            new AspectList().add(Aspect.SENSES, 5)
                .add(Aspect.CROP, 2));
        ResearchPage beetrootSeedRecipePage = new ResearchPage(beetrootSeedRecipe);
        ThaumcraftEditorUtil.addResearchPage("PLANTCONJURATION", beetrootSeedRecipePage);
    }

    @Override
    public Priority getPriority() {
        return Priority.LOWEST;
    }
}
