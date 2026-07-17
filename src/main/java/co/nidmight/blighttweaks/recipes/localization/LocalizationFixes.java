package co.nidmight.blighttweaks.recipes.localization;

import co.nidmight.blighttweaks.recipes.helpers.Priority;
import co.nidmight.blighttweaks.recipes.helpers.IGameEditor;
import co.nidmight.blighttweaks.recipes.helpers.LocalizationUtil;

public class LocalizationFixes implements IGameEditor {

    @Override
    public void apply() {
        LocalizationUtil.setLocalization("tile.tmechworks.meshFilter.name", "Mesh Filter");
        LocalizationUtil.setLocalization("tile.cookingbook:toaster.name", "Toaster");
        LocalizationUtil.setLocalization("entity.ItemFrame.name", "Item Frame");
        LocalizationUtil.setLocalization("Open Crate.name", "Open Crate");

        LocalizationUtil.setLocalization("tile.dirt.name", "Dirt");
        LocalizationUtil.setLocalization("tile.sand.name", "Sand");

        LocalizationUtil.setLocalization("Iron Bars.name", "Iron Bars");
        LocalizationUtil.setLocalization("Glass Pane.name", "Glass Pane");
        LocalizationUtil.setLocalization("tile.sink.name", "Sink");

        // Smeltery quartz
        LocalizationUtil.setLocalization("gui.smeltery.quartz", "Quartz: ");

        // Boat seat localization for thaumometer
        LocalizationUtil.setLocalization("entity.etfuturum.new_boat_seat.name", "Boat");

        // Armor stand localization
        LocalizationUtil.setLocalization("entity.etfuturum.wooden_armorstand.name", "Armor Stand");
        LocalizationUtil.setLocalization("item.etfuturum.armor_stand.name", "Armor Stand");

        // "Apprentices" Ring fix
        LocalizationUtil.setLocalization("item.ItemBaubleBlanks.3.name", "Apprentice's Ring of %TYPE");
    }

    @Override
    public Priority getPriority() {
        return Priority.LOWEST;
    }
}
