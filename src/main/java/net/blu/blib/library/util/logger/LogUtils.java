package net.blu.blib.library.util.logger;

import net.blu.blib.library.util.color.ColorTranslator;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

public abstract class LogUtils {

    private static String prefix;

    /**
     * Send message to console.
     */
    public static void sendInfoLog(final Plugin plugin, final String... messages) {
        for (String message : messages) plugin.getLogger().info(ColorTranslator.colorize(message));
    }

    /**
     * Send warning message to console.
     */
    public static void sendWarningLog(final Plugin plugin, final String... messages) {
        for (String message : messages) plugin.getLogger().warning(ColorTranslator.colorize(message));
    }

    /**
     * Send message to console.
     */
    public static void doLog(final Plugin plugin, final Level level, final String... lines) {
        final String prefix = "[" + plugin.getDescription().getName() + "] ";
        if (level == Level.INFO) {
            sendInfoLog(plugin, lines);
        } else if (level == Level.WARNING) {
            sendWarningLog(plugin, lines);
        } else if (level == Level.SEVERE) {
            for (String message : lines) plugin.getLogger().log(level, message);
        } else if (level == Level.FINE) {
            for (String message : lines) plugin.getLogger().log(level, message);
        } else if (level == Level.FINER) {
            for (String message : lines) plugin.getLogger().log(level, message);
        } else if (level == Level.FINEST) {
            for (String message : lines) plugin.getLogger().log(level, message);
        }
    }

    /**
     * Send list message to player with colorized.
     */
    public static void sendMessage(CommandSender commandSender, String... lines) {
        if (commandSender instanceof Player player) {
            for (String message : lines) {
                player.sendMessage(ColorTranslator.colorize(message));
            }
        } else {
            for (String message : lines) {
                commandSender.sendMessage(ColorTranslator.colorizes(message));
            }
        }
    }
}
