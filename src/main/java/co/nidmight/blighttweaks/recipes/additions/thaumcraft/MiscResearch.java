package co.nidmight.blighttweaks.recipes.additions.thaumcraft;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.rwtema.extrautils.ExtraUtils;

import co.nidmight.blighttweaks.recipes.helpers.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.LocalizationUtil;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import co.nidmight.blighttweaks.recipes.helpers.ThaumcraftEditorUtil;
import codechicken.chunkloader.ChickenChunks;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.forbidden.items.ForbiddenItems;
import ganymedes01.etfuturum.ModBlocks;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import vazkii.botania.common.item.ModItems;

public class MiscResearch implements IGameEditor {

    @Override
    public void apply() {
        // spotless:off
        // ChickenChunks
        Block chunkloader = ChickenChunks.blockChunkLoader;
        ItemStack chunkLoaderStack = new ItemStack(chunkloader);
        ResearchItem chickenChunksResearch = new ResearchItem(
            "CHICKENCHUNKS",
            "ARTIFICE",
            new AspectList().add(Aspect.ORDER, 5)
                .add(Aspect.ENTROPY, 5)
                .add(Aspect.VOID, 5)
                .add(Aspect.getAspect("desidia"), 5),
            -4,
            9,
            4,
            chunkLoaderStack);
        chickenChunksResearch.setConcealed();
        chickenChunksResearch.setParents("INFUSION");

        ShapedArcaneRecipe chickenChunksArcaneRecipe = ThaumcraftApi.addArcaneCraftingRecipe(
            "CHICKENCHUNKS",
            new ItemStack(chunkloader, 2, 1),
            new AspectList().add(Aspect.ORDER, 16),
            " G ",
            "GPG",
            " O ",
            'G',
            Items.gold_nugget,
            'P',
            Items.ender_pearl,
            'O',
            Blocks.obsidian);
        ItemStack spotloader = new ItemStack(chunkloader, 1, 1);
        InfusionRecipe chickenChunksInfusionRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "CHICKENCHUNKS",
            new ItemStack(chunkloader),
            6,
            new AspectList().add(Aspect.ELDRITCH, 4)
                .add(Aspect.VOID, 4)
                .add(Aspect.getAspect("desidia"), 16),
            new ItemStack(Blocks.obsidian),
            new ItemStack[] { spotloader, spotloader, spotloader, spotloader, spotloader, spotloader, spotloader,
                spotloader });
        chickenChunksResearch.setPages(
            new ResearchPage("CHICKENCHUNKS", "tc.research_page.CHICKENCHUNKS.1"),
            new ResearchPage("CHICKENCHUNKS", "tc.research_page.CHICKENCHUNKS.2"),
            new ResearchPage(chickenChunksArcaneRecipe),
            new ResearchPage(chickenChunksInfusionRecipe));
        chickenChunksResearch.registerResearchItem();

        LocalizationUtil.setLocalization(
            chunkLoaderStack.getUnlocalizedName() + ".name",
            StatCollector.translateToLocal("blighttweaks.chunkloader"));
        LocalizationUtil.setLocalization(
            spotloader.getUnlocalizedName() + ".name",
            StatCollector.translateToLocal("blighttweaks.spotloader"));

        // Override Crimson Research
        ResearchItem crimsonResearch = ResearchCategories.getResearch("CRIMSON");
        crimsonResearch.setPages(new ResearchPage("tc.research_page.CRIMSON.1"));

        // Cultist Items Recipes
        ResearchItem cultistResearch = new ResearchItem(
            "CULTITEMS",
            "BASICS",
            new AspectList().add(Aspect.CRAFT, 4)
                .add(Aspect.METAL, 4)
                .add(Aspect.CLOTH, 4)
                .add(Aspect.ELDRITCH, 4),
            0,
            5,
            0,
            new ItemStack(ConfigItems.itemHelmetCultistRobe));
        cultistResearch.setSecondary();
        cultistResearch.setConcealed();
        cultistResearch.setParents("CRIMSON");
        cultistResearch.setParentsHidden("ELDRITCHMINOR");

