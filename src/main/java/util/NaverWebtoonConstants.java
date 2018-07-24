package util;

/**
 * @author owen151128
 *         Created by owen151128 on 2018. 6. 11..
 *         <p>
 *         Naver webtoon Constants class
 */
public class NaverWebtoonConstants {

    /**
     * Used FileUtil.java
     */
    public static class File {
        public static String HOME_DIRECTORY = "user.home";
        public static String CACHE_DIRECTORY = ".cache";
        public static String CACHE_FILE = "cache";
        public static String DESKTOP_DIRECTORY = "Desktop";
        public static String WEBTOON_HTML = "webtoon.html";
        public static String HTML_START = "<html>\n<head>\n<title>";
        public static String HTML_TITLE_END = "</title>\n</head>\n<body>\n";
        public static String IMG_START = "<img src=\"";
        public static String HTML_JPG = ".jpg";
        public static String IMG_END = "\" style=\"margin-left: auto; margin-right: auto; display: block;\"/>\n<br/>\n";
        public static String PREV_START = "<div style=\"text-align: center;\" ><a href=\"../";
        public static String PREV_END = "/" + WEBTOON_HTML + "\" >이전화</a>&nbsp;&nbsp;";
        public static String NEXT_START = "<a href=\"../";
        public static String NEXT_END = "/" + WEBTOON_HTML + "\" >다음화</a></div>";
        public static String HTML_END = "</body></html>";


    }

    /**
     * Used NaverWebtoonUtil.java
     */
    public static class Util {
        public static String ACCEPT = "Accept";
        public static String ACCEPT_ENCODING = "Accept-Encoding";
        public static String ACCEPT_LANGUAGE = "Accept-Language";
        public static String UPGRADE_INSECURE_REQUESTS = "Upgrade-Insecure-Requests";
        public static String USER_AGENT = "User-Agent";
        public static String ACCEPT_VALUE = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8";
        public static String ACCEPT_ENCODING_VALUE = "gzip, deflate";
        public static String Accept_LANGUAGE_VALUE = "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7";
        public static String UPGRADE_INSECURE_REQUESTS_VALUE = "1";
        public static String USER_AGENT_VALUE = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.79 Safari/537.36";
        public static int TIME_OUT = 5000;
    }

    /**
     * Used NaverWebtoonParser.java
     */
    public static class Parser {
        public static String IMAGE_SELECTOR = "img[alt='comic content']";
        public static String SRC = "src";
    }

}
