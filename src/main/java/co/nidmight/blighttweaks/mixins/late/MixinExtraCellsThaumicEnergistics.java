package co.nidmight.blighttweaks.mixins.late;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import extracells.integration.thaumaticenergistics.ThaumaticEnergistics$;

@Mixin(value = ThaumaticEnergistics$.class, remap = false)
public class MixinExtraCellsThaumicEnergistics {

    /**
     * @author Midnight145
     * @reason extracells is finally breaking, fml
     */
    @Overwrite
    public ItemStack getWirelessTerminal() {
        return null;
    }

    /**
     * @author Midnight145
     * @reason extracells is finally breaking, fml
     */
    @Overwrite
    public void openEssentiaTerminal(EntityPlayer var0, Object var1) {}
}
