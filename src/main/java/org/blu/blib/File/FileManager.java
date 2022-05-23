package org.blu.blib.File;

import org.blu.blib.Util.Text;

public class FileManager {

    private final Configuration c = new Configuration();

    public void setupFile() {
        Text.sendInfoLog("Connecting to default configuration file...");
        c.setupConfiguration();
    }

    public void reloadFile() {
        Text.sendInfoLog("Reloading default configuration file...");
        c.reloadConfiguration();
        c.saveConfiguration();
    }
}
