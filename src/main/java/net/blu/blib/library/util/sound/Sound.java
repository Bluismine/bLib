package net.blu.blib.library.util.sound;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public abstract class Sound {

    private Plugin plugin;
    private float volume = 2.0f;
    private float pitch = 2.0f;

    @NotNull
    public void playSound(Player player, org.bukkit.Sound sound) {
        Bukkit.getScheduler().runTask(plugin , () -> player.playSound(player, sound, 2.0f, 2.0f));
    }

    public @NotNull void playSound(Player player, FileConfiguration fileName, String path) {
        final String sound = fileName.getString(path);
        if (sound == null || sound.equalsIgnoreCase("none")) return;
        Bukkit.getScheduler().runTask(plugin , () -> player.playSound(player, org.bukkit.Sound.valueOf(sound), volume, 2.0f));
    }

    @NotNull
    public float setVolume(float volume) {
        return this.volume = volume;
    }

    public float getVolume() {
        return this.volume;
    }

    @NotNull
    public float setPitch (float pitch) {
        return this.pitch = pitch;
    }

    public float getPitch() {
        return this.pitch;
    }

    public void setupSound(Plugin plugin) {
        this.plugin = plugin;
    }
}
