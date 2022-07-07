package net.blu.blib.api.util;

public enum Color {

    BLACK("\u001b[30m"),
    RED("\u001b[31m"),
    GREEN("\u001b[32m"),
    YELLOW("\u001b[33m"),
    BLUE("\u001b[34m"),
    PURPLE("\u001b[35m"),
    LIGHT_BLUE("\u001b[36m"),
    WHITE("\u001b[37m"),
    BOLD("\u001b[1m"),
    RESET("\u001b[0m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getColor() {
        return this.code;
    }
}