        IArcaneRecipe cultistPlateHelmet = ThaumcraftApi.addArcaneCraftingRecipe(
            "CULTITEMS",
            new ItemStack(ConfigItems.itemHelmetCultistPlate),
            new AspectList().add(Aspect.FIRE, 5),
            " G ",
            "RHR",
            " G ",
            'G',
            new ItemStack(Items.gold_ingot),
            'R',
            new ItemStack(ConfigItems.itemResource, 1, 17),
            'H',
            new ItemStack(ConfigItems.itemHelmetThaumium));
        IArcaneRecipe cultistPlateChest = ThaumcraftApi.addArcaneCraftingRecipe(
            "CULTITEMS",
            new ItemStack(ConfigItems.itemChestCultistPlate),
            new AspectList().add(Aspect.AIR, 5),
            "ACA",
            "DBD",
            'A',
            new ItemStack(ConfigItems.itemResource, 1, 17),
            'B',
            new ItemStack(ConfigItems.itemResource, 7),
            'C',
            new ItemStack(ConfigItems.itemChestThaumium),
            'D',
            "dyeRed");
        IArcaneRecipe cultistPlateLegs = ThaumcraftApi.addArcaneCraftingRecipe(
            "CULTITEMS",
            new ItemStack(ConfigItems.itemLegsCultistPlate),
            new AspectList().add(Aspect.WATER, 5),
            " G ",
            "ALA",
            "DBD",
            'G',
            new ItemStack(Items.gold_ingot),
            'A',
            new ItemStack(ConfigItems.itemResource, 1, 17),
            'B',
            new ItemStack(ConfigItems.itemResource, 7),
            'L',
            new ItemStack(ConfigItems.itemLegsThaumium),
            'D',
            "dyeRed");
        IArcaneRecipe cultistRobeHelmet = ThaumcraftApi.addArcaneCraftingRecipe(
            "CULTITEMS",
            new ItemStack(ConfigItems.itemHelmetCultistRobe),
            new AspectList().add(Aspect.FIRE, 5),
            "AAA",
            "ADA",
            "B B",
            'A',
            new ItemStack(ConfigItems.itemResource, 1, 7),
            'B',
            new ItemStack(ConfigItems.itemResource, 17),
            'D',
            "dyeRed");
        IArcaneRecipe cultistRobeChest = ThaumcraftApi.addArcaneCraftingRecipe(
            "CULTITEMS",
            new ItemStack(ConfigItems.itemChestCultistRobe),
            new AspectList().add(Aspect.AIR, 5),
            "ACA",
            "BDB",
            'A',
            new ItemStack(ConfigItems.itemResource, 1, 17),
            'B',
            new ItemStack(ConfigItems.itemResource, 1, 7),
            'C',
            new ItemStack(ConfigItems.itemChestRobe),
            'D',
            "dyeRed");
        IArcaneRecipe cultistRobeLegs = ThaumcraftApi.addArcaneCraftingRecipe(
            "CULTITEMS",
            new ItemStack(ConfigItems.itemLegsCultistRobe),
            new AspectList().add(Aspect.WATER, 5),
            " G ",
            "ARA",
            "BDB",
            'G',
            new ItemStack(Items.gold_nugget),
            'A',
            new ItemStack(ConfigItems.itemResource, 1, 17),
            'B',
            new ItemStack(ConfigItems.itemResource, 1, 7),
            'R',
            new ItemStack(ConfigItems.itemLegsRobe),
            'D',
            "dyeRed");
        IArcaneRecipe cultistBoots = ThaumcraftApi.addArcaneCraftingRecipe(
            "CULTITEMS",
            new ItemStack(ConfigItems.itemBootsCultist),
            new AspectList().add(Aspect.EARTH, 5),
            "D D",
            "ABA",
            'A',
            new ItemStack(ConfigItems.itemResource, 1, 17),
            'B',
            new ItemStack(ConfigItems.itemBootsRobe),
            'D',
            "dyeRed");

