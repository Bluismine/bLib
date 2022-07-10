package net.blu.blib.API;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface PermissionAPI {

    @NotNull
    boolean checkPermission(Player player, String permission);
    @NotNull
    boolean checkPermission(Player player, FileConfiguration fileName, String path);
}
