package co.nidmight.blighttweaks.common.proxy;

import co.nidmight.blighttweaks.common.handlers.KeybindHandler;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {

    public void init() {
        super.init();
        FMLCommonHandler.instance()
            .bus()
            .register(new KeybindHandler());
    }

}
