package org.blu.blib.File;

import org.blu.blib.Util.Text;
import org.bukkit.entity.Player;

public class FileManager {

    private final Configuration c = new Configuration();
    private Text text;

    public void setupFile() {
        Text.sendInfoLog("Connecting to default configuration file...");
        c.setupConfiguration();
    }

    public void reloadFile() {
        final long currentTimeMillis = System.currentTimeMillis();
        Text.sendInfoLog("Reloading default configuration file...");
        c.reloadConfiguration();
        c.saveConfiguration();
        Text.sendInfoLog("Reload completed in " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
    }

    public void reloadFile(Player player) {
        final long currentTimeMillis = System.currentTimeMillis();
        text.sendMessage(player, "&eReloading default configuration file...");
        c.reloadConfiguration();
        c.saveConfiguration();
        text.sendMessage(player, "&eReload completed in &b" + (currentTimeMillis - System.currentTimeMillis()) + " &ems.");
    }
}
