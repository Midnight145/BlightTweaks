package co.nidmight.blighttweaks.common.proxy;

import co.nidmight.blighttweaks.common.compat.UBCIntegration;
import co.nidmight.blighttweaks.common.handlers.ChunkHandler;
import co.nidmight.blighttweaks.common.handlers.FoodHandler;
import co.nidmight.blighttweaks.common.handlers.InteractHandler;

public class CommonProxy {

    public void init() {
        new FoodHandler();
        new InteractHandler();
        new ChunkHandler();
    }

    public void preinit() {
        UBCIntegration.register();
    }
}
