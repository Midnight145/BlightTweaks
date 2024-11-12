package co.nidmight.blighttweaks;

import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

import co.nidmight.blighttweaks.mixins.Mixins;

@LateMixin
public class BlightCoreLateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.blighttweaks.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        return Mixins.getLateMixins(loadedMods);
    }
}
