package me.mrscopes.myfirstplugin.listeners;

import me.mrscopes.myfirstplugin.utilities;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setFormat(utilities.coloredStr(event.getPlayer().getName() + "&8: &f" + event.getMessage()));
    }
}