package co.nidmight.blighttweaks.coremod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.EventBus;

import co.nidmight.blighttweaks.BTStrings;
import co.nidmight.blighttweaks.coremod.asm.AWDisableChiselCompatEditor;
import co.nidmight.blighttweaks.coremod.asm.BlockOceanNodesEditor;
import co.nidmight.blighttweaks.coremod.asm.BlockTaintedBotaniaFlowerEditor;
import co.nidmight.blighttweaks.coremod.asm.BlockTaintedSandEditor;
import co.nidmight.blighttweaks.coremod.asm.IAsmEditor;
import co.nidmight.blighttweaks.coremod.asm.ItemStackManaPetalEditor;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class BlightCoreCoremod extends DummyModContainer implements IFMLLoadingPlugin {

    public BlightCoreCoremod() {
        super(new ModMetadata());

        ModMetadata metadata = this.getMetadata();
        metadata.modId = BTStrings.MOD_ID + "_core";
        metadata.version = BTStrings.VERSION;
        metadata.name = BTStrings.MOD_NAME + "_core";
        metadata.authorList = ImmutableList.of("Cannibalvox, Midnight");
        metadata.url = "http://www.technicpack.net/";
        metadata.credits = "Developed by Technic";
        metadata.description = "It's a coremod.  For blightfall!";
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }

    public static List<IAsmEditor> editors = new ArrayList<>();

    @Override
    public String[] getASMTransformerClass() {
        return new String[] { "co.nidmight.blighttweaks.coremod.BlightCoreClassTransformer" };
    }

    @Override
    public String getModContainerClass() {
        return "co.nidmight.blighttweaks.coremod.BlightCoreCoremod";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        boolean isObfuscated = (Boolean) data.get("runtimeDeobfuscationEnabled");
        editors.add(new BlockOceanNodesEditor());
        editors.add(new BlockTaintedSandEditor(isObfuscated));
        editors.add(new BlockTaintedBotaniaFlowerEditor());
        editors.add(new AWDisableChiselCompatEditor());
        editors.add(new ItemStackManaPetalEditor(isObfuscated));
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

}
