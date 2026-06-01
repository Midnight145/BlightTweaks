package co.nidmight.blighttweaks.recipes.helpers;

import co.nidmight.blighttweaks.recipes.framework.Priority;

public interface IGameEditor {

    void apply();

    Priority getPriority();
}
