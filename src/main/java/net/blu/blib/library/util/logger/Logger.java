package net.blu.blib.library.util.logger;

import com.google.common.base.Preconditions;
import net.blu.blib.API.LoggerAPI;
import net.blu.blib.library.util.color.ColorTranslator;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Logger implements LoggerAPI {

    public static String prefix;
    private final JavaPlugin plugin;
    /**
     * Constructor when call logger to push announce.
     */

    public Logger(@NotNull JavaPlugin mainClass) {
        this.plugin = mainClass;
        setPrefix(mainClass.getDescription().getName());
    }


    /**
     * Send message to console.
     */
    @Override
    @NotNull
    public void sendInfoLog(String message) {
        plugin.getLogger().info(ColorTranslator.colorizes(getPrefix() + message));
    }

    /**
     * Send warning message to console.
     */
    @Override
    @NotNull
    public void sendWarningLog(String message) {
        plugin.getLogger().warning(ColorTranslator.colorizes(getPrefix() + message));
    }

    @Override
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

    @Override
    @NotNull
    public void setPrefix(String prefix) {
        Preconditions.checkArgument(prefix != null, "Your plugin prefix cannot be null");
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        return this.prefix = prefix == null ? "[ Please set your plugin prefix with net.blu.api.util.Logger  ] " : "[" + prefix + "] ";
    }
}
