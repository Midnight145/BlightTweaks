package co.nidmight.blighttweaks.mixins.late;

import net.minecraft.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import noppes.npcs.entity.EntityNPCInterface;
import powercrystals.minefactoryreloaded.tile.machine.TileEntityAutoSpawner;

@Mixin(value = TileEntityAutoSpawner.class, remap = false)
public class MixinAutoSpawner {

    @Shadow
    protected Entity _spawn;

    @WrapOperation(
        method = "activateMachine",
        at = @At(
            value = "FIELD",
            target = "Lpowercrystals/minefactoryreloaded/tile/machine/TileEntityAutoSpawner;_spawnExact:Z"))
    private boolean blighttweaks$forceSpawnExactCustomNpcs(TileEntityAutoSpawner instance,
        Operation<Boolean> original) {
        return _spawn instanceof EntityNPCInterface || original.call(instance);
    }
}
