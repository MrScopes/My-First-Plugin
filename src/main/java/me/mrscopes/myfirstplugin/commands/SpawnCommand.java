package me.mrscopes.myfirstplugin.commands;

import me.mrscopes.myfirstplugin.MyFirstPlugin;
import me.mrscopes.myfirstplugin.utilities;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equals("spawn")) {
            Player player = (Player) sender;

            Location location = utilities.locationFromString(MyFirstPlugin.getInstance().getConfig().getString("spawn"));
            player.teleport(location);
            player.sendMessage(utilities.coloredStr("Teleported to &a" + utilities.stringFromLocation(location, true)));

        } else if (cmd.getName().equals("setspawn")) {

            if (sender instanceof Player) {
                Player player = (Player) sender;

                String location = utilities.stringFromLocation(player.getLocation(), false);
                MyFirstPlugin.getInstance().getConfig().set("spawn", location);
                MyFirstPlugin.getInstance().saveConfig();
                sender.sendMessage(utilities.coloredStr("Spawn has been set to &a" + utilities.stringFromLocation(player.getLocation(), true)));
            } else {
                sender.sendMessage(utilities.coloredStr("&cYou can't set spawn as console."));
                return false;
            }
        }
        return true;
    }
}