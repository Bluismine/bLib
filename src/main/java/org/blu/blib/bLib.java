package org.blu.blib;

import org.blu.blib.Command.CommandCore;
import org.blu.blib.File.FileManager;
import org.blu.blib.Util.Text;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class bLib extends JavaPlugin {

    private final FileManager fileManager = new FileManager();
    public bLibCommand bLibCommand;
    public Text text;

    @Override
    public void onEnable() {
        final long currentTimeMillis = System.currentTimeMillis();
        // bStats
        int pluginId = 15271;
        Metrics metrics = new Metrics(this, pluginId);

        new bLibCommand("blib", this);

        //setup File
        fileManager.setupFile();
        //setup commands
        registerCommands();

        Text.sendInfoLog("Completed in " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
    }

    private void registerCommands() {
        CommandCore.registerCommand("blib", new bLibCommand("blib", this));
    }

    @Override
    public void onDisable() {
        System.out.printf(String.format("[%s] Disabled Version %s%n", getDescription().getName(), getDescription().getVersion()));
    }
}
