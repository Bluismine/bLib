package org.blu.blib.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.*;

import java.lang.reflect.Field;
import java.util.List;

public abstract class CommandCore extends Command {

    protected CommandCore(String name) {
        super(name);
    }

    protected CommandCore(String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }

    public static void registerCommand(final String fallback, final CommandCore command) {
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            final CommandMap commandMap = (CommandMap)Bukkit.getServer().getClass().getDeclaredField("commandMap").get(Bukkit.getServer());
            commandMap.register(fallback, command);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
