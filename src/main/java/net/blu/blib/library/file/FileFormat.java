package net.blu.blib.library.file;

public class FileFormat {

    public enum FileType {

        TEXT(".txt", 0),
        YAML(".yaml",1),
        JSON("json", 2),
        PROPERTIES(".properties", 3);

        private final String format;
        private final int id;
        private final int DEFAULT_TYPE = 2;

        FileType(String format) {
            this.format = format;
            this.id = DEFAULT_TYPE;
        }
        FileType(String format, int id) {
            this.format = format;
            this.id = id;
        }

        public String getFileType() {
            return format;
        }
        public int getId() {
            return id;
        }
    }

    public static final String YAML = FileType.YAML.getFileType();
    public static final String JSON = FileType.JSON.getFileType();
    public static final String PROPERTIES = FileType.PROPERTIES.getFileType();
    public static final String TEXT = FileType.TEXT.getFileType();
}