        ItemStack thaumRedBanner = new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 8);
        NBTTagCompound bannerTag = new NBTTagCompound();
        bannerTag.setByte("color", (byte) 14);
        thaumRedBanner.setTagCompound(bannerTag);
        IArcaneRecipe cultBannerRecipe1 = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
            "CULTITEMS",
            new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 8),
            new AspectList().add(Aspect.ORDER, 5),
            new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 8),
            "nuggetGold");
        IArcaneRecipe cultBannerRecipe2 = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
            "CULTITEMS",
            new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 8),
            new AspectList().add(Aspect.ORDER, 5),
            ModBlocks.BANNER.newItemStack(1, 14),
            "nuggetGold");

        cultistResearch.setPages(
            new ResearchPage("tc.research_page.CULTITEMS.1"),
            new ResearchPage(cultistPlateHelmet),
            new ResearchPage(cultistPlateChest),
            new ResearchPage(cultistPlateLegs),
            new ResearchPage(cultistRobeHelmet),
            new ResearchPage(cultistRobeChest),
            new ResearchPage(cultistRobeLegs),
            new ResearchPage(cultistBoots),
            new ResearchPage(cultBannerRecipe1),
            new ResearchPage(cultBannerRecipe2),
            new ResearchPage("tc.research_page.CULTITEMS.2"));
        cultistResearch.registerResearchItem();

        // Angel Ring Research
        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(ExtraUtils.angelRing, 1, OreDictionary.WILDCARD_VALUE));
        ItemStack angelRingBase = new ItemStack(GameRegistry.findItem("TabulaRasa", "RasaItem0"), 1, 21);
        IRecipe baseRingRecipe = new ShapedOreRecipe(
            angelRingBase,
            " G ",
            "GNG",
            "UGU",
            'G',
            "ingotGold",
            'N',
            new ItemStack(Items.nether_star),
            'U',
            "ingotUnstable");
        GameRegistry.addRecipe(baseRingRecipe);

        ResearchItem angelRingResearch = new ResearchItem(
            "ANGELRING",
            "ARTIFICE",
            new AspectList().add(Aspect.FLIGHT, 8)
                .add(Aspect.AIR, 8)
                .add(Aspect.ORDER, 8)
                .add(Aspect.CRAFT, 8),
            -8,
            8,
            4,
            angelRingBase);
        angelRingResearch.setParents("INFUSION");
        angelRingResearch.setConcealed();
        Item toughRod = GameRegistry.findItem("ExtraTiC", "toughrod");
        InfusionRecipe angelRing0 = ThaumcraftApi.addInfusionCraftingRecipe(
            "ANGELRING",
            new ItemStack(ExtraUtils.angelRing),
            6,
            new AspectList().add(Aspect.AIR, 32)
                .add(Aspect.FLIGHT, 64)
                .add(Aspect.CRYSTAL, 24),
            angelRingBase,
            new ItemStack[] {
                // why does every mod name thir classes ModItems/ModBlocks :sob:
                new ItemStack(WayofTime.alchemicalWizardry.ModItems.baseItems),
                new ItemStack(vazkii.botania.common.block.ModBlocks.elfGlass),
                new ItemStack(vazkii.botania.common.block.ModBlocks.elfGlass),
                new ItemStack(WayofTime.alchemicalWizardry.ModItems.baseItems),
                new ItemStack(vazkii.botania.common.block.ModBlocks.elfGlass),
                new ItemStack(vazkii.botania.common.block.ModBlocks.elfGlass), });
        InfusionRecipe angelRing1 = ThaumcraftApi.addInfusionCraftingRecipe(
            "ANGELRING",
            new ItemStack(ExtraUtils.angelRing, 1, 1),
            6,
            new AspectList().add(Aspect.AIR, 32)
                .add(Aspect.FLIGHT, 64)
                .add(Aspect.ORDER, 24),
            angelRingBase,
            new ItemStack[] { new ItemStack(toughRod, 1, 123), new ItemStack(Items.feather),
                new ItemStack(Items.feather), new ItemStack(toughRod, 1, 123), new ItemStack(Items.feather),
                new ItemStack(Items.feather), });
        InfusionRecipe angelRing2 = ThaumcraftApi.addInfusionCraftingRecipe(
            "ANGELRING",
            new ItemStack(ExtraUtils.angelRing, 1, 2),
            6,
            new AspectList().add(Aspect.AIR, 32)
                .add(Aspect.FLIGHT, 64)
                .add(Aspect.LIGHT, 24),
            angelRingBase,
            new ItemStack[] { new ItemStack(toughRod, 1, 142), new ItemStack(ModItems.manaResource, 1, 8),
                new ItemStack(toughRod, 1, 142), new ItemStack(ModItems.manaResource, 1, 8), });
        InfusionRecipe angelRing3 = ThaumcraftApi.addInfusionCraftingRecipe(
            "ANGELRING",
            new ItemStack(ExtraUtils.angelRing, 1, 3),
            6,
            new AspectList().add(Aspect.AIR, 32)
                .add(Aspect.FLIGHT, 64)
                .add(Aspect.getAspect("superbia"), 24),
            angelRingBase,
            new ItemStack[] { new ItemStack(toughRod, 1, 113), new ItemStack(Items.leather),
                new ItemStack(Items.leather), new ItemStack(toughRod, 1, 113), new ItemStack(Items.leather),
                new ItemStack(Items.leather), });

        InfusionRecipe angelRing4 = ThaumcraftApi.addInfusionCraftingRecipe(
            "ANGELRING",
            new ItemStack(ExtraUtils.angelRing, 1, 4),
            6,
            new AspectList().add(Aspect.AIR, 32)
                .add(Aspect.FLIGHT, 64)
                .add(Aspect.getAspect("superbia"), 24),
            angelRingBase,
            new ItemStack[] { new ItemStack(toughRod, 1, 120), new ItemStack(Items.gold_ingot),
                new ItemStack(toughRod, 1, 120), new ItemStack(Items.gold_ingot), });

        angelRingResearch.setPages(
            new ResearchPage("tc.research_page.ANGELRING.1"),
            new ResearchPage(baseRingRecipe),
            new ResearchPage(angelRing0),
            new ResearchPage(angelRing1),
            new ResearchPage(angelRing2),
            new ResearchPage(angelRing3),
            new ResearchPage(angelRing4));
        angelRingResearch.registerResearchItem();

        // Taint Egg
        ItemStack taintSpawnEgg = new ItemStack(ConfigItems.itemSpawnerEgg, 1, 28);
        ResearchItem taintEggResearch = new ResearchItem(
            "TAINTEGG",
            "ELDRITCH",
            new AspectList().add(Aspect.TAINT, 128)
                .add(Aspect.MAGIC, 128),
            0,
            2,
            8,
            taintSpawnEgg);
        taintEggResearch.setParents("TAINTSHOVEL", "BOTTLETAINT", "PRIMPEARL");
        taintEggResearch.setSpecial();
        taintEggResearch.setConcealed();

        ThaumcraftApi.addWarpToResearch("TAINTEGG", 25);
        ThaumcraftApi.addWarpToItem(taintSpawnEgg, 5);

        InfusionRecipe taintEggRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "TAINTEGG",
            taintSpawnEgg,
            25,
            new AspectList().add(Aspect.TAINT, 128)
                .add(Aspect.LIFE, 64)
                .add(Aspect.BEAST, 64)
                .add(Aspect.MAGIC, 64)
                .add(Aspect.FIRE, 64)
                .add(Aspect.ORDER, 64)
                .add(Aspect.AIR, 64)
                .add(Aspect.ENTROPY, 64)
                .add(Aspect.WATER, 64)
                .add(Aspect.EARTH, 64),
            new ItemStack(Items.egg),
            new ItemStack[] { new ItemStack(ConfigItems.itemEldritchObject, 1, 3),
                new ItemStack(ConfigItems.itemEldritchObject, 1, 3), new ItemStack(ConfigItems.itemBottleTaint),
                new ItemStack(ConfigItems.itemBottleTaint), new ItemStack(ConfigItems.itemBottleTaint),
                new ItemStack(ConfigItems.itemBottleTaint), new ItemStack(ForbiddenItems.deadlyShards, 1, 2),
                new ItemStack(ForbiddenItems.deadlyShards, 1, 2), new ItemStack(ForbiddenItems.deadlyShards, 1, 2),
                new ItemStack(ForbiddenItems.deadlyShards, 1, 2), new ItemStack(ConfigItems.itemResource, 1, 17),
                new ItemStack(ConfigItems.itemResource, 1, 17), new ItemStack(ConfigItems.itemResource, 1, 12),
                new ItemStack(ConfigItems.itemResource, 1, 12), new ItemStack(ConfigItems.itemResource, 1, 12),
                new ItemStack(ConfigItems.itemResource, 1, 12), });

        taintEggResearch.setPages(
            new ResearchPage("tc.research_page.TAINTEGG.1"),
            new ResearchPage("tc.research_page.TAINTEGG.2"),
            new ResearchPage(taintEggRecipe));
        taintEggResearch.registerResearchItem();

        // Nethermind
        InfusionRecipe nethermindRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "NETHERMIND",
            new ItemStack(tuhljin.automagy.items.ModItems.netherHeart),
            6,
            new AspectList().add(Aspect.getAspect("infernus"), 16)
                .add(Aspect.getAspect("ira"), 16)
                .add(Aspect.EXCHANGE, 16)
                .add(Aspect.MAGIC, 32),
            new ItemStack(Items.ghast_tear),
            new ItemStack[] { new ItemStack(Items.blaze_rod), new ItemStack(Items.blaze_rod),
                new ItemStack(Items.blaze_rod), new ItemStack(Items.blaze_rod), new ItemStack(Blocks.netherrack),
                new ItemStack(Blocks.netherrack), new ItemStack(Blocks.obsidian), new ItemStack(Blocks.obsidian),
                new ItemStack(Items.leather) });
        ThaumcraftEditorUtil.addResearchPage("NETHERMIND", new ResearchPage(nethermindRecipe));
    }

    @Override
    public Priority getPriority() {
        return Priority.LOWEST;
    }
}
