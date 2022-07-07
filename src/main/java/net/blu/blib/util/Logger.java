package net.blu.blib.util;

import net.blu.blib.api.bLibrary;
import net.blu.blib.api.utils.Color;
import net.blu.blib.api.utils.ColorTranslator;
import net.blu.blib.api.utils.ConsoleColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Logger extends bLibrary {
    /**
     * Constructor when call logger to push announce.
     */
    public Logger(@NotNull JavaPlugin plugin) {
        super(plugin);
        setPrefix(plugin.getDescription().getName());
    }

    /**
     * Send message to console.
     */
    @NotNull
    public void sendInfoLog(@NotNull String message) {
        System.out.print(getPrefix() + message + ConsoleColor.RESET);
    }

    /**
     * Send warning message to console.
     */
    @NotNull
    public void sendWarningLog(@NotNull String message) {
        System.out.print(getPrefix() + Color.RED.getColor() + message + ConsoleColor.RESET);
    }

    @NotNull
    public void sendMessage(CommandSender commandSender, String message) {
        if (message == null) {
            message = "&cHave some problem with Logger library, report this to author to fix this!";
        }
        if (commandSender instanceof Player player) {
            player.sendMessage(ColorTranslator.colorize(message));
        } else {
            commandSender.sendMessage(ColorTranslator.colorizes(message));
        }
    }
}
