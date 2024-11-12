package co.nidmight.blighttweaks.common.compat;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import com.rwtema.extrautils.core.Tuple;

import co.nidmight.blighttweaks.BlightCore;
import exterminatorJeff.undergroundBiomes.api.UBAPIHook;

public class UBCIntegration {

    private static final HashMap<String, Tuple<Block, Integer>> registry = new HashMap<>();
    static {
        // texture name + lang entry, block, mining level
        registry.put("quartz", new Tuple<>(Blocks.quartz_ore, 2));
    }

    public static void register() {
        for (String string : registry.keySet()) {
            if (!registerBlock(string)) {
                throw new RuntimeException("Failed to register block " + string);
            }
        }
    }

    public static boolean registerBlock(String string) {
        try {
            BlightCore.logger.info("UBC Integration: Attempting to Register Block: {}", string);
            Tuple<Block, Integer> blockInfo = registry.get(string);
            Block block = blockInfo.getA();
            block.setHarvestLevel("pickaxe", blockInfo.getB());
            UBAPIHook.ubAPIHook.ubOreTexturizer
                .requestUBOreSetup(block, 0, "blighttweaks:" + string, "ubc.blighttweaks." + string);
            BlightCore.logger.info("Successfully Registered Block: {}", string);
            return true;
        } catch (Exception e) {
            BlightCore.logger.error("Failed to register {}: {}", string, e);
            return false;
        }
    }
}
