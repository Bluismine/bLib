package org.blu.blib.Util;

public enum CommandLineColor {

    BLACK("black", "\u001B[30m"),
    RED("red", "\u001B[31m"),
    GREEN("green", "\u001B[32m"),
    YELLOW("yellow", "\u001B[33m"),
    BLUE("blue", "\u001B[34m"),
    PURPLE("purple", "\u001B[35m"),
    CYAN("cyan", "\u001B[36m"),
    WHITE("white", "\u001B[37m"),
    BOLD("bold", "\u001b[1m"),
    RESET("reset", "\u001B[0m");

    private final String name;
    private final String code;

    CommandLineColor(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getColor() {
        return this.code;
    }
}
