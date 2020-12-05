package me.mrscopes.myfirstplugin.listeners.block;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class BlockDamageListener implements Listener {
    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Insta Break")) {
            if (event.getBlock().getType().toString() != "BEDROCK") {
                event.setInstaBreak(true);
            }
        }
    }
}