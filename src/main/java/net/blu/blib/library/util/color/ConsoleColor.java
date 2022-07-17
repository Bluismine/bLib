package net.blu.blib.library.util.color;

/**
 * Color for console.
 */
public class ConsoleColor {
    private final String name;
    private final String code;

    public static final String BLACK = String.valueOf(new ConsoleColor("black", "\u001b[30m"));
    public static final String RED = String.valueOf(new ConsoleColor("red", "\u001b[31m"));
    public static final String GREEN = String.valueOf(new ConsoleColor("green", "\u001b[32m"));
    public static final String YELLOW = String.valueOf(new ConsoleColor("yellow", "\u001b[33m"));
    public static final String BLUE = String.valueOf(new ConsoleColor("blue", "\u001b[34m"));
    public static final String PURPLE = String.valueOf(new ConsoleColor("purple", "\u001b[35m"));
    public static final String LIGHT_BLUE = String.valueOf(new ConsoleColor("light blue", "\u001b[36m"));
    public static final String WHITE = String.valueOf(new ConsoleColor("white", "\u001b[36m"));
    public static final String BOLD = String.valueOf(new ConsoleColor("blod", "\u001b[1m"));
    public static final String RESET = String.valueOf(new ConsoleColor("reset", "\u001b[0m"));

    private ConsoleColor(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
