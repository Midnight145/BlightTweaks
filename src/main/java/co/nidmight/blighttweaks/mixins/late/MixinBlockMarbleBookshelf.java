package co.nidmight.blighttweaks.mixins.late;

import org.spongepowered.asm.mixin.Mixin;

import info.jbcs.minecraft.chisel.block.BlockCarvable;
import info.jbcs.minecraft.chisel.block.BlockMarbleBookshelf;

@Mixin(BlockMarbleBookshelf.class)
public class MixinBlockMarbleBookshelf extends BlockCarvable {

    @Override
    public int damageDropped(int meta) {
        return 0;
    }

}
