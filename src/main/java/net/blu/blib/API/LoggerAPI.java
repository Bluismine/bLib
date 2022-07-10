package net.blu.blib.API;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface LoggerAPI {


    @NotNull void sendInfoLog(String message);
    @NotNull void sendWarningLog(String message);
    @NotNull void sendMessage(CommandSender commandSender, String message);
    @NotNull void setPrefix(@NotNull String Prefix);

    String getPrefix();
}
