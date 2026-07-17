package co.nidmight.blighttweaks.recipes.helpers;

import net.minecraft.item.ItemStack;

import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconCategory;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.api.lexicon.LexiconPage;
import vazkii.botania.api.recipe.RecipeManaInfusion;

public class BotaniaEditorUtil {

    public static LexiconEntry lookupEntry(String name) {
        return BotaniaAPI.getAllEntries()
            .stream()
            .filter(
                entry -> entry.getUnlocalizedName()
                    .equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }

    public static void removeEntry(String name) {
        LexiconEntry entry = lookupEntry(name);
        BotaniaAPI.getAllEntries()
            .remove(entry);
    }

    public static void addEntry(String entryName, LexiconCategory category, ItemStack icon, LexiconPage... pages) {
        LexiconEntry newEntry = new LexiconEntry(entryName, category);
        newEntry.setIcon(icon);
        for (LexiconPage page : pages) {
            newEntry.addPage(page);
        }
        BotaniaAPI.addEntry(newEntry, category);
    }

    public static void removePage(String entryName, int pageIndex) {
        LexiconEntry entry = lookupEntry(entryName);
        if (entry.pages.size() > pageIndex) {
            entry.pages.remove(pageIndex);
        }
    }

    public static void addPage(String entryName, LexiconPage page, int index) {
        LexiconEntry entry = lookupEntry(entryName);
        entry.pages.add(index, page);
    }

    public static void replacePage(String entryName, LexiconPage page, int index) {
        LexiconEntry entry = lookupEntry(entryName);
        if (entry.pages.size() > index) {
            entry.pages.set(index, page);
        }
    }

    public static void removeManaRecipeByOutput(ItemStack output) {
        PredicateUtil.removeItemsFromList(
            BotaniaAPI.manaInfusionRecipes,
            PredicateUtil.compareItemAndMeta(
                output,
                obj -> obj instanceof RecipeManaInfusion recipe ? recipe.getOutput() : null));
    }
}
