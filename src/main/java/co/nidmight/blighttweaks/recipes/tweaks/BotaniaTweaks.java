package co.nidmight.blighttweaks.recipes.tweaks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import co.nidmight.blighttweaks.recipes.helpers.BotaniaEditorUtil;
import co.nidmight.blighttweaks.recipes.helpers.EditorEventHandler;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.ManaCookieDoughRecipe;
import co.nidmight.blighttweaks.recipes.helpers.RecipeEditorUtil;
import co.nidmight.blighttweaks.recipes.helpers.ThaumcraftEditorUtil;
import cofh.thermalexpansion.util.crafting.SmelterManager;
import cpw.mods.fml.common.registry.GameRegistry;
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
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeManaInfusion;
import vazkii.botania.api.recipe.RecipePetals;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.lexicon.page.PageManaInfusionRecipe;
import vazkii.botania.common.lexicon.page.PagePetalRecipe;
import vazkii.botania.common.lexicon.page.PageText;

public class BotaniaTweaks implements IGameEditor {

    private Item lookupItem(String name) {
        return GameRegistry.findItem("Botania", name);
    }

    @Override
    public void apply() {

        RecipeEditorUtil.removeRecipeByOutput(ModItems.fertilizer);

        BotaniaEditorUtil.replacePage("botania.entry.flowers", new PageText("botania.page.blightfallFlower0"), 0);
        BotaniaEditorUtil.replacePage("botania.entry.flowers", new PageText("botania.page.blightfallFlower6"), 6);
        BotaniaEditorUtil.replacePage("botania.entry.flowers", new PageText("botania.page.blightfallFlower8"), 8);
        BotaniaEditorUtil.replacePage("botania.entry.flowers", new PageText("botania.page.blightfallFlower9"), 9);
        BotaniaEditorUtil.removePage("botania.entry.flowers", 7);

        BotaniaEditorUtil.addPage("botania.entry.pureDaisy", new PageText("botania.page.BlightfallPureDaisy5"), 5);

        BotaniaEditorUtil.removeEntry("botania.entry.orechidIgnem");
        BotaniaEditorUtil.removeEntry("botania.entry.wrap");
        BotaniaEditorUtil.removeEntry("botania.entry.primusLoci");
        BotaniaEditorUtil.removeEntry("botania.entry.spellCloth");
        RecipeEditorUtil.removeRecipeByOutput(ModItems.spellCloth);

        BotaniaEditorUtil
            .replacePage("botania.entry.elfMessage", new PageText("botania.page.blightfallElfMessage1"), 1);
        BotaniaEditorUtil
            .replacePage("botania.entry.elfMessage", new PageText("botania.page.blightfallElfMessage1"), 3);

        BotaniaEditorUtil
            .replacePage("forbidden.lexicon.tainthistle", new PageText("botania.page.blightfallTainthistle"), 0);
        BotaniaEditorUtil
            .replacePage("forbidden.lexicon.euclidaisy", new PageText("botania.page.blightfallEuclidaisy"), 0);
        BotaniaEditorUtil
            .replacePage("forbidden.lexicon.whisperweed", new PageText("botania.page.blightfallWhisperweed"), 0);

        // Gate lexicon behind translator
        RecipeEditorUtil.removeRecipeByOutput(ModItems.lexicon);
        Item tabulaRasaItem = GameRegistry.findItem("TabulaRasa", "RasaItem0");
        GameRegistry.addShapelessRecipe(
            new ItemStack(ModItems.lexicon),
            new ItemStack(tabulaRasaItem, 1, 19),
            new ItemStack(tabulaRasaItem, 1, 18));
        GameRegistry.addShapelessRecipe(
            new ItemStack(ModItems.lexicon, 2),
            new ItemStack(ModItems.lexicon),
            new ItemStack(Items.book));

        // Thaumomorphic Essence Research
        ResearchItem thaumomorphicEssence = new ResearchItem(
            "THAUMOMORPHICESSENCE",
            "FORBIDDEN",
            new AspectList().add(Aspect.MAGIC, 15)
                .add(Aspect.PLANT, 15)
                .add(Aspect.EXCHANGE, 15)
                .add(Aspect.SENSES, 5),
            -5,
            4,
            4,
            new ItemStack(tabulaRasaItem, 1, 20));
        ItemStack itemResource14 = new ItemStack(ConfigItems.itemResource, 1, 14);
        InfusionRecipe irecipe = ThaumcraftApi.addInfusionCraftingRecipe(
            "THAUMOMORPHICESSENCE",
            new ItemStack(tabulaRasaItem, 1, 20),
            6,
            new AspectList().add(Aspect.EXCHANGE, 40)
                .add(Aspect.PLANT, 16)
                .add(Aspect.MAGIC, 16)
                .add(Aspect.SENSES, 40)
                .add(Aspect.LIGHT, 8),
            new ItemStack(Items.dye, 1, 15),
            new ItemStack[] { itemResource14, itemResource14, itemResource14, itemResource14, itemResource14,
                itemResource14, new ItemStack(ModItems.manaResource, 1, 1) });

        IArcaneRecipe aRecipe = ThaumcraftApi.addArcaneCraftingRecipe(
            "THAUMOMORPHICESSENCE",
            new ItemStack(ModItems.manaResource, 1, 1),
            new AspectList().add(Aspect.AIR, 50)
                .add(Aspect.FIRE, 50)
                .add(Aspect.WATER, 50)
                .add(Aspect.EARTH, 50)
                .add(Aspect.ORDER, 50)
                .add(Aspect.ENTROPY, 50),
            "ABA",
            "BCB",
            'A',
            itemResource14,
            'B',
            new ItemStack(ModItems.manaBottle),
            'C',
            "pearlEnder");

        CrucibleRecipe cRecible = ThaumcraftApi.addCrucibleRecipe(
            "THAUMOMORPHICESSENCE",
            new ItemStack(ModItems.manaResource, 1, 1),
            new ItemStack(Items.glass_bottle),
            new AspectList().add(Aspect.MAGIC, 16)
                .add(Aspect.SENSES, 8)
                .add(Aspect.ENERGY, 8));

        thaumomorphicEssence.setPages(
            new ResearchPage("tc.research_page.THAUMOMORPHICESSENCE.1"),
            new ResearchPage(irecipe),
            new ResearchPage("tc.research_page.THAUMOMORPHICESSENCE.2"),
            new ResearchPage(aRecipe),
            new ResearchPage("tc.research_page.THAUMOMORPHICESSENCE.3"),
            new ResearchPage(cRecible));

        thaumomorphicEssence.registerResearchItem();

        // Flower oredict recipes
        OreDictionary.registerOre("nonmagicFlower", Blocks.yellow_flower);
        OreDictionary.registerOre("nonmagicFlower", Blocks.red_flower);

        for (int i = 0; i < 16; i++) {
            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    new ItemStack(ModBlocks.flower, 1, i),
                    "nonmagicFlower",
                    new ItemStack(Items.dye, 1, 15 - i),
                    new ItemStack(tabulaRasaItem, 1, 20)));
        }

        // Adding new botanist flowers and lexicon entries for them.

        ItemStack botanistEtherealBloom = new ItemStack(ConfigBlocks.blockCustomPlant, 1, 4)
            .setStackDisplayName("Botanist Ethereal Bloom");
        RecipePetals bloomRecipe = BotaniaAPI.registerPetalRecipe(
            botanistEtherealBloom,
            "petalWhite",
            "petalWhite",
            "petalLightBlue",
            "petalLightBlue",
            "petalGreen",
            "petalLime",
            "petalCyan",
            "petalCyan",
            "petalBlue",
            "petalBlue",
            "runeEarthB",
            "runeSpringB");

        BotaniaEditorUtil.addEntry(
            "botania.entry.etherealBloom",
            BotaniaAPI.categoryFunctionalFlowers,
            botanistEtherealBloom,
            new PageText("botania.page.etherealBloom0"),
            new PagePetalRecipe<>("botania.page.etherealBloom1", bloomRecipe));

        ItemStack botanistShimmerleaf = new ItemStack(ConfigBlocks.blockCustomPlant, 1, 2)
            .setStackDisplayName("Botanist Shimmerleaf");
        RecipePetals shimmerleafRecipe = BotaniaAPI.registerPetalRecipe(
            botanistShimmerleaf,
            "petalWhite",
            "petalWhite",
            "petalLightBlue",
            "petalLightBlue",
            "petalGreen");

        BotaniaEditorUtil.addEntry(
            "botania.entry.shimmerleaf",
            BotaniaAPI.categoryFunctionalFlowers,
            botanistShimmerleaf,
            new PageText("botania.page.shimmerleaf0"),
            new PagePetalRecipe<>("botania.page.shimmerleaf1", shimmerleafRecipe));

        // Ender Air recipe
        ItemStack essence = new ItemStack(ConfigItems.itemCrystalEssence);
        NBTTagCompound essenceNBT = new NBTTagCompound();
        AspectList aspects = new AspectList().add(Aspect.ELDRITCH, 15);
        aspects.writeToNBT(essenceNBT);
        essence.setTagCompound(essenceNBT);
        SmelterManager.addRecipe(
            400,
            new ItemStack(Blocks.end_stone),
            new ItemStack(Items.glass_bottle),
            new ItemStack(ModItems.manaResource, 1, 15),
            essence,
            15);

        // Misc. recipe tweaks
        BotaniaEditorUtil.removeManaRecipeByOutput(new ItemStack(Items.nether_wart));
        BotaniaAPI.registerManaAlchemyRecipe(new ItemStack(Items.nether_wart), new ItemStack(Items.blaze_powder), 4000);
        BotaniaAPI.registerManaAlchemyRecipe(new ItemStack(Items.ghast_tear), new ItemStack(Items.blaze_rod), 20000);

        // Remove lexicon from loot tables, replace with untranslated
        ItemStack lexicon = new ItemStack(ModItems.lexicon);
        ItemStack alienLexicon = new ItemStack(tabulaRasaItem, 1, 19);
        ChestGenHooks.removeItem(ChestGenHooks.DUNGEON_CHEST, lexicon);
        ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(alienLexicon, 1, 1, 6));
        ChestGenHooks.removeItem(ChestGenHooks.BONUS_CHEST, lexicon);
        ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(alienLexicon, 1, 1, 7));

        // Mana cookie nerfs
        ItemStack tabulaCookie = new ItemStack(tabulaRasaItem, 1, 28);
        RecipeManaInfusion manaCookieRecipe = BotaniaAPI
            .registerManaInfusionRecipe(new ItemStack(ModItems.manaCookie), tabulaCookie, 20000);
        BotaniaEditorUtil
            .replacePage("botania.entry.pool", new PageManaInfusionRecipe("botania.page.pool7", manaCookieRecipe), 14);

        // Mana cookie dough recipes
        IRecipe cookieRecipe = new ManaCookieDoughRecipe(Aspect.FLESH, new ItemStack(tabulaRasaItem, 4, 29));
        EditorEventHandler.getInstance()
            .addTransformReplace(cookieRecipe, new ItemStack(ModItems.manaBottle), new ItemStack(Items.glass_bottle));
        GameRegistry.addRecipe(cookieRecipe);
        cookieRecipe = new ManaCookieDoughRecipe(Aspect.getAspect("gula"), new ItemStack(tabulaRasaItem, 3, 29));
        EditorEventHandler.getInstance()
            .addTransformReplace(cookieRecipe, new ItemStack(ModItems.manaBottle), new ItemStack(Items.glass_bottle));
        GameRegistry.addRecipe(cookieRecipe);
        cookieRecipe = new ManaCookieDoughRecipe(Aspect.HUNGER, new ItemStack(tabulaRasaItem, 2, 29));
        EditorEventHandler.getInstance()
            .addTransformReplace(cookieRecipe, new ItemStack(ModItems.manaBottle), new ItemStack(Items.glass_bottle));
        GameRegistry.addRecipe(cookieRecipe);
        cookieRecipe = new ManaCookieDoughRecipe(null, new ItemStack(tabulaRasaItem, 1, 29));
        EditorEventHandler.getInstance()
            .addTransformReplace(cookieRecipe, new ItemStack(ModItems.manaBottle), new ItemStack(Items.glass_bottle));
        GameRegistry.addRecipe(cookieRecipe);

        RecipeEditorUtil.addTooltip(
            new ItemStack(tabulaRasaItem, 1, 28),
            StatCollector.translateToLocal("tooltip.manaCookieRaw1"),
            StatCollector.translateToLocal("tooltip.manaCookieRaw2"),
            StatCollector.translateToLocal("tooltip.manaCookieRaw3"));

        RecipeEditorUtil.addTooltip(
            new ItemStack(tabulaRasaItem, 1, 29),
            StatCollector.translateToLocal("tooltip.manaCookieDough1"),
            StatCollector.translateToLocal("tooltip.manaCookieDough2"));

        RecipeEditorUtil.addTooltip(
            ModItems.manaCookie,
            StatCollector.translateToLocal("tooltip.manaCookie1"),
            StatCollector.translateToLocal("tooltip.manaCookie2"));

        // remove passive decay rafflowsia mentions
        BotaniaEditorUtil.removePage("botania.entry.rafflowsia", 0);
        BotaniaEditorUtil.removePage("botania.entry.rafflowsia", 0);
        BotaniaEditorUtil.removePage("botania.entry.rafflowsia", 0);

        // Setting aspects for tons of items
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.flower, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.LIFE, 1)
                .add(Aspect.SENSES, 1)
                .add(Aspect.MAGIC, 1)); // You can get infinite mana from floral fertilizer, but it's grindy.
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.petal, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.MAGIC, 1)
                .add(Aspect.SENSES, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.dye, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.PLANT, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.fertilizer),
            new AspectList().add(Aspect.PLANT, 3)
                .add(Aspect.SENSES, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manaResource),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 2)
                .add(Aspect.SENSES, 2)); // Nerf Iron-Magic engines.
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manaResource, 1, 1),
            new AspectList().add(Aspect.ELDRITCH, 4)
                .add(Aspect.TRAVEL, 4)
                .add(Aspect.MAGIC, 6)
                .add(Aspect.SENSES, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manaResource, 1, 2),
            new AspectList().add(Aspect.GREED, 4)
                .add(Aspect.CRYSTAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manaResource, 1, 3),
            new AspectList().add(Aspect.TREE, 2)
                .add(Aspect.SENSES, 1)
                .add(Aspect.MAGIC, 1)); // Nerf wood-magic engines.
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manaResource, 1, 4),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 18)
                .add(Aspect.SENSES, 6)
                .add(Aspect.EARTH, 10)
                .add(Aspect.GREED, 4)
                .add(Aspect.CRYSTAL, 4)
                .add(Aspect.TRAVEL, 4)
                .add(Aspect.ELDRITCH, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manaResource, 1, 5),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.EARTH, 20)
                .add(Aspect.MAGIC, 34)
                .add(Aspect.SOUL, 15)); // Added metallum because I'm a punk.
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manaResource, 1, 7),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.TRAVEL, 2)
                .add(Aspect.AURA, 1)); // 2-1 ratio, not bad.
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manaResource, 1, 8),
            new AspectList().add(Aspect.ELDRITCH, 4)
                .add(Aspect.TRAVEL, 6)
                .add(Aspect.MAGIC, 6)
                .add(Aspect.SENSES, 2)
                .add(Aspect.AURA, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manaResource, 1, 9),
            new AspectList().add(Aspect.GREED, 4)
                .add(Aspect.CRYSTAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.TRAVEL, 2)
                .add(Aspect.AURA, 1)
                .add(Aspect.getAspect("superbia"), 2)); // Added superbia.
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.WATER, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 1),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.FIRE, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 2),
            new AspectList().add(Aspect.EARTH, 5)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)); // Consolodated Terra.
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 3),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.AIR, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 4),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.AURA, 1)
                .add(Aspect.PLANT, 4)); // Buffed season runes by one.
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 5),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.AURA, 1)
                .add(Aspect.FIRE, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 6),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.AURA, 1)
                .add(Aspect.TREE, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 7),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.AURA, 1)
                .add(Aspect.COLD, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 8),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 9)
                .add(Aspect.SENSES, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 9),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.MAN, 2)
                .add(Aspect.LIFE, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 10),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.HUNGER, 5)
                .add(Aspect.getAspect("gula"), 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 11),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.GREED, 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 12),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.MOTION, 1)
                .add(Aspect.getAspect("desidia"), 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 13),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.MAN, 2)
                .add(Aspect.WEAPON, 1)
                .add(Aspect.getAspect("ira"), 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 14),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.MAN, 2)
                .add(Aspect.MIND, 1)
                .add(Aspect.HUNGER, 1)
                .add(Aspect.getAspect("desidia"), 1)
                .add(Aspect.getAspect("invidia"), 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rune, 1, 15),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 2)
                .add(Aspect.MAN, 1)
                .add(Aspect.MIND, 1)
                .add(Aspect.GREED, 1)
                .add(Aspect.METAL, 1)
                .add(Aspect.getAspect("superbia"), 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.rainbowRod),
            new AspectList().add(Aspect.METAL, 8)
                .add(Aspect.MAGIC, 10)
                .add(Aspect.SENSES, 8)
                .add(Aspect.TRAVEL, 9)
                .add(Aspect.AURA, 5)
                .add(Aspect.ELDRITCH, 8)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.livingrock, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.livingwood, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.TREE, 3)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.SENSES, 2)); // planks used to give 5 which was a bit much
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.livingwood, 1, 0),
            new AspectList().add(Aspect.TREE, 3)
                .add(Aspect.MAGIC, 12)
                .add(Aspect.SENSES, 2)); // nerfed so a full block gives 12 and planks give 3
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.alfPortal),
            new AspectList().add(Aspect.TREE, 5)
                .add(Aspect.MAGIC, 10)
                .add(Aspect.SENSES, 6)
                .add(Aspect.METAL, 4)
                .add(Aspect.EARTH, 10)
                .add(Aspect.GREED, 4)
                .add(Aspect.CRYSTAL, 4)
                .add(Aspect.TRAVEL, 4)
                .add(Aspect.ELDRITCH, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.altar),
            new AspectList().add(Aspect.ENTROPY, 2)
                .add(Aspect.EARTH, 2)
                .add(Aspect.PLANT, 1)
                .add(Aspect.MAGIC, 1)
                .add(Aspect.SENSES, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.runeAltar),
            new AspectList().add(Aspect.MAGIC, 10)
                .add(Aspect.CRAFT, 4)
                .add(Aspect.MIND, 4)
                .add(Aspect.ORDER, 10)
                .add(Aspect.AIR, 5)
                .add(Aspect.CRYSTAL, 4)
                .add(Aspect.ELDRITCH, 4)
                .add(Aspect.TRAVEL, 4)
                .add(Aspect.EARTH, 4)); // Nerfed Magic.
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.pylon),
            new AspectList().add(Aspect.METAL, 10)
                .add(Aspect.MAGIC, 8)
                .add(Aspect.SENSES, 6)
                .add(Aspect.GREED, 8)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.pylon, 1, 1),
            new AspectList().add(Aspect.METAL, 10)
                .add(Aspect.MAGIC, 10)
                .add(Aspect.SENSES, 9)
                .add(Aspect.EARTH, 5)
                .add(Aspect.GREED, 10)
                .add(Aspect.CRYSTAL, 6)
                .add(Aspect.TRAVEL, 2)
                .add(Aspect.ELDRITCH, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.pylon, 1, 2),
            new AspectList().add(Aspect.METAL, 10)
                .add(Aspect.MAGIC, 10)
                .add(Aspect.SENSES, 8)
                .add(Aspect.TRAVEL, 7)
                .add(Aspect.AURA, 4)
                .add(Aspect.GREED, 8)
                .add(Aspect.CRYSTAL, 4)
                .add(Aspect.ELDRITCH, 8));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.shinyFlower, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.LIFE, 1)
                .add(Aspect.SENSES, 1)
                .add(Aspect.MAGIC, 1)
                .add(Aspect.LIGHT, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.floatingFlower, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.LIFE, 1)
                .add(Aspect.SENSES, 1)
                .add(Aspect.MAGIC, 1)
                .add(Aspect.EARTH, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.manaBeacon),
            new AspectList().add(Aspect.MAGIC, 10)
                .add(Aspect.ELDRITCH, 8)
                .add(Aspect.ENTROPY, 10)
                .add(Aspect.LIGHT, 10)
                .add(Aspect.CRYSTAL, 5)
                .add(Aspect.AURA, 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.unstableBlock),
            new AspectList().add(Aspect.MAGIC, 5)
                .add(Aspect.ELDRITCH, 3)
                .add(Aspect.ENTROPY, 2)
                .add(Aspect.LIGHT, 3)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.AURA, 2)); // Halved everything. Don't think the author of this file knew it made 2.
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.enderDagger),
            new AspectList().add(Aspect.TREE, 2)
                .add(Aspect.SENSES, 4)
                .add(Aspect.MAGIC, 8)
                .add(Aspect.METAL, 4)
                .add(Aspect.ELDRITCH, 3)
                .add(Aspect.TRAVEL, 2)
                .add(Aspect.WEAPON, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.terraSword),
            new AspectList().add(Aspect.LIFE, 5)
                .add(Aspect.FIRE, 5)
                .add(Aspect.LIGHT, 5)
                .add(Aspect.PLANT, 5)
                .add(Aspect.SENSES, 5)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.WEAPON, 3)
                .add(Aspect.METAL, 5)
                .add(Aspect.TREE, 2)
                .add(Aspect.TRAVEL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.terraPick),
            new AspectList().add(Aspect.LIFE, 5)
                .add(Aspect.FIRE, 5)
                .add(Aspect.LIGHT, 5)
                .add(Aspect.PLANT, 5)
                .add(Aspect.SENSES, 5)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.MINE, 4)
                .add(Aspect.METAL, 7)
                .add(Aspect.TREE, 2)
                .add(Aspect.TRAVEL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 1),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.AIR, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 2),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.FIRE, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 3),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.EARTH, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 4),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.WATER, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 5),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.AURA, 1)
                .add(Aspect.FIRE, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 6),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.AURA, 1)
                .add(Aspect.COLD, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 7),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.GREED, 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 8),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.MAN, 2)
                .add(Aspect.WEAPON, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 9),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.SOUL, 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 10),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.TRAVEL, 2)
                .add(Aspect.MOTION, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 11),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.MIND, 1)
                .add(Aspect.HUNGER, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 12),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.TRAVEL, 8));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 13),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.FLESH, 8));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 14),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 6)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 4)
                .add(Aspect.AURA, 2)
                .add(Aspect.LIGHT, 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 15),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.FIRE, 8));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.lens, 1, 16),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.CRYSTAL, 2)
                .add(Aspect.MOTION, 8));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manasteelPick),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.MINE, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.elementiumPick),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.TRAVEL, 3)
                .add(Aspect.AURA, 2)
                .add(Aspect.MINE, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.glassPick),
            new AspectList().add(Aspect.METAL, 2)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.SENSES, 2)
                .add(Aspect.MINE, 2)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manasteelShovel),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.TREE, 2)
                .add(Aspect.TOOL, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.elementiumShovel),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.SENSES, 2)
                .add(Aspect.TRAVEL, 2)
                .add(Aspect.AURA, 1)
                .add(Aspect.TREE, 2)
                .add(Aspect.TOOL, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manasteelAxe),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.TOOL, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.elementiumAxe),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.TRAVEL, 3)
                .add(Aspect.AURA, 2)
                .add(Aspect.TOOL, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manasteelShears),
            new AspectList().add(Aspect.METAL, 5)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.HARVEST, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.elementiumShears),
            new AspectList().add(Aspect.METAL, 5)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.TRAVEL, 3)
                .add(Aspect.AURA, 2)
                .add(Aspect.HARVEST, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manasteelSword),
            new AspectList().add(Aspect.METAL, 5)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.TREE, 1)
                .add(Aspect.WEAPON, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.elementiumSword),
            new AspectList().add(Aspect.METAL, 5)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.TRAVEL, 3)
                .add(Aspect.AURA, 2)
                .add(Aspect.TREE, 1)
                .add(Aspect.WEAPON, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manasteelHelm),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.ARMOR, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.elementiumHelm),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.TRAVEL, 3)
                .add(Aspect.AURA, 2)
                .add(Aspect.ARMOR, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.terrasteelHelm),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 10)
                .add(Aspect.SENSES, 6)
                .add(Aspect.EARTH, 10)
                .add(Aspect.GREED, 6)
                .add(Aspect.CRYSTAL, 6)
                .add(Aspect.TRAVEL, 6)
                .add(Aspect.ELDRITCH, 6)
                .add(Aspect.ARMOR, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manasteelChest),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.ARMOR, 6));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.elementiumChest),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.TRAVEL, 3)
                .add(Aspect.AURA, 2)
                .add(Aspect.ARMOR, 6));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.terrasteelChest),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 10)
                .add(Aspect.SENSES, 6)
                .add(Aspect.EARTH, 10)
                .add(Aspect.GREED, 6)
                .add(Aspect.CRYSTAL, 6)
                .add(Aspect.TRAVEL, 6)
                .add(Aspect.ELDRITCH, 6)
                .add(Aspect.ARMOR, 6));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manasteelLegs),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.ARMOR, 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.elementiumLegs),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.TRAVEL, 3)
                .add(Aspect.AURA, 2)
                .add(Aspect.ARMOR, 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.terrasteelLegs),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 10)
                .add(Aspect.SENSES, 6)
                .add(Aspect.EARTH, 10)
                .add(Aspect.GREED, 6)
                .add(Aspect.CRYSTAL, 6)
                .add(Aspect.TRAVEL, 6)
                .add(Aspect.ELDRITCH, 6)
                .add(Aspect.ARMOR, 5));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manasteelBoots),
            new AspectList().add(Aspect.METAL, 5)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.ARMOR, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.elementiumBoots),
            new AspectList().add(Aspect.METAL, 5)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 3)
                .add(Aspect.TRAVEL, 3)
                .add(Aspect.AURA, 2)
                .add(Aspect.ARMOR, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.terrasteelBoots),
            new AspectList().add(Aspect.METAL, 5)
                .add(Aspect.MAGIC, 10)
                .add(Aspect.SENSES, 6)
                .add(Aspect.EARTH, 10)
                .add(Aspect.GREED, 6)
                .add(Aspect.CRYSTAL, 6)
                .add(Aspect.TRAVEL, 6)
                .add(Aspect.ELDRITCH, 6)
                .add(Aspect.ARMOR, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manasteelHelmRevealing),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 10)
                .add(Aspect.ARMOR, 2)
                .add(Aspect.CRYSTAL, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.elementiumHelmRevealing),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 10)
                .add(Aspect.TRAVEL, 3)
                .add(Aspect.AURA, 2)
                .add(Aspect.ARMOR, 2)
                .add(Aspect.CRYSTAL, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.terrasteelHelmRevealing),
            new AspectList().add(Aspect.METAL, 6)
                .add(Aspect.MAGIC, 10)
                .add(Aspect.SENSES, 10)
                .add(Aspect.EARTH, 10)
                .add(Aspect.GREED, 6)
                .add(Aspect.CRYSTAL, 8)
                .add(Aspect.TRAVEL, 6)
                .add(Aspect.ELDRITCH, 6)
                .add(Aspect.ARMOR, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.tinyPlanet),
            new AspectList().add(Aspect.EARTH, 7)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 4)
                .add(Aspect.TRAVEL, 4)
                .add(Aspect.MOTION, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.tinyPlanet),
            new AspectList().add(Aspect.EARTH, 10)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 4)
                .add(Aspect.TRAVEL, 4)
                .add(Aspect.MOTION, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.spreader),
            new AspectList().add(Aspect.TREE, 5)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 4)
                .add(Aspect.PLANT, 1)
                .add(Aspect.GREED, 2)); // Nerfed magic
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.spreader, 1, 1),
            new AspectList().add(Aspect.TREE, 5)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 4)
                .add(Aspect.PLANT, 1)
                .add(Aspect.GREED, 2)
                .add(Aspect.ENERGY, 2)); // Nerfed magic
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.dreamwood, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.TREE, 4)
                .add(Aspect.MAGIC, 7)
                .add(Aspect.SENSES, 3)
                .add(Aspect.MIND, 3)
                .add(Aspect.AURA, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.spreader, 1, 2),
            new AspectList().add(Aspect.TREE, 5)
                .add(Aspect.MAGIC, 8)
                .add(Aspect.SENSES, 6)
                .add(Aspect.MIND, 3)
                .add(Aspect.AURA, 3)
                .add(Aspect.PLANT, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.reedBlock),
            new AspectList().add(Aspect.PLANT, 4)
                .add(Aspect.WATER, 4)
                .add(Aspect.AIR, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("reedBlock0Stairs")),
            new AspectList().add(Aspect.PLANT, 3)
                .add(Aspect.WATER, 3)
                .add(Aspect.AIR, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("reedBlock0Slab")),
            new AspectList().add(Aspect.PLANT, 2)
                .add(Aspect.WATER, 2)
                .add(Aspect.AIR, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.thatch),
            new AspectList().add(Aspect.HUNGER, 4)
                .add(Aspect.CROP, 8));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("thatch0Stairs")),
            new AspectList().add(Aspect.HUNGER, 3)
                .add(Aspect.CROP, 6));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("thatch0Slab")),
            new AspectList().add(Aspect.HUNGER, 2)
                .add(Aspect.CROP, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick),
            new AspectList().add(Aspect.EARTH, 4)
                .add(Aspect.FIRE, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 1),
            new AspectList().add(Aspect.EARTH, 4)
                .add(Aspect.SOUL, 3)
                .add(Aspect.TRAP, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 2),
            new AspectList().add(Aspect.EARTH, 4)
                .add(Aspect.COLD, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 3),
            new AspectList().add(Aspect.EARTH, 4)
                .add(Aspect.FIRE, 3)
                .add(Aspect.CRAFT, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("customBrick0Stairs")),
            new AspectList().add(Aspect.EARTH, 3)
                .add(Aspect.FIRE, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("customBrick1Stairs")),
            new AspectList().add(Aspect.EARTH, 3)
                .add(Aspect.SOUL, 2)
                .add(Aspect.TRAP, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("customBrick1Stairs")),
            new AspectList().add(Aspect.EARTH, 3)
                .add(Aspect.SOUL, 2)
                .add(Aspect.TRAP, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("customBrick2Stairs")),
            new AspectList().add(Aspect.EARTH, 3)
                .add(Aspect.COLD, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("customBrick3Stairs")),
            new AspectList().add(Aspect.EARTH, 3)
                .add(Aspect.FIRE, 2)
                .add(Aspect.CRAFT, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("customBrick0Slab")),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.FIRE, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("customBrick1Slab")),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.SOUL, 1)
                .add(Aspect.TRAP, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("customBrick2Slab")),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.COLD, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("customBrick3Slab")),
            new AspectList().add(Aspect.EARTH, 2)
                .add(Aspect.FIRE, 1)
                .add(Aspect.CRAFT, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 4),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 5),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 6),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 7),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 8),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 9),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 10),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 11),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 12),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 13),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 14),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.customBrick, 1, 15),
            new AspectList().add(Aspect.SENSES, 1)
                .add(Aspect.ENERGY, 4)
                .add(Aspect.CRYSTAL, 4));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("livingrock0Stairs")),
            new AspectList().add(Aspect.EARTH, 1)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.SENSES, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("livingrock1Stairs")),
            new AspectList().add(Aspect.EARTH, 1)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.SENSES, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("livingwood0Stairs")),
            new AspectList().add(Aspect.TREE, 2)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.SENSES, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("livingwood1Stairs")),
            new AspectList().add(Aspect.TREE, 2)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.SENSES, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("livingrock0Slab")),
            new AspectList().add(Aspect.EARTH, 1)
                .add(Aspect.MAGIC, 2)
                .add(Aspect.SENSES, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("livingrock1Slab")),
            new AspectList().add(Aspect.EARTH, 1)
                .add(Aspect.MAGIC, 2)
                .add(Aspect.SENSES, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("livingwood0Slab")),
            new AspectList().add(Aspect.TREE, 1)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.SENSES, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("livingwood1Slab")),
            new AspectList().add(Aspect.TREE, 1)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.SENSES, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("dreamwood0Stairs")),
            new AspectList().add(Aspect.TREE, 3)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 2)
                .add(Aspect.MIND, 3)
                .add(Aspect.AURA, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("dreamwood1Stairs")),
            new AspectList().add(Aspect.TREE, 3)
                .add(Aspect.MAGIC, 5)
                .add(Aspect.SENSES, 2)
                .add(Aspect.MIND, 3)
                .add(Aspect.AURA, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("dreamwood0Slab")),
            new AspectList().add(Aspect.TREE, 2)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.SENSES, 1)
                .add(Aspect.MIND, 3)
                .add(Aspect.AURA, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("dreamwood1Slab")),
            new AspectList().add(Aspect.TREE, 2)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.SENSES, 1)
                .add(Aspect.MIND, 3)
                .add(Aspect.AURA, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.quartz),
            new AspectList().add(Aspect.ENERGY, 1)
                .add(Aspect.CRYSTAL, 1)
                .add(Aspect.MAGIC, 1)
                .add(Aspect.FIRE, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.quartz, 1, 2),
            new AspectList().add(Aspect.ENERGY, 2)
                .add(Aspect.CRYSTAL, 1)
                .add(Aspect.MAGIC, 1)
                .add(Aspect.FIRE, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.quartz, 1, 1),
            new AspectList().add(Aspect.ENERGY, 1)
                .add(Aspect.CRYSTAL, 1)
                .add(Aspect.MAGIC, 1)
                .add(Aspect.SENSES, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.quartz, 1, 3),
            new AspectList().add(Aspect.ENERGY, 1)
                .add(Aspect.CRYSTAL, 1)
                .add(Aspect.MAGIC, 1)
                .add(Aspect.PLANT, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.quartz, 1, 4),
            new AspectList().add(Aspect.ENERGY, 3)
                .add(Aspect.CRYSTAL, 1)
                .add(Aspect.MAGIC, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.quartz, 1, 5),
            new AspectList().add(Aspect.ENERGY, 3)
                .add(Aspect.CRYSTAL, 1)
                .add(Aspect.MAGIC, 1)
                .add(Aspect.AURA, 1));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModItems.manaResource, 1, 10),
            new AspectList().add(Aspect.WATER, 1)
                .add(Aspect.EARTH, 2)
                .add(Aspect.CRYSTAL, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.prismarine),
            new AspectList().add(Aspect.WATER, 4)
                .add(Aspect.EARTH, 8)
                .add(Aspect.CRYSTAL, 8));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.prismarine, 1, 2),
            new AspectList().add(Aspect.WATER, 4)
                .add(Aspect.EARTH, 8)
                .add(Aspect.CRYSTAL, 8));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.prismarine, 1, 3),
            new AspectList().add(Aspect.WATER, 4)
                .add(Aspect.EARTH, 8)
                .add(Aspect.CRYSTAL, 8)
                .add(Aspect.ENTROPY, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(ModBlocks.seaLamp),
            new AspectList().add(Aspect.WATER, 4)
                .add(Aspect.EARTH, 8)
                .add(Aspect.CRYSTAL, 8)
                .add(Aspect.ENTROPY, 2)
                .add(Aspect.LIGHT, 3));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("prismarine0Stairs")),
            new AspectList().add(Aspect.WATER, 3)
                .add(Aspect.EARTH, 6)
                .add(Aspect.CRYSTAL, 6));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("prismarine1Stairs")),
            new AspectList().add(Aspect.WATER, 3)
                .add(Aspect.EARTH, 6)
                .add(Aspect.CRYSTAL, 6));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("prismarine2Stairs")),
            new AspectList().add(Aspect.WATER, 3)
                .add(Aspect.EARTH, 6)
                .add(Aspect.CRYSTAL, 6)
                .add(Aspect.ENTROPY, 2));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("prismarine0Slab")),
            new AspectList().add(Aspect.WATER, 3)
                .add(Aspect.EARTH, 6)
                .add(Aspect.CRYSTAL, 6));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("prismarine1Slab")),
            new AspectList().add(Aspect.WATER, 3)
                .add(Aspect.EARTH, 6)
                .add(Aspect.CRYSTAL, 6));
        ThaumcraftEditorUtil.setItemAspects(
            new ItemStack(lookupItem("prismarine2Slab")),
            new AspectList().add(Aspect.WATER, 3)
                .add(Aspect.EARTH, 6)
                .add(Aspect.CRYSTAL, 6)
                .add(Aspect.ENTROPY, 2));
    }
}
