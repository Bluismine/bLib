package org.blu.blib.File;

import org.blu.blib.Util.Text;

public class FileManager {

    private Text text;
    private final Configuration c = new Configuration();

    public void setupFile() {
        text.sendInfoLog("Connecting to default configuration file...");
        c.setupConfiguration();
    }

    public void reloadFile() {
        text.sendInfoLog("Reloading default configuration file...");
        c.reloadConfiguration();
        c.saveConfiguration();
    }
}
