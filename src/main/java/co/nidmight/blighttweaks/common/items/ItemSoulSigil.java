package co.nidmight.blighttweaks.common.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import WayofTime.alchemicalWizardry.api.items.interfaces.ArmourUpgrade;
import WayofTime.alchemicalWizardry.api.items.interfaces.ISigil;
import WayofTime.alchemicalWizardry.common.items.EnergyItems;
import co.nidmight.blighttweaks.BTStrings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSoulSigil extends EnergyItems implements ISigil, ArmourUpgrade {

    public final int cost = 5000;
    private final int armorCost = 10000;
    private IIcon activeIcon;
    private IIcon passiveIcon;

    public ItemSoulSigil() {
        super();
        this.setUnlocalizedName(BTStrings.MOD_ID + "_" + BTStrings.soulSigilName);
        GameRegistry.registerItem(this, BTStrings.soulSigilName);
        this.setCreativeTab(AlchemicalWizardry.tabBloodMagic);
        setEnergyUsed(cost);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> info, boolean par4) {
        info.add(StatCollector.translateToLocal("tooltip.soulsigil.desc"));

        if (!(stack.getTagCompound() == null)) {
            if (stack.getTagCompound()
                .getBoolean("isActive")) {
                info.add(StatCollector.translateToLocal("tooltip.sigil.state.activated"));
            } else {
                info.add(StatCollector.translateToLocal("tooltip.sigil.state.deactivated"));
            }
            info.add(
                "Current Owner: " + stack.getTagCompound()
                    .getString("ownerName"));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("blighttweaks:soulSigil_deactivated");
        this.activeIcon = iconRegister.registerIcon("blighttweaks:soulSigil_activated");
        this.passiveIcon = iconRegister.registerIcon("blighttweaks:soulSigil_deactivated");
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }

        NBTTagCompound tag = stack.getTagCompound();

        if (tag.getBoolean("isActive")) {
            return this.activeIcon;
        } else {
            return this.passiveIcon;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        if (par1 == 1) {
            return this.activeIcon;
        } else {
            return this.passiveIcon;
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!EnergyItems.checkAndSetItemOwner(stack, player) || player.isSneaking()) {
            return stack;
        }
        boolean isActive = stack.getTagCompound()
            .getBoolean("isActive");
        isActive = !isActive;
        stack.getTagCompound()
            .setBoolean("isActive", isActive);
        if (isActive) {
            stack.getTagCompound()
                .setInteger("worldTimeDelay", (int) (world.getWorldTime() - 1) % 200);
            stack.setItemDamage(1);
        } else {
            stack.setItemDamage(0);
        }

        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!(entity instanceof EntityPlayer player) || stack.getTagCompound() == null) {
            return;
        }
        if (world.getWorldTime() % 200 == stack.getTagCompound()
            .getInteger("worldTimeDelay") && stack.getTagCompound()
                .getBoolean("isActive")) {
            if (!player.capabilities.isCreativeMode) {
                if (!EnergyItems.syphonBatteries(stack, player, getEnergyUsed())) {
                    // stack.getTagCompound()
                    // .setBoolean("isActive", false);
                    player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1, 1));
                }
            }
        }
        if (stack.getTagCompound()
            .getBoolean("isActive")) {
            player.addPotionEffect(new PotionEffect(AlchemicalWizardry.customPotionSoulHardenID, 1, 3));
        }
    }

    @Override
    public void onArmourUpdate(World world, EntityPlayer player, ItemStack stack) {
        if (world.getWorldTime() % 200 == 0) {
            EnergyItems.syphonBatteries(stack, player, this.armorCost);
        }
        player.addPotionEffect(new PotionEffect(AlchemicalWizardry.customPotionSoulHardenID, 1, 3));
    }

    @Override
    public boolean isUpgrade() {
        return true;
    }

    @Override
    public int getEnergyForTenSeconds() {
        return 0;
    }
}
