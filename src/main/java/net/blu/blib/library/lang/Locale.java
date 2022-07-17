package net.blu.blib.library.lang;

public class Locale {

    public enum Country {
        UNITED_STATES("english","en-US"),
        VIETNAM("vietnamese", "vi-VN"),
        CHINA("chinese","zh_CN"),
        HONG_KONG("chinese", "zh_HK");

        private final String language;
        private final String code;

        Country(String language, String code) {
            this.language = language;
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public String getLanguage() {
            return language;
        }
    }

    public static final String ENGLISH = Country.UNITED_STATES.getCode();
    public static final String VIETNAMESE = Country.VIETNAM.getCode();
    public static final String CHINESE = Country.CHINA.getCode();
    public static final String CHINESE_HONG_KONG = Country.HONG_KONG.getCode();

}
