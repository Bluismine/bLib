package org.blu.blib.Util;

import org.bukkit.ChatColor;

public class Utils {

    public String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
