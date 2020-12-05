package me.mrscopes.myfirstplugin.listeners;

import me.mrscopes.myfirstplugin.MyFirstPlugin;
import me.mrscopes.myfirstplugin.listeners.block.*;
import me.mrscopes.myfirstplugin.listeners.player.*;
import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.getServer;

public class ListenerHandler {

    private final MyFirstPlugin plugin;

    public ListenerHandler(MyFirstPlugin plugin) {
        this.plugin = plugin;

        // block events
        registerEvent(new BlockBreakListener());
        registerEvent(new BlockDamageListener());

        // player events
        registerEvent(new PlayerJoinListener());
        registerEvent(new PlayerQuitListener());
        registerEvent(new PlayerChatListener());
    }

    private void registerEvent(Listener event) {
        getServer().getPluginManager().registerEvents(event, plugin);
    }

}