package org.blu.blib;

import org.blu.blib.Util.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class bLib extends JavaPlugin {

    public Server sv;

    @Override
    public void onEnable() {
        final long currentTimeMillis = System.currentTimeMillis();

        sv.sendInfoLog("Completed in " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
    }
}
