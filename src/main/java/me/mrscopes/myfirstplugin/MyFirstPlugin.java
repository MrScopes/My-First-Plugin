package me.mrscopes.myfirstplugin;

import me.mrscopes.myfirstplugin.commands.CommandHandler;
import me.mrscopes.myfirstplugin.listeners.ListenerHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin extends JavaPlugin {

    public static MyFirstPlugin instance;
    public static MyFirstPlugin get() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Enabled Test Plugin.");
        this.saveDefaultConfig();
        new CommandHandler(this);
        new ListenerHandler(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled Test Plugin.");
    }
}