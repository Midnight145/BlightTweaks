package co.nidmight.blighttweaks.mixins;

import cpw.mods.fml.common.Mod;

// Code here adapted from
// https://github.com/GTNewHorizons/Hodgepodge/blob/master/src/main/java/com/mitchej123/hodgepodge/mixins/TargetedMod.java
// and therefore under the LGPL-3.0 license.

public enum TargetedMod {

    VANILLA("Minecraft", null),
    CHISEL("Chisel", "chisel"),
    BLOODMAGIC("AlchemicalWizardry", "AWWayofTime"),;

    /** The "name" in the {@link Mod @Mod} annotation */
    public final String modName;
    /** Class that implements the IFMLLoadingPlugin interface */
    public final String coreModClass;
    /** The "modid" in the {@link Mod @Mod} annotation */
    public final String modId;

    TargetedMod(String modName, String coreModClass) {
        this(modName, coreModClass, null);
    }

    TargetedMod(String modName, String coreModClass, String modId) {
        this.modName = modName;
        this.coreModClass = coreModClass;
        this.modId = modId;
    }

    @Override
    public String toString() {
        return "TargetedMod{modName='" + modName + "', coreModClass='" + coreModClass + "', modId='" + modId + "'}";
    }
}
