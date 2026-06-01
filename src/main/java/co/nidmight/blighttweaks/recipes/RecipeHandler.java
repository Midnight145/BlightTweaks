package co.nidmight.blighttweaks.recipes;

import java.util.ArrayList;
import java.util.List;

import co.nidmight.blighttweaks.recipes.additions.thaumcraft.MiscResearch;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.localization.DisplayNameFixes;
import co.nidmight.blighttweaks.recipes.removals.DisabledItems;
import co.nidmight.blighttweaks.recipes.removals.ExecutiveMandate2625B;
import co.nidmight.blighttweaks.recipes.removals.HarvestCraftRemovals;
import co.nidmight.blighttweaks.recipes.removals.RemovedResearch;
import co.nidmight.blighttweaks.recipes.tweaks.Foodstuffs;
import co.nidmight.blighttweaks.recipes.tweaks.MiscTweaks;

public class RecipeHandler {

    private final List<IGameEditor> editors;

    private static RecipeHandler instance;

    public RecipeHandler() {
        if (instance != null) {
            throw new IllegalStateException("RecipeHandler instance already exists!");
        }
        instance = this;
        this.editors = new ArrayList<>();
    }

    private void addEditor(IGameEditor editor) {
        instance.editors.add(editor);
    }

    public void build() {
        this.addEditor(new HarvestCraftRemovals());
        this.addEditor(new ExecutiveMandate2625B());
        this.addEditor(new RemovedResearch());
        this.addEditor(new DisabledItems());
        this.addEditor(new Foodstuffs());
        this.addEditor(new DisplayNameFixes());
        this.addEditor(new MiscTweaks());
        this.addEditor(new MiscResearch());
    }

    public void applyEditors() {
        editors.sort(
            (e1, e2) -> Integer.compare(
                e2.getPriority()
                    .getValue(),
                e1.getPriority()
                    .getValue()));
        for (IGameEditor editor : editors) {
            editor.apply();
        }
    }
}
