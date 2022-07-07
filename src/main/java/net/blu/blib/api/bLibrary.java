package net.blu.blib.api;

import com.google.common.base.Preconditions;
import net.blu.blib.api.utils.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public abstract class bLibrary implements Logger {

    public static String prefix;
    private final JavaPlugin plugin;

    public bLibrary(@NotNull JavaPlugin plugin) {
        this(plugin, "[ Please set your plugin prefix with net.blu.api.util.Logger ] ");
    }

    public bLibrary(@NotNull JavaPlugin mainClass, @NotNull String prefix) {
        this.plugin = mainClass;
        this.prefix = prefix == null ? "[ Please set your plugin prefix with net.blu.api.util.Logger ] " : "[" + prefix + "] ";
    }

    @Override
    public void setPrefix(@NotNull String prefix) {
        Preconditions.checkArgument(prefix != null, "Your plugin prefix cannot be null");
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        return "[" + prefix + "] ";
    }
}
