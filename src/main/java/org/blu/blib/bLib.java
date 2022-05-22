package org.blu.blib;

import org.blu.blib.File.FileManager;
import org.blu.blib.Util.Text;
import org.bukkit.plugin.java.JavaPlugin;

public class bLib extends JavaPlugin {

    private Text text;
    private FileManager fileManager;

    @Override
    public void onEnable() {
        final long currentTimeMillis = System.currentTimeMillis();

        fileManager.setupFile();

        text.sendInfoLog("Completed in " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
    }
}
