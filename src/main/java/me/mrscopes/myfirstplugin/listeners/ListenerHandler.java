package me.mrscopes.myfirstplugin.listeners;

import me.mrscopes.myfirstplugin.MyFirstPlugin;
import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.getServer;

public class ListenerHandler {

    private final MyFirstPlugin plugin;

    public ListenerHandler(MyFirstPlugin plugin) {
        this.plugin = plugin;

        registerEvent(new PlayerJoinListener());
        registerEvent(new PlayerQuitListener());
        registerEvent(new PlayerChatListener());
    }

    private void registerEvent(Listener event) {
        getServer().getPluginManager().registerEvents(event, plugin);
    }

}