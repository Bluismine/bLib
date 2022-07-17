package net.blu.blib.library.util.permission;

import com.google.common.base.Preconditions;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public abstract class PermissionChecker {

    private static final String message = "&cYou cannot to do this! You don't have permission: %permission%";

    /**
     * Check player's permission with announce if player don't have that permission.
     * @param player who I need check him?
     * @param permission player's needed to execute command or do sth.
     */
    @NotNull
    public static boolean checkPermission(Player player, String permission) {
        Preconditions.checkArgument(player != null, "You forgot add player to check permission.");
        Preconditions.checkArgument(permission != null, "You forgot add permission to check that.");

        if (player.hasPermission(permission)) {
            return true;
        } else {
            player.sendMessage(message.replaceAll("%permission%", permission));
            return false;
        }
    }

    /**
     * Check player's permission with announce and sound if player don't have that permission.
     * @param player who I need check him?
     * @param permission player's needed to execute command or do sth.
     * @param sound sound needed to play.
     */
    @NotNull
    public static boolean checkPermission(Player player, String permission, Sound sound) {
        Preconditions.checkArgument(player != null, "You forgot add player to check permission.");
        Preconditions.checkArgument(permission != null, "You forgot add permission to check that.");

        if (player.hasPermission(permission)) {
            return true;
        } else {
            player.sendMessage(message.replaceAll("%permission%", permission));
            return false;
        }
    }

    /**
     * Check player's permission and don't have announced.
     * @param player who I need check him?
     * @param permission player's needed to execute command or do sth.
     */
    @NotNull
    public boolean checkPermissionSilent(Player player, String permission) {
        Preconditions.checkArgument(player != null, "You forgot add player to check permission.");
        Preconditions.checkArgument(permission != null, "You forgot add permission to check.");

        return permission.equalsIgnoreCase("none") || player.hasPermission(permission);
    }

    /**
     * Set message when player don't have permission you want.
     */
    public String setMessage() {
        return message;
    }
}
