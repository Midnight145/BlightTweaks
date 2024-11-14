package co.nidmight.blighttweaks.mixins.late;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import WayofTime.alchemicalWizardry.api.soulNetwork.SoulNetworkHandler;
import WayofTime.alchemicalWizardry.common.items.EnergyItems;
import WayofTime.alchemicalWizardry.common.items.sigil.SigilAir;
import co.nidmight.blighttweaks.common.handlers.KeybindHandler;
import co.nidmight.blighttweaks.common.interfaces.IFlyingUpgrade;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

@Mixin(value = SigilAir.class)
public abstract class MixinSigilAir extends EnergyItems implements IFlyingUpgrade {

    @Unique
    private boolean blightCore$isEnabled = false;

    @Shadow
    public abstract ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer);

    @Inject(method = "<init>()V", at = @At(value = "TAIL"))
    public void MixinConstructor(CallbackInfo ci) {
        FMLCommonHandler.instance()
            .bus()
            .register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * @author Midnight
     * @reason Buff air sigil upgrade
     */
    @Overwrite(remap = false)
    public void onArmourUpdate(World world, EntityPlayer player, ItemStack thisItemStack) {
        player.fallDistance = 0;
        if (world.isRemote && blightCore$isEnabled) {
            if (player.capabilities.isFlying) {
                // we want aer sigil to be free since it already has an upkeep, so we do this
                SoulNetworkHandler.syphonFromNetwork(player.getCommandSenderName(), -this.getEnergyUsed());
                player.capabilities.isFlying = false;
                player.sendPlayerAbilities();
                this.onItemRightClick(thisItemStack, world, player);
            }
        }
    }

    @Unique
    @SubscribeEvent
    public void blightCore$canFly(LivingEvent.LivingUpdateEvent event) {
        if (event.entityLiving instanceof EntityPlayerMP) {
            IFlyingUpgrade.super.canFly(event);
        }
    }

    @Unique
    @SubscribeEvent
    public void blightCore$onKeyDown(InputEvent.KeyInputEvent event) {
        if (KeybindHandler.armorBoost.isPressed()) {
            blightCore$isEnabled = !blightCore$isEnabled;
            Minecraft.getMinecraft().thePlayer
                .addChatMessage(new ChatComponentText(blightCore$isEnabled ? "Boost enabled" : "Boost disabled"));
        }
    }
}
