package me.mrscopes.myfirstplugin;

import me.mrscopes.myfirstplugin.commands.CommandHandler;
import me.mrscopes.myfirstplugin.listeners.ListenerHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin extends JavaPlugin {

    public static MyFirstPlugin instance;

    @Override
    public void onEnable() {
        getLogger().info("Enabled Test Plugin.");
        this.saveDefaultConfig();
        new CommandHandler(this);
        new ListenerHandler(this);
        instance = this;
    }

    @Override
    public void onDisable() { getLogger().info("Disabled Test Plugin."); }

    public static MyFirstPlugin getInstance() {
        return instance;
    }
}
