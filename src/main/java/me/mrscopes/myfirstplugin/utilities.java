package me.mrscopes.myfirstplugin;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

public class utilities {
    public static String coloredStr(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    public static String rest(String[] array, Integer afterIndex) {
        return StringUtils.join(ArrayUtils.subarray(array, afterIndex, array.length), " ");
    };
}