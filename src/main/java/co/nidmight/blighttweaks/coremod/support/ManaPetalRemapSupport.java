package co.nidmight.blighttweaks.coremod.support;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;

import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.material.ItemManaPetal;

@SuppressWarnings("unused")
public class ManaPetalRemapSupport {

    // credit to
    // https://github.com/GTNewHorizons/Postea/blob/master/src/main/java/com/gtnewhorizons/postea/utility/ItemFixerUtility.java#L14

    public static void remapManaPetal(NBTTagCompound tag) {
        if (tag.hasNoTags()) {
            return;
        }
        if (tag.hasKey("id")) {
            short id = tag.getShort("id");
            Item item = Item.getItemById(id);
            if (item.getClass() == ItemManaPetal.class) {
                tag.setShort("id", (short) Item.getIdFromItem(ModItems.petal));
            }
        }

    }
}
