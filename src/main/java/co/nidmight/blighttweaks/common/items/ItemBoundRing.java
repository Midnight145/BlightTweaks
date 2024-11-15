package co.nidmight.blighttweaks.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import com.rwtema.extrautils.item.ItemAngelRing;
import com.rwtema.extrautils.network.NetworkHandler;
import com.rwtema.extrautils.network.packets.PacketAngelRingNotifier;

import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import WayofTime.alchemicalWizardry.api.items.interfaces.ArmourUpgrade;
import co.nidmight.blighttweaks.BTStrings;
import co.nidmight.blighttweaks.common.interfaces.IFlyingUpgrade;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemBoundRing extends ItemAngelRing implements ArmourUpgrade, IFlyingUpgrade {

    public int wingType = -1;
    boolean sentPacket = false;

    public ItemBoundRing() {
        this.setUnlocalizedName(BTStrings.MOD_ID + "_" + BTStrings.boundRingName);
        GameRegistry.registerItem(this, BTStrings.boundRingName);
        this.setCreativeTab(AlchemicalWizardry.tabBloodMagic);
        this.setTextureName(BTStrings.MOD_ID + ":" + BTStrings.boundRingName);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onArmourUpdate(World world, EntityPlayer player, ItemStack thisItemStack) {
        if (!world.isRemote) {
            if (!this.sentPacket) {
                this.sendPacket(player.getDisplayName(), this.wingType);
                this.sentPacket = true;
            }
        }
        if (world.isRemote) {
            if (this.wingType == -1) {
                this.wingType = thisItemStack.getItemDamage();
            }
            if (!(flyingPlayers.contains(player.getDisplayName())) && this.shouldFly(player)) {

                player.capabilities.allowFlying = true;
                player.sendPlayerAbilities();
                flyingPlayers.add(player.getDisplayName());
            }
        }
    }

    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean par5) {
        super.onUpdate(itemstack, world, entity, slot, par5);
        if (this.wingType == -1) {
            this.wingType = itemstack.getItemDamage();
        }
    }

    @Override
    public boolean isUpgrade() {
        return true;
    }

    @Override
    public int getEnergyForTenSeconds() {
        return 1000;
    }

    @SubscribeEvent
    public void canFly(LivingUpdateEvent event) {
        if (event.entityLiving instanceof EntityPlayerMP player) {
            managePacket(player);
            IFlyingUpgrade.super.canFly(player);
        }
    }

    private void managePacket(EntityPlayerMP player) {
        if (this.shouldFly(player)) {
            if (!this.sentPacket) {
                this.sendPacket(player.getDisplayName(), this.wingType);
                this.sentPacket = true;
            }
        } else {
            if (flyingPlayers.contains(player.getDisplayName())) {
                this.sendPacket(player.getDisplayName(), 0);
                this.sentPacket = false;
            }
        }
    }

    private void sendPacket(String playerName, int type) {
        NetworkHandler.sendToAllPlayers(new PacketAngelRingNotifier(playerName, type));
    }
}
