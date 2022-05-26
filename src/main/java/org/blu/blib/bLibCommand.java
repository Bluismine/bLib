package org.blu.blib;

import org.blu.blib.Command.CommandCore;
import org.blu.blib.Command.SubCommand;
import org.blu.blib.File.FileManager;
import org.blu.blib.SubCommand.ReloadCommand;
import org.blu.blib.Util.Text;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class bLibCommand extends CommandCore {

    private final ArrayList<SubCommand> subCommands = new ArrayList<>();
    private final Text text = new Text();
    private final bLib plugin;

    public bLibCommand(String name, bLib plugin) {
        super(name);
        this.plugin = plugin;
        this.description = "Shows the information menu about bLib.";
        this.usageMessage = "/blib (reload)";
        this.setAliases(List.of("blibrary"));
        this.setPermission("blib.command");

        subCommands.add(new ReloadCommand());
    }

    @Override
    public boolean execute(CommandSender commandSender, String label, String[] args) {
        if (commandSender instanceof Player player) {
            if (!commandSender.hasPermission(getPermission())) {
                text.sendMessage(commandSender, "&cYou don't have permission to do this!");
            } else {
                if (args.length > 0) {
                    for (int i = 0; i < getSubCommands().size(); i++) {
                        if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                            getSubCommands().get(i).perform(player, args);
                        }
                    }
                } else if(args.length == 0){
                    text.sendMessage(player, "bLib " + this.plugin.getDescription().getVersion() +" was created by &bBlu&r.");
                    text.sendMessage(player, "--------------------------------");
                    for (int i = 0; i < getSubCommands().size(); i++){
                        text.sendMessage(player, getSubCommands().get(i).getSyntax() + " - " + getSubCommands().get(i).getDescription());
                    }
                    text.sendMessage(player, "--------------------------------");
                }
            }
        } else {
            if (args.length <= 0) {
                text.sendMessage(commandSender, "&eb&bLib &rVersion: " + this.plugin.getDescription().getVersion());
                text.sendMessage(commandSender, "Created by: Blu");
                text.sendMessage(commandSender, "/blib reload - To reload all config file.");
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")) {
                    FileManager file = new FileManager();
                    file.reloadFile();
                } else {
                    text.sendMessage(commandSender, "Try: /" + label + " help - To show help menu.");
                }
            }
        }
        return true;
    }

    ArrayList<SubCommand> getSubCommands() {
        return this.subCommands;
    }
}
