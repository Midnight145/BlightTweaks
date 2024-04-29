package co.nidmight.blighttweaks.common.items;

import java.util.ArrayList;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import co.nidmight.blighttweaks.common.BTStrings;
import cpw.mods.fml.common.registry.GameRegistry;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.playerdata.PacketAspectPool;
import thaumcraft.common.lib.research.ResearchManager;

public class ItemAlienTome extends Item {

    public ItemAlienTome() {
        setUnlocalizedName(BTStrings.MOD_ID + "_" + BTStrings.researchNoteName);
        GameRegistry.registerItem(this, BTStrings.researchNoteName);
        setCreativeTab(CreativeTabs.tabMaterials);
        setTextureName(BTStrings.MOD_ID + ":" + BTStrings.researchNoteName);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World theWorld, EntityPlayer thePlayer) {

        if (!theWorld.isRemote) {
            grantResearch(thePlayer, 4);
        } else {
            thePlayer
                .addChatMessage(new ChatComponentText(StatCollector.translateToLocal("blightbuster.researchnote")));
        }

        itemStack.stackSize -= 1;

        return itemStack;
    }

    // Code copied from WarpEvents. Seriously should have been public and in an API.

    private static void grantResearch(EntityPlayer player, int times) {
        ArrayList<Aspect> primalAspectList = Aspect.getPrimalAspects();
        for (int a = 0; a < times; a++) {
            Aspect aspect = primalAspectList.get(player.worldObj.rand.nextInt(6 - a));

            primalAspectList.remove(aspect);
            Thaumcraft.proxy.playerKnowledge.addAspectPool(player.getCommandSenderName(), aspect, (short) 10);
            PacketHandler.INSTANCE.sendTo(
                new PacketAspectPool(
                    aspect.getTag(),
                    (short) 10,
                    Thaumcraft.proxy.playerKnowledge.getAspectPoolFor(player.getCommandSenderName(), aspect)),
                (EntityPlayerMP) player);
        }
        ResearchManager.scheduleSave(player);
    }
}
