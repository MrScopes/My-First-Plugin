package me.mrscopes.myfirstplugin.listeners;

import me.mrscopes.myfirstplugin.utilities;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        String location = block.getX() + ", " + block.getY() + ", " + block.getZ();
        event.getPlayer().sendActionBar(utilities.coloredStr("Broke block &a" + block.getBlockData().getMaterial() + " &fat &a" + location));
    }
}