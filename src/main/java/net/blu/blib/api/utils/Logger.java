package net.blu.blib.api.utils;

import org.jetbrains.annotations.NotNull;

public interface Logger {

    void setPrefix(@NotNull String Prefix);

    String getPrefix();
}
