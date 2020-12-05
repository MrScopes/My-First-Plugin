package me.mrscopes.myfirstplugin.commands;

import me.mrscopes.myfirstplugin.utilities;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        GameMode mode;

        switch (label.toLowerCase()) {
            case "gmc":
                mode = GameMode.CREATIVE;
                break;
            case "gms":
                mode = GameMode.SURVIVAL;
                break;
            case "gma":
                mode = GameMode.ADVENTURE;
                break;
            case "gmsp":
                mode = GameMode.SPECTATOR;
                break;
            default:
                return false;
        }

        Player player;

        if (args.length == 0) {
            if (sender instanceof Player) {
                player = (Player) sender;
            }
            else {
                sender.sendMessage(utilities.coloredStr("&c/" + label.toLowerCase()) + " <player>");
                return false;
            }
        } else {
            player = Bukkit.getPlayerExact(args[0]);
        }

        return updateMode(player, sender, mode);

    }

    private boolean updateMode(Player target, CommandSender sender, GameMode mode) {
        if (target == null) {
            sender.sendMessage(utilities.coloredStr("&cThat player isn't online."));
            return false;
        }

        target.setGameMode(mode);
        target.sendMessage(utilities.coloredStr("&7Your Gamemode is now " + "&b" + mode.toString() + "&7."));

        if (target != sender) {
            sender.sendMessage(utilities.coloredStr("&b" + target.getName() + "'s " + "&7Gamemode is now &b" + mode.toString() + "&7."));
        }

        return true;
    }
}