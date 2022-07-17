package net.blu.blib.library;

public class bLibrary {

    /**
     * Removes the first spaces of a line.
     * @param string the input line
     * @return the line without the first spaces
     */
    public static String removeSpace(String string) {
        String startLine = string;
        try {
            while (string.charAt(0) == ' ') string = string.substring(1);
            return string;
        } catch (IndexOutOfBoundsException e) {
            return startLine;
        }
    }
}
