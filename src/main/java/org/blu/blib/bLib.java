package org.blu.blib;

import org.blu.blib.Command.CommandCore;
import org.blu.blib.File.FileManager;
import org.blu.blib.Util.Text;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class bLib extends JavaPlugin {

    private final FileManager fileManager = new FileManager();
    private Text text;

    @Override
    public void onEnable() {
        final long currentTimeMillis = System.currentTimeMillis();
        // bStats
        int pluginId = 15271;
        Metrics metrics = new Metrics(this, pluginId);

        //setup File
        fileManager.setupFile();
        //register Commands
        registersCommand();

        Text.sendInfoLog("Completed in " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
    }

    public void registersCommand() {
        Text.sendInfoLog("Starting register commands...");
        CommandCore.registerCommand("blib", new MainCommand());
    }

    @Override
    public void onDisable() {
        Text.sendInfoLog(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }
}
