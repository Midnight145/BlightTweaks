package co.nidmight.blightcore.coremod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import co.nidmight.blightcore.coremod.asm.AWDisableChiselCompatEditor;
import co.nidmight.blightcore.coremod.asm.BlockOceanNodesEditor;
import co.nidmight.blightcore.coremod.asm.BlockTaintedBotaniaFlowerEditor;
import co.nidmight.blightcore.coremod.asm.BlockTaintedSandEditor;
import co.nidmight.blightcore.coremod.asm.IAsmEditor;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class BlightCoreCoremod implements IFMLLoadingPlugin {

    public static List<IAsmEditor> editors = new ArrayList<>();

    @Override
    public String[] getASMTransformerClass() {
        return new String[] { "net.technicpack.blightcore.coremod.BlightCoreClassTransformer" };
    }

    @Override
    public String getModContainerClass() {
        return "net.technicpack.blightcore.BlightCore";
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
    }

    @Override
    public String getAccessTransformerClass() {
        return "net.technicpack.blightcore.coremod.BlightCoreAccessTransformer";
    }
}
