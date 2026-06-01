package co.nidmight.blighttweaks.recipes.helpers;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;

import cpw.mods.fml.client.FMLClientHandler;

public class LocalizationUtil implements IResourceManagerReloadListener {



    // private static Map<String, String> translations = new HashMap<>();
    private static Map<String, Map<String, String>> translations = new HashMap<>();


    public LocalizationUtil() {
        if (Minecraft.getMinecraft()
            .getResourceManager() instanceof IReloadableResourceManager handler) {
            handler.registerReloadListener(this);
        }
    }

    public static void setLocalization(String key, String value) {
        LocalizationUtil.setLocalization(null, key, value);
    }

    public static void setLocalization(String lang, String key, String value) {

//        Map lang_map = CachedR.of(instance)
//            .get(ObfInfo.LANGUAGE_LIST, Map.class);
//        lang_map.put(key, value);
        StatCollector.localizedName.languageList.put(key, value);
        translations.computeIfAbsent(lang, k -> new HashMap<>())
            .put(key, value);
    }

    @Override
    public void onResourceManagerReload(IResourceManager p_110549_1_) {
        CachedR.invalidate(); // force-invalidate cache to ensure we get the latest language list

        for (Map.Entry<String, Map<String, String>> langEntry : translations.entrySet()) {
            String lang = langEntry.getKey();
            if (lang == null || lang.equals(
                FMLClientHandler.instance()
                    .getCurrentLanguage())) {
                Map<String, String> langTranslations = langEntry.getValue();
                for (Map.Entry<String, String> entry : langTranslations.entrySet()) {
                    StatCollector.localizedName.languageList.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
