package net.blu.blib.API;

import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface SoundAPI {

    @NotNull
    void playSound(Player player, Sound sound);
    @NotNull
    void playSound(Player player, FileConfiguration fileName, String path);
    @NotNull
    float setVolume(float volume);
    @NotNull
    float getVolume();
    @NotNull
    float setPitch(float pitch);
    @NotNull
    float getPitch();
}
