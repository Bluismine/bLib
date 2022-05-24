package org.blu.blib.File;

import org.blu.blib.Util.Text;
import org.blu.blib.bLib;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configuration {

    private File configFile;
    private FileConfiguration config;

    public void setupConfiguration() {
        configFile = new File(bLib.getPlugin(bLib.class).getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            try {
                Text.sendWarningLog("Can't see default configuration file!");
                Text.sendInfoLog("Trying to create default configuration file...");
                final File parentFile = configFile.getParentFile();
                parentFile.mkdirs();

                configFile.createNewFile();
            } catch (IOException e) {
                Text.sendWarningLog("Can't create default configuration file!");
            }
        }

        config = new YamlConfiguration();
        loadConfigurationFile();
        try {
            config.load(configFile);
            saveConfiguration();
        } catch (IOException | InvalidConfigurationException e) {
            Text.sendWarningLog("Can't load default configuration file!");
        }
    }

    public FileConfiguration getConfiguration() {
        return config;
    }

    public void saveConfiguration() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            Text.sendWarningLog("Can't save default configuration file.");
        }
    }

     public void reloadConfiguration() {
        config = YamlConfiguration.loadConfiguration(configFile);
     }

     public void loadConfigurationFile() {
         this.getConfiguration().options().header("bLib version " + bLib.getPlugin(bLib.class).getDescription().getVersion() + "\nCreated by Blu");
         this.getConfiguration().addDefault("Hello", "hi");
     }
}
