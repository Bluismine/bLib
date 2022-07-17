package net.blu.blib;

import net.blu.blib.library.util.color.ConsoleColor;
import net.blu.blib.library.util.logger.LogUtils;
import net.blu.blib.library.util.permission.PermissionChecker;
import net.blu.blib.library.util.sound.Sound;
import org.bukkit.plugin.java.JavaPlugin;

public class bLib extends JavaPlugin {

    private static bLib instance;
    private static LogUtils logger;
    private static PermissionChecker permissionChecker;
    private static Sound sound;

    @Override
    public void onEnable() {
        getDescription().getVersion();
        final long currentTimeMillis = System.currentTimeMillis();
        System.out.print(ConsoleColor.LIGHT_BLUE + "         " + ConsoleColor.YELLOW + "           " + ConsoleColor.RESET);
        System.out.print(ConsoleColor.LIGHT_BLUE + "   |__  " + ConsoleColor.YELLOW + "|   .|__    " + ConsoleColor.LIGHT_BLUE + "b" + ConsoleColor.YELLOW +"Lib " + ConsoleColor.WHITE + "v"+this.getDescription().getVersion());
        System.out.print(ConsoleColor.LIGHT_BLUE + "   |__) " + ConsoleColor.YELLOW + "|___||__)   " + ConsoleColor.WHITE + "Running on Bukkit - CraftBukkit");
        System.out.print("   ");
        // Sign up some feature
        // init
        instance = this;
        if (!setupLoggerUtils()) {
            System.out.println(ConsoleColor.RED + "Disable plugin!");
            getServer().getPluginManager().disablePlugin(this);
        }
        getLoggerUtils().sendInfoLog("Hooking library...");

        // bStats
        int pluginId = 15271;
        //Metrics metrics = new Metrics(this, pluginId);

        getLoggerUtils().sendInfoLog("Completed in " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
    }

    @Override
    public void onDisable() {
        System.out.printf(String.format("[%s] Disabled Version %s%n", getDescription().getName(), getDescription().getVersion()));
    }

    public boolean setupLoggerUtils() {
        logger.setPrefix(this);
        return logger != null;
    }

    public static LogUtils getLoggerUtils() {
        return logger;
    }

    public static bLib getInstance() {
        return instance;
    }
}
