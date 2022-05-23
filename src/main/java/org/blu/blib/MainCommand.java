package org.blu.blib;

import org.blu.blib.Command.CommandCore;
import org.blu.blib.File.FileManager;
import org.blu.blib.Util.Text;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MainCommand extends CommandCore {

    private Text text;
    private final List<String> HELP_MENU = new ArrayList<>();

    public MainCommand() {
        super("blib");
        this.description = "Shows the bLib help menu";
        this.usageMessage = " /blib (reload/help/about)";
        this.setAliases(List.of("blibrary"));
    }

    @Override
    public boolean execute(CommandSender commandSender, String label, String[] args) {
        if (commandSender instanceof Player player) {
            if (args.length == 0) {
                Text.sendInfoLog("&bb&eLib &7Version: &f" + bLib.getPlugin(bLib.class).getDescription().getVersion());
                Text.sendInfoLog("&eCreated by: &f" + bLib.getPlugin(bLib.class).getDescription().getAuthors());
            }
            if ((args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")) && player.hasPermission("blib.command.reload")) {
                final long currentTimeMillis = System.currentTimeMillis();

                FileManager fileManager = new FileManager();
                fileManager.reloadFile();

                Text.sendInfoLog("Completed in " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
            }
            if ((args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) && player.hasPermission("blib.command.help")) {
                StringBuilder header = new StringBuilder();
                header.append(ChatColor.YELLOW);
                header.append("--------- ");
                header.append(ChatColor.WHITE);
                header.append("Help: ");
                header.append("bLib");
                header.append(" ");
                List<String> helpMenu = new java.util.ArrayList<>();

                helpMenu.add("/" + args[0]);

                text.sendMessage(commandSender, String.valueOf(header));
                for (String help : helpMenu) {
                    System.out.println(help);
                }
                text.sendMessage(commandSender, "");
            } else {
                if (args.length == 0) {
                    Text.sendInfoLog("&bb&eLib &7Version: &f" + bLib.getPlugin(bLib.class).getDescription().getVersion());
                    Text.sendInfoLog("&eCreated by: &f" + bLib.getPlugin(bLib.class).getDescription().getAuthors());
                    Text.sendInfoLog("&f/blib help &7- To show help menu of bLib.");
                }
            }
        }
        return true;
    }
}
