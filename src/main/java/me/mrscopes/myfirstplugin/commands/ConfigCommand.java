package me.mrscopes.myfirstplugin.commands;

import me.mrscopes.myfirstplugin.MyFirstPlugin;
import me.mrscopes.myfirstplugin.utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(utilities.coloredStr("&c/config <get | set | reload>"));
            return false;
        }

        if (args[0].equals("get")) {
            if (args.length < 2) {
                sender.sendMessage(utilities.coloredStr("&c/config get <value>"));
                return false;
            }
            sender.sendMessage(utilities.coloredStr(args[1] + " &7is &f" + MyFirstPlugin.getInstance().getConfig().getString(args[1])));

        } else if (args[0].equals("set")) {
            if (args.length < 3) {
                sender.sendMessage(utilities.coloredStr("&c/config set <value> <newValue>"));
                return false;
            } else {
                String rest = utilities.rest(args, 2);
                MyFirstPlugin.getInstance().getConfig().set(args[1], rest);
                MyFirstPlugin.getInstance().saveConfig();
                sender.sendMessage(utilities.coloredStr(args[1] + " &7is now &f" + rest));
            }

        } else if (args[0].equals("reload")) {
            MyFirstPlugin.getInstance().reloadConfig();
            sender.sendMessage(utilities.coloredStr("&aReloaded the config."));
        }

        return true;
    }

}