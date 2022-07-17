package net.blu.blib.library.util.logger;

import net.blu.blib.library.util.color.ColorTranslator;
import net.blu.blib.library.util.color.ConsoleColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public abstract class LogUtils {

    private static PluginLogger pluginLogger;
    private static String name;
    private static final String prefix = "[" + name + "] ";
    /**
     * Checks if logger method is enabled.
     * @return Success or Failure
     */
    abstract public boolean isEnabled();

    /**
     * Send message to console.
     */
    public static void sendInfoLog(final String... messages) {
        if(pluginLogger == null) setPrefix("[bLib] You forgot set prefix with LogUtils");
        for (String message : messages) pluginLogger.log(Level.INFO, ColorTranslator.colorize(message));
    }

    /**
     * Send warning message to console.
     */
    public void sendWarningLog(String... messages) {
        if(pluginLogger == null) setPrefix("[bLib] You forgot set prefix with LogUtils");
        for (String message : messages) pluginLogger.log(Level.WARNING, ConsoleColor.RED + message);
    }

    /**
     * Send list message to player with colorized.
     */
    public void sendMessage(CommandSender commandSender, String... lines) {
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

    /**
     * Set up your plugin prefix when I push announce.
     */
    public void setPrefix(@NotNull Plugin plugin) {
        pluginLogger = new PluginLogger(plugin);
    }

    /**
     * Set up your plugin prefix when I push announce.
     */
    public static void setPrefix(@NotNull String prefix) {
        name = prefix;
    }

    /**
     * Get your plugin prefix when I push announce.
     */
    public String getPrefix() {
        return prefix;
    }

    static {
        name = String.valueOf(name);
    }
}
