package co.nidmight.blighttweaks.recipes.helpers;

import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;

import co.nidmight.blighttweaks.coremod.BlightCoreCoremod;

public enum ObfInfo {

//    LOCALIZED_NAME("localizedName", "field_74839_a", StatCollector.class),
//    LANGUAGE_LIST("languageList", "field_74816_c", StringTranslate.class),
//    SMELTING_LIST("smeltingList", "field_77604_b", FurnaceRecipes.class),

    ;

    String obfName;
    String deobfName;
    Class<?> parent;

    ObfInfo(String deobfName, String obfName, Class<?> parent) {
        this.obfName = obfName;
        this.deobfName = deobfName;
        this.parent = parent;
    }

    public String getName() {
        return BlightCoreCoremod.isObfuscatedEnvironment() ? this.obfName : this.deobfName;
    }
}
