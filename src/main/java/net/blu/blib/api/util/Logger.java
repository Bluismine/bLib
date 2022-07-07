package net.blu.blib.api.util;

import net.blu.blib.bLib;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Logger {

    private final JavaPlugin plugin;
    private final bLib bLibrary = bLib.getInstance();

    /**
     * Constructor when call logger to push announce.
     */
    public Logger() {
        this.plugin = bLib.getInstance();
    }

    public Logger(JavaPlugin main) {
        this.plugin = main;
    }

    /**
     * Send message to console.
     */
    public void sendInfoLog(@NotNull String message) {
        System.out.print(bLibrary.PREFIX + message + ConsoleColor.RESET);
    }

    /**
     * Send warning message to console.
     */
    public void sendWarningLog(@NotNull String message) {
        System.out.print(bLibrary.PREFIX + Color.RED.getColor() + message + ConsoleColor.RESET);
    }

    @NotNull
    public void sendMessage( CommandSender commandSender, String message) {
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
