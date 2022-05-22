package org.blu.blib.Util;

import org.bukkit.command.CommandSender;

public class Player {

    private static Utils util;


    public static void sendMessage(final org.bukkit.entity.Player player, final String message) {
        player.sendMessage(util.colorize(message));
    }

    public static void sendMessage(final CommandSender commandSender, final String message) {
        commandSender.sendMessage(util.colorize(message));
    }
}
