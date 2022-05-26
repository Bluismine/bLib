package org.blu.blib;

import org.blu.blib.Command.CommandCore;
import org.blu.blib.File.FileManager;
import org.blu.blib.Util.Text;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class bLibCommand extends CommandCore {

    protected bLibCommand(String name) {
        super(name);
        this.description = "Shows the information menu about bLib.";
        this.usageMessage = "/blib (reload/about)";
        this.setAliases(List.of("blibrary"));
        this.setPermission("blib.command");
    }

    @Override
    public boolean execute(CommandSender commandSender, String label, String[] args) {
        final Text text = new Text();
        if (commandSender instanceof Player player) {
            if (!commandSender.hasPermission(getPermission())) {
                text.sendMessage(commandSender, "&cYou don't have permission to do this!");
            }
            text.sendMessage(player, "&cFor now, this command doesn't support for player.\n&cPlease, waiting for update.");
        } else {
            if (args.length <= 0) {
                text.sendMessage(commandSender, "bLib " + bLib.getInstance().getDescription().getVersion() +" was created by &bBlu&r.");
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")) {
                    FileManager file = new FileManager();
                    file.reloadFile();
                }
            }
        }
        return true;
    }
}
