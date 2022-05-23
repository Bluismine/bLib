package org.blu.blib;

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

        Text.sendInfoLog("Completed in " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
    }
}
