package net.blu.blib.api.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.List;

public abstract class CoreCommand extends Command {
    public CoreCommand(@NotNull String name) {
        super(name);
    }

    public CoreCommand(@NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }

    public static void registerCommand(@NotNull final String name, @NotNull CoreCommand command) {
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            final CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            commandMap.register(name, (Command) command);
            if (commandMap instanceof CommandMap) {
                commandMap.register(name, command);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract boolean execute(@NotNull CommandSender commandSender, @NotNull String label, @NotNull String[] args);
}
