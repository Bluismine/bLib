package net.blu.blib;

import net.blu.blib.api.util.Logger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configuration {

    private File configFile;
    private FileConfiguration config;
    private final bLib plugin;
    private final Logger logger = new Logger();

    public Configuration(bLib bLib) {
        this.plugin = bLib;
    }

    public void setupConfiguration() {
        File configFolder = new File(plugin.getDataFolder(), plugin.getName());
        configFile = new File(configFolder, "config.yml");
        if (!configFolder.exists()) {
            configFolder.mkdirs();
        }
        if (!configFile.exists()) {
            try {
                logger.sendWarningLog("Can't see default configuration file!");
                logger.sendInfoLog("Trying to create default configuration file...");

                configFile.createNewFile();
            } catch (IOException e) {
                logger.sendWarningLog("Can't create default configuration file!");
            }
        }

        config = new YamlConfiguration();
        try {
            config.load(configFile);
            saveConfiguration();
        } catch (IOException | InvalidConfigurationException e) {
            logger.sendWarningLog("Can't load default configuration file!");
        }
    }

    public FileConfiguration getConfiguration() {
        return config;
    }

    public void saveConfiguration() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            logger.sendWarningLog("Can't save default configuration file.");
        }
    }

     public void reloadConfiguration() {
        setupConfiguration();
        config = YamlConfiguration.loadConfiguration(configFile);
     }
}
