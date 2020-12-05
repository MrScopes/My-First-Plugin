package me.mrscopes.myfirstplugin.commands;

import me.mrscopes.myfirstplugin.MyFirstPlugin;
import org.bukkit.command.CommandExecutor;

public class CommandHandler {

    private final MyFirstPlugin plugin;

    public CommandHandler(MyFirstPlugin plugin) {
        this.plugin = plugin;

        registerCommand("mrscopes", new MrScopesCommand());
        registerCommand("gmc", new GamemodeCommand());
        registerCommand("gms", new GamemodeCommand());
        registerCommand("gma", new GamemodeCommand());
        registerCommand("gmsp", new GamemodeCommand());
        registerCommand("config", new ConfigCommand());
        registerCommand("spawn", new SpawnCommand());
        registerCommand("setspawn", new SpawnCommand());
    }

    private void registerCommand(String command, CommandExecutor executor) {
        plugin.getCommand(command).setExecutor(executor);
    }

}