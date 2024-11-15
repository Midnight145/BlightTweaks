package co.nidmight.blighttweaks.mixins.late;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import WayofTime.alchemicalWizardry.common.items.EnergyItems;
import WayofTime.alchemicalWizardry.common.items.sigil.SigilAir;
import co.nidmight.blighttweaks.common.handlers.KeybindHandler;
import co.nidmight.blighttweaks.common.interfaces.IFlyingUpgrade;
import co.nidmight.blighttweaks.common.network.handler.ArmorBoostPacketHandler;

@SuppressWarnings("UnusedMixin")
@Mixin(value = SigilAir.class)
public abstract class MixinSigilAir extends EnergyItems implements IFlyingUpgrade {

    @Shadow
    public abstract ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer);

    /**
     * @author Midnight
     * @reason Buff air sigil upgrade
     */
    @Overwrite(remap = false)
    public void onArmourUpdate(World world, EntityPlayer player, ItemStack thisItemStack) {
        player.fallDistance = 0;
        this.canFly(player);

        if (!world.isRemote) {
            if (!ArmorBoostPacketHandler.enabledPlayers.containsKey(player.getCommandSenderName())) {
                ArmorBoostPacketHandler.enabledPlayers.put(player.getCommandSenderName(), false);
                return;
            }
        }
        if (blightCore$checkShouldBoost(player, world.isRemote)) {
            if (player.capabilities.isFlying) {
                player.capabilities.isFlying = false;
                this.onItemRightClick(thisItemStack, world, player);
                player.sendPlayerAbilities();
            }
        }
    }

    @Unique
    private boolean blightCore$checkShouldBoost(EntityPlayer player, boolean isRemote) {
        return isRemote ? KeybindHandler.isBoostEnabled
            : ArmorBoostPacketHandler.enabledPlayers.get(player.getCommandSenderName());
    }
}
