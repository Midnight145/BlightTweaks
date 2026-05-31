package co.nidmight.blighttweaks.mixins.late;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import extracells.integration.Integration;
import extracells.util.UniversalTerminal$;

@Mixin(value = UniversalTerminal$.class, remap = false)
public class MixinUniversalTerminal$ {

    @Redirect(
        method = "<init>()V",
        at = @At(value = "INVOKE", target = "Lextracells/integration/Integration$Mods;isEnabled()Z"))
    private boolean blighttweaks$forceDisableUniversalTerminal(Integration.Mods instance) {
        return false;
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    public boolean isWirelessTerminal(ItemStack stack) {
        return false;
    }
}
