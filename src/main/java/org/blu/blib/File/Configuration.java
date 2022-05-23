package org.blu.blib.File;

import org.blu.blib.Util.Text;
import org.blu.blib.bLib;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configuration {

    private File configFile;
    private FileConfiguration config;
    private Text text;

    public void setupConfiguration() {
        configFile = new File(bLib.getPlugin(bLib.class).getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            try {
                Text.sendWarningLog("Can't see default configuration file!");
                Text.sendInfoLog("Creating default configuration file...");
                configFile.createNewFile();
            } catch (IOException e) {
                Text.sendWarningLog("Can't create default configuration file.");
            }
        }

        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public FileConfiguration getConfiguration() {
        return config;
    }

    public void saveConfiguration() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            text.sendWarningLog("Can't save default configuration file.");
        }
    }

     public void reloadConfiguration() {
        config = YamlConfiguration.loadConfiguration(configFile);
     }
}
