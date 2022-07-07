package net.blu.blib.api.utils;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ColorTranslator {

    /**
     * Colorize for console.
     */
    public static String colorizes(@NotNull String message) {
        if (message == null) {
            message = "&cHave some problem with ColorTranslator library, report this to author to fix this!";
        }
        String text = message.replace("§0", ConsoleColor.BLACK)
                .replace("§1", ConsoleColor.BLUE)
                .replace("§2", ConsoleColor.GREEN)
                .replace("§3", ConsoleColor.LIGHT_BLUE)
                .replace("§4", ConsoleColor.RED)
                .replace("§5", ConsoleColor.PURPLE)
                .replace("§6", ConsoleColor.YELLOW)
                .replace("§7", ConsoleColor.BLACK)
                .replace("§8", ConsoleColor.BLACK)
                .replace("§9", ConsoleColor.BLUE)
                .replace("§a", ConsoleColor.GREEN)
                .replace("§b", ConsoleColor.LIGHT_BLUE)
                .replace("§c", ConsoleColor.RED)
                .replace("§d", ConsoleColor.PURPLE)
                .replace("§e", ConsoleColor.YELLOW)
                .replace("§f", ConsoleColor.WHITE)
                .replace("§l", ConsoleColor.BOLD)
                .replace("§k", "")
                .replace("§r", ConsoleColor.RESET)
                .replace("&0", ConsoleColor.BLACK)
                .replace("&1", ConsoleColor.BLUE)
                .replace("&2", ConsoleColor.GREEN)
                .replace("&3", ConsoleColor.LIGHT_BLUE)
                .replace("&4", ConsoleColor.RED)
                .replace("&5", ConsoleColor.PURPLE)
                .replace("&6", ConsoleColor.YELLOW)
                .replace("&7", ConsoleColor.BLACK)
                .replace("&8", ConsoleColor.BLACK)
                .replace("&9", ConsoleColor.BLUE)
                .replace("&a", ConsoleColor.GREEN)
                .replace("&b", ConsoleColor.LIGHT_BLUE)
                .replace("&c", ConsoleColor.RED)
                .replace("&d", ConsoleColor.PURPLE)
                .replace("&e", ConsoleColor.YELLOW)
                .replace("&f", ConsoleColor.WHITE)
                .replace("&l", ConsoleColor.BOLD)
                .replace("&k", "")
                .replace("&r", ConsoleColor.RESET);
        return text + ConsoleColor.RESET;
    }

    /**
     * Colorize for message to user.
     */
    @Contract("_ -> new")
    public static String colorize(@NotNull String message) {
        if (message == null) {
            message = "&cHave some problem with ColorTranslator library, report this to author to fix this!";
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    /**
     * Remove color in text.
     */
    public static String removeColor(@NotNull String message) {
        if (message == null) {
            message = "&cHave some problem with ColorTranslator library, report this to author to fix this!";
        }
        return message.replace("&0", "").replace("&1", "").replace("&2", "").replace("&3", "").replace("&4", "").replace("&5", "").replace("&6", "").replace("&7", "").replace("&8", "").replace("&9", "").replace("&a", "").replace("&b", "").replace("&c", "").replace("&d", "").replace("&e", "").replace("&f", "").replace("&l", "").replace("&k", "").replace("&r", "").replace("§0", "").replace("§1", "").replace("§2", "").replace("§3", "").replace("§4", "").replace("§5", "").replace("§6", "").replace("§7", "").replace("§8", "").replace("§9", "").replace("§a", "").replace("§b", "").replace("§c", "").replace("§d", "").replace("§e", "").replace("§f", "").replace("§l", "").replace("§k", "").replace("§r", "");
    }
}

