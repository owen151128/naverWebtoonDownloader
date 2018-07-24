package util;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * @author owen151128
 *         Created by owen151128 on 2018. 6. 11..
 *
 *         Naver webtoon parser
 */
public class NaverWebtoonParser {
    /**
     * Java single-tone pattern instance
     */
    private static NaverWebtoonParser instance;

    private NaverWebtoonParser() {
    }

    /**
     * Single-tone pattern
     *
     * @return {@link NaverWebtoonParser} instance
     */
    public static synchronized NaverWebtoonParser getInstance() {
        if (instance == null)
            instance = new NaverWebtoonParser();
        return instance;
    }

    /**
     * Parse webtoon image url & return url list
     *
     * @param document Jsoup document
     * @return Url list
     */
    public ArrayList<String> parseWebtoonImageUrl(Document document) {
        ArrayList<String> result = new ArrayList<String>();

        Elements elements = document.select(NaverWebtoonConstants.Parser.IMAGE_SELECTOR);

        for (Element e : elements)
            result.add(e.attr(NaverWebtoonConstants.Parser.SRC));

        return result;
    }
}
