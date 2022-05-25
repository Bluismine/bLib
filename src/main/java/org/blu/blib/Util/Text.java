package org.blu.blib.Util;

import org.blu.blib.bLib;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Text {

    private static final ConsoleCommandSender CONSOLE = Bukkit.getConsoleSender();
    private static final bLib PLUGIN = bLib.getPlugin(bLib.class);
    private static final String CONSOLE_PREFIX = "[" + PLUGIN.getDescription().getPrefix() + "] ";

    public static void sendInfoLog(final @NotNull String message) {
        System.out.print(CONSOLE_PREFIX + message);
    }

    public static void sendWarningLog(final @NotNull String message) {
        System.out.print(CONSOLE_PREFIX + CommandLineColor.RED.getColor() + message + CommandLineColor.RESET.getColor());
    }

    public void sendMessage(final @NotNull Player player, final @NotNull String message) {
        player.sendMessage(colorize(message));
    }

    public void sendMessage(final @NotNull CommandSender commandSender, final @NotNull String message) {
        commandSender.sendMessage(colorizes(message));
    }

    public String colorizes(final @NotNull String message) {
        return message.replace("§0", CommandLineColor.BLACK.getColor())
                .replace("§1", CommandLineColor.BLUE.getColor())
                .replace("§2", CommandLineColor.GREEN.getColor())
                .replace("§3", CommandLineColor.CYAN.getColor())
                .replace("§4", CommandLineColor.RED.getColor())
                .replace("§5", CommandLineColor.PURPLE.getColor())
                .replace("§6", CommandLineColor.YELLOW.getColor())
                .replace("§7", CommandLineColor.BLACK.getColor())
                .replace("§8", CommandLineColor.BLACK.getColor())
                .replace("§9", CommandLineColor.BLUE.getColor())
                .replace("§a", CommandLineColor.GREEN.getColor())
                .replace("§b", CommandLineColor.BLUE.getColor())
                .replace("§c", CommandLineColor.RED.getColor())
                .replace("§d", CommandLineColor.PURPLE.getColor())
                .replace("§e", CommandLineColor.YELLOW.getColor())
                .replace("§f", CommandLineColor.WHITE.getColor())
                .replace("§l", CommandLineColor.BOLD.getColor())
                .replace("§k", "")
                .replace("§r", CommandLineColor.RESET.getColor())
                // Part 2
                .replace("&0", CommandLineColor.BLACK.getColor())
                .replace("&1", CommandLineColor.BLUE.getColor())
                .replace("&2", CommandLineColor.GREEN.getColor())
                .replace("&3", CommandLineColor.CYAN.getColor())
                .replace("&4", CommandLineColor.RED.getColor())
                .replace("&5", CommandLineColor.PURPLE.getColor())
                .replace("&6", CommandLineColor.YELLOW.getColor())
                .replace("&7", CommandLineColor.BLACK.getColor())
                .replace("&8", CommandLineColor.BLACK.getColor())
                .replace("&9", CommandLineColor.BLUE.getColor())
                .replace("&a", CommandLineColor.GREEN.getColor())
                .replace("&b", CommandLineColor.BLUE.getColor())
                .replace("&c", CommandLineColor.RED.getColor())
                .replace("&d", CommandLineColor.PURPLE.getColor())
                .replace("&e", CommandLineColor.YELLOW.getColor())
                .replace("&f", CommandLineColor.WHITE.getColor())
                .replace("&l", CommandLineColor.BOLD.getColor())
                .replace("&k", "")
                .replace("&r", CommandLineColor.RESET.getColor()) + CommandLineColor.RESET.getColor();
    }

    public String colorize(final @NotNull String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String removeColor(final @NotNull String message) {
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
