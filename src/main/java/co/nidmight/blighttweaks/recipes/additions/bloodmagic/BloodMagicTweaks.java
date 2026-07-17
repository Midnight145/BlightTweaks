package co.nidmight.blighttweaks.recipes.additions.bloodmagic;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.rwtema.extrautils.ExtraUtils;

import WayofTime.alchemicalWizardry.ModBlocks;
import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.alchemy.AlchemyRecipeRegistry;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipe;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRegistry;
import WayofTime.alchemicalWizardry.api.items.ShapedBloodOrbRecipe;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.PredicateUtil;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import cpw.mods.fml.common.registry.GameRegistry;
import tconstruct.tools.TinkerTools;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;

public class BloodMagicTweaks implements IGameEditor {

    @Override
    public void apply() {
        // Executive Mandate Bypass
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.diamond_sword),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.diamond), new ItemStack(Items.diamond),
                new ItemStack(TinkerTools.swordBlade, 1, 1) },
            3);
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.diamond_pickaxe),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.diamond), new ItemStack(Items.diamond),
                new ItemStack(Items.diamond), new ItemStack(TinkerTools.pickaxeHead, 1, 1) },
            3);
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.diamond_axe),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.diamond), new ItemStack(Items.diamond),
                new ItemStack(Items.diamond), new ItemStack(TinkerTools.hatchetHead, 1, 1) },
            3);
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.diamond_shovel),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.diamond), new ItemStack(Items.diamond),
                new ItemStack(TinkerTools.shovelHead, 1, 1) },
            3);

        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.golden_sword),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.gold_ingot),
                new ItemStack(Items.gold_ingot), new ItemStack(TinkerTools.swordBlade, 1, 1) },
            3);
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.golden_pickaxe),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.gold_ingot),
                new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot),
                new ItemStack(TinkerTools.pickaxeHead, 1, 1) },
            3);
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.golden_axe),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.gold_ingot),
                new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot),
                new ItemStack(TinkerTools.hatchetHead, 1, 1) },
            3);
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.golden_shovel),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.gold_ingot),
                new ItemStack(Items.gold_ingot), new ItemStack(TinkerTools.shovelHead, 1, 1) },
            3);

        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.iron_sword),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot), new ItemStack(TinkerTools.swordBlade, 1, 1) },
            3);
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.iron_pickaxe),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot),
                new ItemStack(TinkerTools.pickaxeHead, 1, 1) },
            3);
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.iron_axe),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot),
                new ItemStack(TinkerTools.hatchetHead, 1, 1) },
            3);
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.iron_shovel),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot), new ItemStack(TinkerTools.shovelHead, 1, 1) },
            3);

        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.stone_sword),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Blocks.cobblestone),
                new ItemStack(Blocks.cobblestone), new ItemStack(TinkerTools.swordBlade, 1, 1) },
            3);
        AlchemyRecipeRegistry.registerRecipe(
            new ItemStack(Items.wooden_sword),
            2000,
            new ItemStack[] { new ItemStack(Items.stick), new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(TinkerTools.swordBlade) },
            3);

        // Recipe Gating
        RecipeEditorUtil.removeRecipeByOutput(ModBlocks.blockAltar);
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ModBlocks.blockAltar),
                "S S",
                "SFS",
                "IRI",
                'S',
                "stone",
                'F',
                Blocks.furnace,
                'I',
                "ingotSanguinite",
                'R',
                "gemRuby"));

        RecipeEditorUtil.removeRecipeByOutput(ModItems.sacrificialDagger);
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(ModItems.sacrificialDagger),
                "GGG",
                "DSG",
                "MDG",
                'G',
                "blockGlassColorless",
                'D',
                "gemDiamond",
                'S',
                "ingotSanguinite",
                'M',
                "ingotMithril"));

        Item metallurgySword = GameRegistry.findItem("Metallurgy", "carmot.sword");
        PredicateUtil.removeItemsFromList(
            AltarRecipeRegistry.altarRecipes,
            PredicateUtil.compareItemAndMeta(
                new ItemStack(ModItems.daggerOfSacrifice),
                obj -> obj instanceof AltarRecipe recipe ? recipe.getResult() : null));
        AltarRecipeRegistry.registerAltarRecipe(
            new ItemStack(ModItems.daggerOfSacrifice),
            new ItemStack(metallurgySword),
            2,
            3000,
            20,
            20,
            false);

        RecipeEditorUtil.removeRecipeByOutput(new ItemStack(ModBlocks.bloodRune, 1, 5));
        Item quicksilverIngot = GameRegistry.findItem("Metallurgy", "quicksilver.ingot");
        GameRegistry.addRecipe(
            new ShapedBloodOrbRecipe(
                new ItemStack(ModBlocks.bloodRune, 1, 5),
                "ABA",
                "CDC",
                "AEA",
                'A',
                new ItemStack(Items.bucket),
                'B',
                new ItemStack(ModItems.baseItems, 1, 27),
                'C',
                new ItemStack(quicksilverIngot),
                'D',
                new ItemStack(ModBlocks.speedRune),
                'E',
                new ItemStack(ModItems.archmageBloodOrb)));

        RecipeEditorUtil.removeRecipeByOutput(ModBlocks.runeOfSacrifice);
        Item rubraciumIngot = GameRegistry.findItem("Metallurgy", "rubracium.ingot");
        GameRegistry.addRecipe(
            new ShapedBloodOrbRecipe(
                new ItemStack(ModBlocks.runeOfSacrifice),
                "ABA",
                "CDC",
                "ABA",
                'A',
                new ItemStack(Blocks.stone),
                'B',
                new ItemStack(ModItems.reinforcedSlate),
                'C',
                new ItemStack(rubraciumIngot),
                'D',
                new ItemStack(ModItems.apprenticeBloodOrb)));

        RecipeEditorUtil.removeRecipeByOutput(ModBlocks.runeOfSelfSacrifice);
        Item infuscoliumIngot = GameRegistry.findItem("Metallurgy", "infuscolium.ingot");
        GameRegistry.addRecipe(
            new ShapedBloodOrbRecipe(
                new ItemStack(ModBlocks.runeOfSelfSacrifice),
                "ABA",
                "CDC",
                "ABA",
                'A',
                new ItemStack(Blocks.stone),
                'B',
                new ItemStack(ModItems.reinforcedSlate),
                'C',
                new ItemStack(infuscoliumIngot),
                'D',
                new ItemStack(ModItems.apprenticeBloodOrb)));

        // Bound Ring Recipes
        for (int i = 0; i < 5; i++) {
            BindingRegistry.registerRecipe(
                new ItemStack(co.nidmight.blighttweaks.common.items.Items.boundRing, 1, i),
                new ItemStack(ExtraUtils.angelRing, 1, i));
        }

        // Sigil of the Hardened Soul
        GameRegistry.addRecipe(
            new ShapedBloodOrbRecipe(
                co.nidmight.blighttweaks.common.items.Items.soulSigil,
                "ABA",
                "CDC",
                "AEA",
                'A',
                new ItemStack(ModItems.baseItems, 1, 16),
                'B',
                new ItemStack(ModItems.baseItems, 1, 30),
                'C',
                new ItemStack(ModItems.baseItems, 1, 17),
                'D',
                new ItemStack(ModItems.baseItems, 1, 27),
                'E',
                new ItemStack(ModItems.transcendentBloodOrb)));

        // Dawn Inscription Tool Thaum Research

        ResearchItem dawnToolResearch = new ResearchItem(
            "DAWNTOOL",
            "FORBIDDEN",
            new AspectList().add(Aspect.ORDER, 50)
                .add(Aspect.EARTH, 50)
                .add(Aspect.AIR, 50)
                .add(Aspect.AURA, 50)
                .add(Aspect.TOOL, 50)
                .add(Aspect.LIGHT, 50),
            -3,
            0,
            8,
            new ItemStack(ModItems.dawnScribeTool));
        dawnToolResearch.setConcealed();
        dawnToolResearch.setParents("BLOODMAGIC", "DAWNMACHINE");
        ThaumcraftApi.addWarpToResearch("DAWNTOOL", 5);

        InfusionRecipe dawnToolRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "DAWNTOOL",
            new ItemStack(ModItems.dawnScribeTool),
            12,
            new AspectList().add(Aspect.ORDER, 64)
                .add(Aspect.EARTH, 64)
                .add(Aspect.AIR, 64)
                .add(Aspect.WATER, 64)
                .add(Aspect.FIRE, 64)
                .add(Aspect.AURA, 64)
                .add(Aspect.TOOL, 64)
                .add(Aspect.LIGHT, 64),
            new ItemStack(ModItems.duskScribeTool),
            new ItemStack[] { new ItemStack(ModItems.baseItems, 1, 27), new ItemStack(ModItems.baseItems, 1, 27),
                new ItemStack(ModItems.fireScribeTool), new ItemStack(ModItems.waterScribeTool),
                new ItemStack(ModItems.earthScribeTool), new ItemStack(ModItems.airScribeTool),
                new ItemStack(ConfigItems.itemResource, 1, 1), new ItemStack(ConfigItems.itemResource, 1, 1),
                new ItemStack(ModItems.sanctus), new ItemStack(ModItems.sanctus), new ItemStack(Blocks.glowstone),
                new ItemStack(Blocks.glowstone) });

        dawnToolResearch.setPages(new ResearchPage("tc.research_page.DAWNTOOL.1"), new ResearchPage(dawnToolRecipe));
        dawnToolResearch.registerResearchItem();

        // Tier 6 Thaumcraft Research

        ResearchItem tierSixResearch = new ResearchItem(
            "TIERSIX",
            "FORBIDDEN",
            new AspectList().add(Aspect.LIFE, 50)
                .add(Aspect.SOUL, 50)
                .add(Aspect.ELDRITCH, 50)
                .add(Aspect.getAspect("infernus"), 50)
                .add(Aspect.UNDEAD, 50)
                .add(Aspect.CRYSTAL, 50),
            -4,
            0,
            8,
            new ItemStack(ModBlocks.blockCrystal));

        tierSixResearch.setConcealed();
        tierSixResearch.setParents("BLOODMAGIC", "DAWNTOOL");
        ThaumcraftApi.addWarpToResearch("TIERSIX", 5);

        RecipeEditorUtil.removeRecipeByOutput(ModBlocks.blockCrystal);
        IArcaneRecipe crystalClusterRecipe = ThaumcraftApi.addArcaneCraftingRecipe(
            "TIERSIX",
            new ItemStack(ModBlocks.blockCrystal, 2),
            new AspectList().add(Aspect.ORDER, 50)
                .add(Aspect.EARTH, 50)
                .add(Aspect.ENTROPY, 50)
                .add(Aspect.FIRE, 50)
                .add(Aspect.WATER, 50)
                .add(Aspect.AIR, 50),
            "AB",
            "BA",
            'A',
            new ItemStack(ModItems.baseItems, 1, 28),
            'B',
            new ItemStack(ModItems.baseItems, 1, 29));
        InfusionRecipe lifeShardRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "TIERSIX",
            new ItemStack(ModItems.baseItems, 2, 28),
            12,
            new AspectList().add(Aspect.LIFE, 16)
                .add(Aspect.SOUL, 16)
                .add(Aspect.ELDRITCH, 16)
                .add(Aspect.getAspect("infernus"), 16)
                .add(Aspect.UNDEAD, 16)
                .add(Aspect.CRYSTAL, 16),
            new ItemStack(ModItems.weakBloodShard),
            new ItemStack[] { new ItemStack(ModItems.magicales), new ItemStack(ModItems.baseAlchemyItems, 1, 8),
                new ItemStack(ModItems.incendium), new ItemStack(ModItems.terrae), new ItemStack(ModItems.tennebrae),
                new ItemStack(ModItems.sanctus), new ItemStack(ModItems.aether), new ItemStack(ModItems.aquasalus),
                new ItemStack(ModItems.bucketLife), new ItemStack(ModItems.bucketLife),
                new ItemStack(ModItems.baseItems, 1, 27), new ItemStack(ModItems.greaterPowerCatalyst) });

        InfusionRecipe soulShardRecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "TIERSIX",
            new ItemStack(ModItems.baseItems, 2, 29),
            12,
            new AspectList().add(Aspect.LIFE, 16)
                .add(Aspect.SOUL, 16)
                .add(Aspect.ELDRITCH, 16)
                .add(Aspect.getAspect("infernus"), 16)
                .add(Aspect.UNDEAD, 16)
                .add(Aspect.CRYSTAL, 16),
            new ItemStack(ModItems.demonBloodShard),
            new ItemStack[] { new ItemStack(ModItems.magicales), new ItemStack(ModItems.baseAlchemyItems, 1, 8),
                new ItemStack(ModItems.incendium), new ItemStack(ModItems.terrae), new ItemStack(ModItems.tennebrae),
                new ItemStack(ModItems.sanctus), new ItemStack(ModItems.aether), new ItemStack(ModItems.aquasalus),
                new ItemStack(ModItems.bucketLife), new ItemStack(ModItems.bucketLife),
                new ItemStack(ModItems.baseItems, 1, 27), new ItemStack(ModItems.greaterLengtheningCatalyst) });

        tierSixResearch.setPages(
            new ResearchPage("tc.research_page.TIERSIX.1"),
            new ResearchPage(lifeShardRecipe),
            new ResearchPage(soulShardRecipe),
            new ResearchPage(crystalClusterRecipe));
        tierSixResearch.registerResearchItem();

    }
}
