package net.blu.blib.api;

import com.google.common.base.Preconditions;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public abstract class bAPI {

    public static String prefix;
    private final JavaPlugin plugin;

    public bAPI(@NotNull JavaPlugin plugin) {
        this(plugin, "[ Please set your plugin prefix with net.blu.api.util.Logger ] ");
    }

    public bAPI(@NotNull JavaPlugin mainClass, @NotNull String prefix) {
        this.plugin = mainClass;
        this.prefix = prefix == null ? "[ Please set your plugin prefix with net.blu.api.util.Logger ] " : "[" + prefix + "] ";
    }

    public void setPrefix(@NotNull String prefix) {
        Preconditions.checkArgument(prefix != null, "Your plugin prefix cannot be null");
        this.prefix = prefix;
    }

    public String getPrefix() {
        return "[" + prefix + "] ";
    }
}
