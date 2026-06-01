package co.nidmight.blighttweaks.recipes.additions.thaumcraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import co.nidmight.blighttweaks.recipes.framework.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.LocalizationUtil;
import cpw.mods.fml.common.registry.GameRegistry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class MiscResearch implements IGameEditor {

    @Override
    public void apply() {
        // ChickenChunks
        Item chunkloader = GameRegistry.findItem("ChickenChunks", "chickenChunkLoader");
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
            new ItemStack(chunkloader));
        chickenChunksResearch.setConcealed();

        ShapedArcaneRecipe shapedArcaneRecipe = ThaumcraftApi.addArcaneCraftingRecipe(
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
        InfusionRecipe infusionRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "CHICKENCHUNKS",
            new ItemStack(chunkloader),
            6,
            new AspectList().add(Aspect.ELDRITCH, 4)
                .add(Aspect.VOID, 4)
                .add(Aspect.getAspect("desidia"), 16),
            new ItemStack(Blocks.obsidian),
            new ItemStack[] { spotloader, spotloader, spotloader, spotloader, spotloader, spotloader, spotloader,
                spotloader });
        chickenChunksResearch.setParents("INFUSION");
        chickenChunksResearch.setPages(
            new ResearchPage("CHICKENCHUNKS", "tc.research_page.CHICKENCHUNKS.0"),
            new ResearchPage("CHICKENCHUNKS", "tc.research_page.CHICKENCHUNKS.1"),
            new ResearchPage(shapedArcaneRecipe),
            new ResearchPage(infusionRecipe));
        LocalizationUtil.setLocalization(
            "tile.chickenChunkLoader|0.name",
            StatCollector.translateToLocal("blighttweaks.chunkloader"));
        LocalizationUtil.setLocalization(
            "tile.chickenChunkLoader|1.name",
            StatCollector.translateToLocal("blighttweaks.spotloader"));

        LocalizationUtil.setLocalization(
            "item.chickenChunkLoader|0.name",
            StatCollector.translateToLocal("blighttweaks.chunkloader"));
        LocalizationUtil.setLocalization(
            "item.chickenChunkLoader|1.name",
            StatCollector.translateToLocal("blighttweaks.spotloader"));
        chickenChunksResearch.registerResearchItem();
    }

    @Override
    public Priority getPriority() {
        return Priority.LOWEST;
    }
}
