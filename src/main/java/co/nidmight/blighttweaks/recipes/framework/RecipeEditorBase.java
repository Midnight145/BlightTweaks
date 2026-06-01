package co.nidmight.blighttweaks.recipes.framework;

import java.util.ArrayList;
import java.util.List;

import co.nidmight.blighttweaks.BlightCore;

public class RecipeEditorBase {

    protected Priority priority = Priority.NORMAL;

    protected boolean undoable = false;
    protected List<RecipeEdit> edits = new ArrayList<>();

    public RecipeEditorBase() {

    }

    public void apply() {
        List<RecipeEdit> failedEdits = new ArrayList<>();
        List<RecipeEdit> successfulEdits = new ArrayList<>();
        for (RecipeEdit edit : edits) {
            if (!edit.apply()) {
                failedEdits.add(edit);
                continue;
            }
            successfulEdits.add(edit);
        }
        if (!failedEdits.isEmpty()) {
            BlightCore.logger.error("Failed to apply recipe edits: {}", failedEdits);
        }
        BlightCore.logger.info("Applied {} recipe edits", successfulEdits.size());
    }

    public Priority getPriority() {
        return priority;
    }
}
