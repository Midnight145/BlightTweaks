package co.nidmight.blighttweaks.recipes.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

import co.nidmight.blighttweaks.BlightCore;
import cpw.mods.fml.common.registry.GameRegistry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;

public class ThaumcraftEditorUtil {

    private static HashSet<String> researchToRemove = new HashSet<>();

    public static void removeEntityAspects(String name) {
        List<ThaumcraftApi.EntityTags> tags = new ArrayList(ThaumcraftApi.scanEntities);
        for (ThaumcraftApi.EntityTags tag : tags) {
            if (tag.entityName == name && tag.nbts.length == 0) ThaumcraftApi.scanEntities.remove(tag);
        }
    }

    public static void addItemAspects(String modid, String item, int meta, AspectList aspects) {
        addItemAspects(new ItemStack(GameRegistry.findItem(modid, item), 1, meta), aspects);
    }

    public static void addItemAspects(String modid, String item, AspectList aspects) {
        addItemAspects(new ItemStack(GameRegistry.findItem(modid, item)), aspects);
    }

    public static void addItemAspects(ItemStack itemStack, AspectList aspects) {
        ThaumcraftApi.registerComplexObjectTag(itemStack, aspects);
    }

    public static void setItemAspects(String modid, String item, int meta, AspectList aspects) {
        setItemAspects(new ItemStack(GameRegistry.findItem(modid, item), 1, meta), aspects);
    }

    public static void setItemAspects(String modid, String item, AspectList aspects) {
        setItemAspects(GameRegistry.findItem(modid, item), aspects);
    }

    public static void setItemAspects(Item item, AspectList aspects) {
        setItemAspects(new ItemStack(item), aspects);
    }

    public static void setItemAspects(ItemStack stack, AspectList aspects) {
        ThaumcraftApi.registerObjectTag(stack, aspects);
    }

    public static Function<Object, ItemStack> IArcaneRecipeOutputExtractor = obj -> {
        try {
            if (obj instanceof IArcaneRecipe recipe) {
                return recipe.getRecipeOutput();
            }
        } catch (Exception e) {
            BlightCore.logger.error(e.getMessage(), e);
        }
        return null;
    };

    public static Function<Object, ItemStack> CrucibleRecipeExtractor = obj -> {
        try {
            if (obj instanceof CrucibleRecipe recipe) {
                return recipe.getRecipeOutput();
            }
        } catch (Exception e) {
            BlightCore.logger.error(e.getMessage(), e);
        }
        return null;
    };

    public static boolean removeThaumResearch(String researchKey) {
        researchToRemove.add(researchKey);
        return true;
    }

    public static boolean removeArcaneRecipeByOutput(ItemStack output) {
        return PredicateUtil.removeItemsFromList(
            ThaumcraftApi.getCraftingRecipes(),
            PredicateUtil.isAnyInstanceOf(IArcaneRecipe.class),
            PredicateUtil.compareItemAndMeta(output, IArcaneRecipeOutputExtractor));
    }

    public static boolean removeCrucibleRecipeByOutput(ItemStack output) {
        return PredicateUtil.removeItemsFromList(
            ThaumcraftApi.getCraftingRecipes(),
            PredicateUtil.isAnyInstanceOf(CrucibleRecipe.class),
            PredicateUtil.compareItemAndMeta(output, CrucibleRecipeExtractor));
    }

    public static void removeArcaneRecipeByOutput(Item output) {
        removeArcaneRecipeByOutput(new ItemStack(output, 1, OreDictionary.WILDCARD_VALUE));
    }

    public static void removeArcaneRecipeByOutput(Block output) {
        removeArcaneRecipeByOutput(new ItemStack(output, 1, OreDictionary.WILDCARD_VALUE));
    }

    public static void addResearchPage(String researchKey, ResearchPage page) {
        ResearchItem item = ResearchCategories.getResearch(researchKey);
        ResearchPage[] currentPages = item.getPages();
        List<ResearchPage> pages = new ArrayList<>();
        if (currentPages != null && currentPages.length > 0) {
            pages.addAll(Arrays.asList(currentPages));
        }
        pages.add(page);
        item.setPages(pages.toArray(new ResearchPage[0]));
    }

    public static ItemStack getManaBean(Aspect aspect, int amount) {
        Item manaBean = ConfigItems.itemManaBean;
        ItemStack stack = new ItemStack(manaBean);
        NBTTagCompound tag = new NBTTagCompound();
        AspectList aspectList = new AspectList().add(aspect, amount);
        aspectList.writeToNBT(tag);
        stack.setTagCompound(tag);
        return stack;
    }

    public static AspectList getAspectsFromManaBean(ItemStack manaBean) {
        if (manaBean.getItem() != ConfigItems.itemManaBean || manaBean.getTagCompound() == null) {
            return new AspectList();
        }
        AspectList aspectList = new AspectList();
        aspectList.readFromNBT(manaBean.getTagCompound());
        return aspectList;
    }

    private static String[] getSafeArray(String[] array) {
        return array != null ? array : new String[0];
    }

    public static void applyRemove() {
        for (String string : ThaumcraftEditorUtil.researchToRemove) {
            ResearchItem item = ResearchCategories.getResearch(string);
            item.setParents();
            item.setParentsHidden();
            item.setSiblings();
            ResearchCategories.researchCategories.get(item.category).research.remove(string);
        }

        ResearchCategories.researchCategories.values()
            .forEach(
                category -> category.research.values()
                    .forEach(entry -> {
                        try {
                            entry.siblings = Arrays.stream(getSafeArray(entry.siblings))
                                .filter(sibling -> !researchToRemove.contains(sibling))
                                .toArray(String[]::new);
                            entry.parents = Arrays.stream(getSafeArray(entry.parents))
                                .filter(parent -> !researchToRemove.contains(parent))
                                .toArray(String[]::new);
                            entry.parentsHidden = Arrays.stream(getSafeArray(entry.parentsHidden))
                                .filter(parent -> !researchToRemove.contains(parent))
                                .toArray(String[]::new);
                        } catch (Exception e) {
                            BlightCore.logger
                                .error("Failed to update research entry {} after research removal", entry.key, e);
                        }
                    }));
    }
}
