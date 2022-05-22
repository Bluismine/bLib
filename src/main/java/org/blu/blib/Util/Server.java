package org.blu.blib.Util;

import org.blu.blib.bLib;

import java.util.logging.Level;

public class Server {

    private bLib plugin;

    public void sendInfoLog(String message) {
        this.plugin.getLogger().log(Level.INFO, message);
    }

    public void sendWarningLog(String message) {
        this.plugin.getLogger().log(Level.WARNING, message);
    }
}
