package co.nidmight.blighttweaks.recipes.framework;

/**
 * Base class for representing a recipe edit operation.
 * This class is designed to be extended by specific types of recipe edits,
 * such as adding, removing, or modifying recipes.<br>
 * Each edit has a description and an indication of whether it can be undone.
 * Can be used to group multiple edits together, but it should be used for a single logical edit operation.
 */
public class RecipeEdit {

    private final String description;
    private final boolean undoable;

    public RecipeEdit(String description, boolean undoable) {
        this.description = description;
        this.undoable = undoable;
    }

    public boolean apply() {
        throw new UnsupportedOperationException("This method should be overridden by subclasses");
    }

    public boolean undo() {
        if (!undoable) {
            throw new UnsupportedOperationException("This edit is not undoable");
        }
        return true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUndoable() {
        return undoable;
    }
}
