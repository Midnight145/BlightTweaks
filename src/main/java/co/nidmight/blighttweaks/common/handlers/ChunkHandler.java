package co.nidmight.blighttweaks.common.handlers;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ChunkEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jds.bibliocraft.tileentities.TileEntityFancySign;

public class ChunkHandler {

    public ChunkHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {
        Chunk chunk = event.getChunk();
        ChunkCoordIntPair coords = chunk.getChunkCoordIntPair();
        if (coords.chunkXPos == -62 && coords.chunkZPos == -66) {
            TileEntity tile = event.world.getTileEntity(-977, 149, -1046);
            if (tile instanceof TileEntityFancySign sign) {
                sign.textScale[1] = 2;
                sign.text[1] = "Looting the Jaded, or";
                sign.text[2] = " breaking or placing";
                sign.markDirty();
            }
        }
    }
}
