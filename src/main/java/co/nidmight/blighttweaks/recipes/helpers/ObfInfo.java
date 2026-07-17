package co.nidmight.blighttweaks.recipes.helpers;

import net.minecraft.util.StringTranslate;

import co.nidmight.blighttweaks.coremod.BlightCoreCoremod;

public enum ObfInfo {
    LANGUAGE_LIST("languageList", "field_74816_c", StringTranslate.class),

    ;

    final String obfName;
    final String deobfName;
    final Class<?> parent;

    ObfInfo(String deobfName, String obfName, Class<?> parent) {
        this.obfName = obfName;
        this.deobfName = deobfName;
        this.parent = parent;
    }

    public String getName() {
        return BlightCoreCoremod.isObfuscatedEnvironment() ? this.obfName : this.deobfName;
    }
}
