package net.blu.blib.library.util.permission;

import com.google.common.base.Preconditions;
import net.blu.blib.API.PermissionAPI;
import net.blu.blib.library.util.logger.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class PermissionChecker implements PermissionAPI {

    private JavaPlugin plugin;
    private final Logger logger = new Logger(plugin);

    public PermissionChecker(@NotNull JavaPlugin mainClass) {
        this.plugin = mainClass;
    }

    @Override
    @NotNull
    public boolean checkPermission(Player player, String permission) {
        Preconditions.checkArgument(player != null, "You forgot add player to check permission.");
        Preconditions.checkArgument(permission != null, "You forgot add permission to check that.");
        if (player.hasPermission(permission)) {
            return true;
        } else {
            logger.sendInfoLog("You don't have permission: " + permission + " to do this.");
            return false;
        }
    }

    @Override
    @NotNull
    public boolean checkPermission(Player player, FileConfiguration fileName, String path) {
        Preconditions.checkArgument(player != null, "You forgot add player to check permission.");
        Preconditions.checkArgument(fileName != null, "You forgot add file to get permission.");
        Preconditions.checkArgument(player != null, "You forgot add path to get permission.");
        final String permission = fileName.getString(path);
        if (permission.equalsIgnoreCase("none") || checkPermission(player, permission)) {
            return true;
        }
        for (String message : fileName.getStringList(path)) {
            logger.sendMessage(player, message.replace("%permission%", permission));
        }
        return false;
    }
}
