package co.nidmight.blighttweaks.common.compat;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigBlocks;

public class ThaumcraftRecipes {

    public static void init() {
        // Add research
        AspectList aspectList = new AspectList().add(Aspect.PLANT, 10)
            .add(Aspect.LIFE, 10)
            .add(Aspect.MAGIC, 10);

        ResearchItem plantConjurationResearch = new ResearchItem(
            "PLANTCONJURATION",
            "ALCHEMY",
            aspectList,
            -5,
            0,
            2,
            new ItemStack(ConfigBlocks.blockCustomPlant, 1, 5)); // Change to match your block

        // Add Crucible recipes
        CrucibleRecipe redConjurationRecipe = ThaumcraftApi.addCrucibleRecipe(
            "PLANTCONJURATION",
            new ItemStack(ConfigBlocks.blockCustomPlant, 1, 5),
            new ItemStack(Blocks.red_mushroom),
            new AspectList().add(Aspect.PLANT, 2)
                .add(Aspect.LIFE, 2)
                .add(Aspect.MAGIC, 2)
                .add(Aspect.POISON, 4));

        CrucibleRecipe brownConjurationRecipe = ThaumcraftApi.addCrucibleRecipe(
            "PLANTCONJURATION",
            new ItemStack(ConfigBlocks.blockCustomPlant, 1, 5),
            new ItemStack(Blocks.brown_mushroom),
            new AspectList().add(Aspect.PLANT, 2)
                .add(Aspect.LIFE, 2)
                .add(Aspect.MAGIC, 2)
                .add(Aspect.POISON, 4));

        CrucibleRecipe cinderpearlConjurationRecipe = ThaumcraftApi.addCrucibleRecipe(
            "PLANTCONJURATION",
            new ItemStack(ConfigBlocks.blockCustomPlant, 1, 3),
            new ItemStack(Items.blaze_powder),
            new AspectList().add(Aspect.PLANT, 2)
                .add(Aspect.LIFE, 2)
                .add(Aspect.MAGIC, 2)
                .add(Aspect.FIRE, 4));

        // Double yield recipes
        CrucibleRecipe vishroomDuplicationRecipe = ThaumcraftApi.addCrucibleRecipe(
            "PLANTCONJURATION",
            new ItemStack(ConfigBlocks.blockCustomPlant, 2, 5),
            new ItemStack(ConfigBlocks.blockCustomPlant, 1, 5),
            new AspectList().add(Aspect.PLANT, 4)
                .add(Aspect.LIFE, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.POISON, 6));
        CrucibleRecipe cinderpearlDuplicationRecipe = ThaumcraftApi.addCrucibleRecipe(
            "PLANTCONJURATION",
            new ItemStack(ConfigBlocks.blockCustomPlant, 2, 3),
            new ItemStack(ConfigBlocks.blockCustomPlant, 1, 3),
            new AspectList().add(Aspect.PLANT, 4)
                .add(Aspect.LIFE, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.FIRE, 6));
        plantConjurationResearch.setPages(
            // Add pages to your research if necessary
            new ResearchPage("tc.research_page.PLANTCONJURATION.0"),
            new ResearchPage(redConjurationRecipe),
            new ResearchPage(brownConjurationRecipe),
            new ResearchPage(cinderpearlConjurationRecipe),
            new ResearchPage(vishroomDuplicationRecipe),
            new ResearchPage(cinderpearlDuplicationRecipe));
        plantConjurationResearch.setParents("ALCHEMICALDUPLICATION")
            .setConcealed()
            .setSecondary()
            .registerResearchItem();
    }

}
