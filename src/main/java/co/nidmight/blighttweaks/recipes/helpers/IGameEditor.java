package co.nidmight.blighttweaks.recipes.helpers;

public interface IGameEditor {

    void apply();

    default Priority getPriority() {
        return Priority.NORMAL;
    }
}
