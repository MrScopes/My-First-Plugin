package me.mrscopes.myfirstplugin.commands;

import me.mrscopes.myfirstplugin.utilities;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        GameMode mode;

        switch (cmd.getName()) {
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

        if (sender instanceof ConsoleCommandSender) {
            if (args.length == 0) {
                sender.sendMessage(utilities.coloredStr("&c/" + cmd.getName() + " <player>"));
                return false;
            }
        }

        Player target = utilities.determineTarget(sender, args.length > 0 ? args[0] : sender.getName(), "command.gamemode." + utilities.sexyString(mode.name()));

        return updateMode(target, sender, mode);
    }

    private boolean updateMode(Player target, CommandSender sender, GameMode mode) {
        if (target == null) {
            sender.sendMessage(utilities.coloredStr("&cThat player isn't online."));
            return false;
        }

        target.setGameMode(mode);
        target.sendMessage(utilities.coloredStr("&7Your Gamemode is now " + "&b" + utilities.sexyString(mode.name()) + "&7."));

        if (target != sender) {
            sender.sendMessage(utilities.coloredStr("&b" + target.getName() + "'s " + "&7Gamemode is now &b" + utilities.sexyString(mode.name()) + "&7."));
        }

        return true;
    }
}