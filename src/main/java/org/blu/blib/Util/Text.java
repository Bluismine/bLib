package org.blu.blib.Util;

import org.blu.blib.bLib;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class Text {

    private static final ConsoleCommandSender CONSOLE = Bukkit.getConsoleSender();
    private static final bLib PLUGIN = bLib.getPlugin(bLib.class);
    private static final String CONSOLE_PREFIX = "[" + PLUGIN.getDescription().getPrefix() + "] ";

    public static void sendInfoLog(final String message) {
        CONSOLE.sendMessage(CONSOLE_PREFIX + ChatColor.WHITE + message);
    }

    public static void sendWarningLog(final String message) {
        CONSOLE.sendMessage(CONSOLE_PREFIX + ChatColor.DARK_RED + message);
    }

    public void sendMessage(final org.bukkit.entity.Player player, final String message) {
        player.sendMessage(colorize(message));
    }

    public void sendMessage(final CommandSender commandSender, final String message) {
        commandSender.sendMessage(colorize(message));
    }

    public String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String removeColor(String message) {
        return message.replace("&0", "")
                .replace("&1", "")
                .replace("&2", "")
                .replace("&3", "")
                .replace("&4", "")
                .replace("&5", "")
                .replace("&6", "")
                .replace("&7", "")
                .replace("&8", "")
                .replace("&9", "")
                .replace("&a", "")
                .replace("&b", "")
                .replace("&c", "")
                .replace("&d", "")
                .replace("&e", "")
                .replace("&f", "")
                .replace("&l", "")
                .replace("&k", "")
                .replace("&r", "")
                // Part 2
                .replace("§0", "")
                .replace("§1", "")
                .replace("§2", "")
                .replace("§3", "")
                .replace("§4", "")
                .replace("§5", "")
                .replace("§6", "")
                .replace("§7", "")
                .replace("§8", "")
                .replace("§9", "")
                .replace("§a", "")
                .replace("§b", "")
                .replace("§c", "")
                .replace("§d", "")
                .replace("§e", "")
                .replace("§f", "")
                .replace("§l", "")
                .replace("§k", "")
                .replace("§r", "");
    }
}
