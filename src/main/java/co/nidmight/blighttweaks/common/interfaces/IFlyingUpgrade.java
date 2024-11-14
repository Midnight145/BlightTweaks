package co.nidmight.blighttweaks.common.interfaces;

import java.util.HashSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;

import WayofTime.alchemicalWizardry.common.items.armour.BoundArmour;

public interface IFlyingUpgrade {

    HashSet<String> flyingPlayers = new HashSet<>();

    default boolean shouldFly(EntityPlayer player) {
        for (int i = 0; i < 4; i++) {
            ItemStack stack = player.getCurrentArmor(i);
            if (stack == null) {
                return false;
            }
            Item item = stack.getItem();
            if (item instanceof BoundArmour armor) {
                for (ItemStack is : armor.getInternalInventory(stack)) {
                    if (is == null) {
                        continue;
                    }
                    if (this.getClass()
                        .isInstance(is.getItem())) {
                        return true;
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }

    default void canFly(LivingEvent.LivingUpdateEvent event) {
        if (event.entity.worldObj.isRemote) {
            return;
        }
        EntityPlayerMP player = (EntityPlayerMP) event.entityLiving;
        if (this.shouldFly(player)) {
            if (!flyingPlayers.contains(player.getDisplayName())) {
                flyingPlayers.add(player.getDisplayName());

                player.capabilities.allowFlying = true;
                player.sendPlayerAbilities();
            }
        } else {
            if (flyingPlayers.contains(player.getDisplayName())) {
                flyingPlayers.remove(player.getDisplayName());
                if (!player.capabilities.isCreativeMode) {
                    player.capabilities.allowFlying = false;
                    player.capabilities.isFlying = false;
                    player.sendPlayerAbilities();
                }
            }
        }
    }
}
