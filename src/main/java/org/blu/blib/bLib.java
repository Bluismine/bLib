package org.blu.blib;

import org.blu.blib.Util.Text;
import org.bukkit.plugin.java.JavaPlugin;

public class bLib extends JavaPlugin {

    private Text text;
    private final Configuration c = new Configuration();

    @Override
    public void onEnable() {
        final long currentTimeMillis = System.currentTimeMillis();

        text.sendInfoLog("Completed in " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
    }

    public void setupFile() {
        text.sendInfoLog("Connecting to default configuration file...");
        c.setupConfiguration();
    }
}
