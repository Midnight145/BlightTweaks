package co.nidmight.blighttweaks.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import co.nidmight.blighttweaks.BTStrings;
import cpw.mods.fml.common.registry.GameRegistry;
import thaumcraft.api.crafting.IInfusionStabiliser;

public class BlockChiseledBloodstoneBricks extends Block implements IInfusionStabiliser {

    public BlockChiseledBloodstoneBricks() {
        super(Material.ground);
        this.setHardness((float) 1.5);
        this.setResistance(6);
        this.setHarvestLevel("pickaxe", 0);
        this.setBlockTextureName("blighttweaks:chiseledBloodstoneBricks");
        this.setBlockName(BTStrings.MOD_ID + "_" + BTStrings.chiseledBloodstoneBricksName);
        this.setCreativeTab(AlchemicalWizardry.tabBloodMagic);
        GameRegistry.registerBlock(this, BTStrings.chiseledBloodstoneBricksName);
    }

    public boolean canStabaliseInfusion(World w, int x, int y, int z) {
        return true;
    }
}
