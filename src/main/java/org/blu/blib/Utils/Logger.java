package org.blu.blib.Utils;

import org.blu.blib.bLib;

import java.util.logging.Level;

public class Logger {

    private bLib plugin;

    public void sendInfoLog(String message) {
        this.plugin.getLogger().log(Level.INFO, message);
    }

    public void sendWarningLog(String message) {
        this.plugin.getLogger().log(Level.WARNING, message);
    }
}
