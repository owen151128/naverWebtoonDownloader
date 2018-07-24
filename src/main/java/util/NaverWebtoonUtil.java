package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author owen151128
 *         Created by owen151128 on 2018. 6. 11..
 *         <p>
 *         Naver webtoon util
 */
public class NaverWebtoonUtil {
    /**
     * Java single-tone pattern instance
     */
    private static NaverWebtoonUtil instance;

    /**
     * FileUtil Global instance;
     */
    private FileUtil fileUtil;

    private Map<String, String> headers;

    private NaverWebtoonUtil() {
        fileUtil = FileUtil.getInstance();
        headers = new HashMap<String, String>();
        headers.put(NaverWebtoonConstants.Util.ACCEPT, NaverWebtoonConstants.Util.ACCEPT_VALUE);
        headers.put(NaverWebtoonConstants.Util.ACCEPT_ENCODING, NaverWebtoonConstants.Util.ACCEPT_ENCODING_VALUE);
        headers.put(NaverWebtoonConstants.Util.ACCEPT_LANGUAGE, NaverWebtoonConstants.Util.Accept_LANGUAGE_VALUE);
        headers.put(NaverWebtoonConstants.Util.UPGRADE_INSECURE_REQUESTS, NaverWebtoonConstants.Util.UPGRADE_INSECURE_REQUESTS_VALUE);
        headers.put(NaverWebtoonConstants.Util.USER_AGENT, NaverWebtoonConstants.Util.USER_AGENT_VALUE);
    }

    /**
     * Single-tone pattern
     *
     * @return {@link NaverWebtoonUtil} instance
     */
    public static synchronized NaverWebtoonUtil getInstance() {
        if (instance == null)
            instance = new NaverWebtoonUtil();
        return instance;
    }

    /**
     * Get Webtoon from URL
     *
     * @param url Webtoon URL
     * @return Document resultDocument
     */
    public Document getWebtoon(String url) {
        try {
            return Jsoup.connect(url).headers(headers).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Set HttpURLConnection time_out, headers
     *
     * @param target Target URL
     * @return Build connection
     * @throws IOException
     */
    private HttpURLConnection setConnection(URL target) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) target.openConnection();

        connection.setConnectTimeout(NaverWebtoonConstants.Util.TIME_OUT);
        connection.setReadTimeout(NaverWebtoonConstants.Util.TIME_OUT);
        connection.setRequestProperty(NaverWebtoonConstants.Util.ACCEPT, NaverWebtoonConstants.Util.ACCEPT_VALUE);
        connection.setRequestProperty(NaverWebtoonConstants.Util.ACCEPT_ENCODING, NaverWebtoonConstants.Util.ACCEPT_ENCODING_VALUE);
        connection.setRequestProperty(NaverWebtoonConstants.Util.ACCEPT_LANGUAGE, NaverWebtoonConstants.Util.Accept_LANGUAGE_VALUE);
        connection.setRequestProperty(NaverWebtoonConstants.Util.UPGRADE_INSECURE_REQUESTS, NaverWebtoonConstants.Util.UPGRADE_INSECURE_REQUESTS_VALUE);
        connection.setRequestProperty(NaverWebtoonConstants.Util.USER_AGENT, NaverWebtoonConstants.Util.USER_AGENT_VALUE);

        return connection;
    }

    /**
     * Download webtoon & make web html view by parsed webtoonList
     *
     * @param title       Webtoon title
     * @param index       Webtoon episode
     * @param webtoonList Parsed webtoonList
     * @return Success
     */
    public boolean downloadWebtoon(String title, int index, ArrayList<String> webtoonList) {
        URL target;
        HttpURLConnection connection;
        int i = 1;
        try {
            for (String s : webtoonList) {
                target = new URL(s);
                connection = setConnection(target);
                connection.connect();
                fileUtil.writeImage(connection.getInputStream(), title, index, i + ".jpg");
                i++;
            }
            fileUtil.writeHtml(title, index, webtoonList.size());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

}
