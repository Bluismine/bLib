package net.blu.blib.library.util.sound;

import net.blu.blib.API.SoundAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Sound implements SoundAPI {

    private final JavaPlugin plugin;
    private float volume = 2.0f;
    private float pitch = 2.0f;

    public Sound(JavaPlugin mainClass) {
        this.plugin = mainClass;
    }

    @Override
    @NotNull
    public void playSound(Player player, org.bukkit.Sound sound) {
        Bukkit.getScheduler().runTask(plugin , () -> player.playSound(player, sound, 2.0f, 2.0f));
    }

    @Override
    public @NotNull void playSound(Player player, FileConfiguration fileName, String path) {
        final String sound = fileName.getString(path);
        if (sound == null || sound.equalsIgnoreCase("none")) return;
        Bukkit.getScheduler().runTask(plugin , () -> player.playSound(player, org.bukkit.Sound.valueOf(sound), volume, 2.0f));
    }

    @Override
    @NotNull
    public float setVolume(float volume) {
        return this.volume = volume;
    }

    @Override
    public float getVolume() {
        return this.volume;
    }

    @Override
    @NotNull
    public float setPitch (float pitch) {
        return this.pitch = pitch;
    }

    @Override
    public float getPitch() {
        return this.pitch;
    }
}
