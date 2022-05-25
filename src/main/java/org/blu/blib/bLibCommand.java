package org.blu.blib;

import org.apache.maven.model.PluginManagement;
import org.blu.blib.Command.CommandCore;
import org.blu.blib.File.FileManager;
import org.blu.blib.Util.CommandLineColor;
import org.blu.blib.Util.Text;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
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
        Text text = new Text();
        if (!commandSender.hasPermission(getPermission())) text.sendMessage(commandSender, "&cYou don't have permission to do this!");
        else {
            if (args[0].equalsIgnoreCase("reload")) {
                FileManager file = new FileManager();
                file.reloadFile();
            }
        }
        if (commandSender instanceof Player player) {
            text.sendMessage(player, "&cFor now, this command doesn't support for player.\n&cPlease, waiting for update.");
        }
        return false;
    }
}
