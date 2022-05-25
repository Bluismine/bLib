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

    public static void registerCommand(final String name, final CommandCore command) {
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            final CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            commandMap.register(name, (org.bukkit.command.Command)command);
            if (commandMap instanceof CommandMap) {
                commandMap.register(name, command);
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public abstract boolean execute(CommandSender commandSender, String label, String[] args);
}
