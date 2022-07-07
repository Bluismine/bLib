package net.blu.blib;

import net.blu.blib.api.util.ConsoleColor;
import net.blu.blib.api.util.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class bLib extends JavaPlugin {

    public Configuration c;
    public final String PREFIX = "[" + this.getDescription().getName() + "] ";
    private Logger logger;
    private static bLib instance;

    @Override
    public void onEnable() {
        final long currentTimeMillis = System.currentTimeMillis();
        System.out.print(ConsoleColor.LIGHT_BLUE + "    ___  " + ConsoleColor.YELLOW + "            " + ConsoleColor.RESET);
        System.out.print(ConsoleColor.LIGHT_BLUE + "   |___) " + ConsoleColor.YELLOW + "|   .|__    " + ConsoleColor.LIGHT_BLUE + "BLib " + ConsoleColor.WHITE + "v"+this.getDescription().getVersion());
        System.out.print(ConsoleColor.LIGHT_BLUE + "   |___) " + ConsoleColor.YELLOW + "|___||__)   " + ConsoleColor.WHITE + "Running on Bukkit - CraftBukkit");
        System.out.print("   ");
        // Sign up some feature
        // init
        instance = this;
        // utils
        logger = new Logger(this);
        logger.sendInfoLog("Register library...");
        // files
        c = new Configuration(this);

        // bStats
        int pluginId = 15271;
        //Metrics metrics = new Metrics(this, pluginId);

        //setup File
        c.setupConfiguration();

        logger.sendInfoLog("Completed in " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
    }

    @Override
    public void onDisable() {
        System.out.printf(String.format("[%s] Disabled Version %s%n", getDescription().getName(), getDescription().getVersion()));
    }

    public static bLib getInstance() {
        return instance;
    }
}
