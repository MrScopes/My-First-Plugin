package me.mrscopes.myfirstplugin;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringJoiner;

public class utilities {
    public static String coloredStr(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String rest(String[] array, int afterIndex) {
        return StringUtils.join(ArrayUtils.subarray(array, afterIndex, array.length), " ");
    }

    public static Location locationFromString(String locString) {
        String[] arg = locString.split(",");
        double[] parsed = new double[5];
        for (int a = 0; a < 5; a++) {
            parsed[a] = Double.parseDouble(arg[a + 1]);
        }

        Location location = new Location(Bukkit.getWorld(arg[0]), parsed[0], parsed[1], parsed[2]);
        location.setYaw((float) parsed[3]);
        location.setPitch((float) parsed[4]);
        return location;
    }

    public static String stringFromLocation(Location location, Boolean beautiful) {
        if (beautiful == false) {
            return location.getWorld().getName() + "," + round(location.getX()) + "," + round(location.getY()) + "," + round(location.getZ()) +
                    "," + round(location.getYaw()) + "," + round(location.getPitch());
        } else {
            return "X: " + round(location.getX()) + ", Y: " + round(location.getY()) + ", Z: " + round(location.getZ());
        }
    }

    private static Number round(double number) {
        BigDecimal bd = BigDecimal.valueOf(number);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static Player determineTarget(CommandSender sender, String target, String permission) {
        if (sender.toString().equals(target)) {
            return (Player) sender;
        }

        if (sender instanceof Player) {
            if (sender.hasPermission(permission)) {
                return Bukkit.getPlayerExact(target);
            }

            return (Player) sender;
        }

        return Bukkit.getPlayerExact(target);
    }

    public static String sexyString(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
}