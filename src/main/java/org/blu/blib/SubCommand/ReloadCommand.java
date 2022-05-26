package org.blu.blib.SubCommand;

import org.blu.blib.Command.SubCommand;
import org.blu.blib.File.FileManager;
import org.blu.blib.Util.Text;
import org.blu.blib.bLib;
import org.blu.blib.bLibCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand extends SubCommand {
    private final Text text = new Text();
    private bLib plugin;

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reload all config file and data.";
    }

    @Override
    public String getSyntax() {
        bLibCommand blib = new bLibCommand("blib", plugin);
        return "/" + blib.getLabel() + " reload";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length > 1){
            text.sendMessage(player, "Try this: /blib reload");
        }else if(args.length == 1){
            FileManager file = new FileManager();
            file.reloadFile(player);
        }
    }

    @Override
    public void perform(CommandSender commandSender, String[] args) {
        if (args.length > 1){
            text.sendMessage(commandSender, "Try this: /blib reload");
        }else if(args.length == 1){
            FileManager file = new FileManager();
            file.reloadFile();
        }
    }

}
