package co.nidmight.blighttweaks.common.items;

import net.minecraft.item.Item;

public class Items {

    public static Item boundRing;
    public static Item alienTome;
    public static Item worldOreKiller;

    public static void init() {
        boundRing = new ItemBoundRing();
        alienTome = new ItemAlienTome();
        worldOreKiller = new ItemWorldOreKiller();
    }
}
