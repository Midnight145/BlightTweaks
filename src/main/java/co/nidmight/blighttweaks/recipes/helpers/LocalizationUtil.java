package co.nidmight.blighttweaks.recipes.helpers;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;

import co.nidmight.blighttweaks.BlightCore;
import cpw.mods.fml.client.FMLClientHandler;

@SuppressWarnings({"rawtypes", "unchecked"})
public class LocalizationUtil implements IResourceManagerReloadListener {
    private static final Map<String, Map<String, String>> translations = new HashMap<>();

    private static final Map languageMap;

    static {
        try {
            // why the FUCK won't my access transformer work
            Field languageListField = StringTranslate.class.getDeclaredField(ObfInfo.LANGUAGE_LIST.getName());
            languageListField.setAccessible(true);
            languageMap = (Map) languageListField.get(StatCollector.localizedName);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        new LocalizationUtil();
    }

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
        BlightCore.logger.info("Setting localization for key '{}' to value '{}' for language '{}'", key, value, lang);
        languageMap.put(key, value);
        translations.computeIfAbsent(lang, k -> new HashMap<>())
            .put(key, value);
    }

    @Override
    public void onResourceManagerReload(IResourceManager p_110549_1_) {
        for (Map.Entry<String, Map<String, String>> langEntry : translations.entrySet()) {
            String lang = langEntry.getKey();
            if (lang == null || lang.equals(
                FMLClientHandler.instance()
                    .getCurrentLanguage())) {
                Map<String, String> langTranslations = langEntry.getValue();
                languageMap.putAll(langTranslations);
            }
        }
    }
}
