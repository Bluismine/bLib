package org.blu.blib.Command;

import org.bukkit.command.*;

import java.util.List;

public abstract class CommandCore extends Command {

    protected CommandCore(String name) {
        super(name);
    }

    protected CommandCore(String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }
}
