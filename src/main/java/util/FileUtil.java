package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author owen151128
 *         Created by owen151128 on 2018. 7. 22..
 *         File I/O Util
 */
public class FileUtil {
    /**
     * Java single-tone pattern instance
     */
    private static FileUtil instance;

    private FileUtil() {
    }

    /**
     * Single-tone pattern
     *
     * @return {@link FileUtil} instance
     */
    public static synchronized FileUtil getInstance() {
        if (instance == null)
            instance = new FileUtil();
        return instance;
    }

    /**
     * Write cache $HOME/.cache/cache
     *
     * @param data String data
     * @return Success
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public boolean writeCache(String data) {
        File cache = new File(System.getProperty(NaverWebtoonConstants.File.HOME_DIRECTORY) + File.separator + NaverWebtoonConstants.File.CACHE_DIRECTORY);
        FileWriter fw = null;
        try {
            if (!cache.exists()) {
                cache.mkdir();
            } else {
                cache = new File(System.getProperty(NaverWebtoonConstants.File.HOME_DIRECTORY) +
                        File.separator + NaverWebtoonConstants.File.CACHE_DIRECTORY + File.separator + NaverWebtoonConstants.File.CACHE_FILE);
                cache.createNewFile();
            }
            fw = new FileWriter(cache);
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (fw != null)
                fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Read cache $HOME/.cache/cache
     *
     * @return read cache
     */
    public String readCache() {
        StringBuilder result = new StringBuilder();
        FileReader fr = null;
        BufferedReader br = null;
        File cache = new File(System.getProperty(NaverWebtoonConstants.File.HOME_DIRECTORY) +
                File.separator + NaverWebtoonConstants.File.CACHE_DIRECTORY + File.separator + NaverWebtoonConstants.File.CACHE_FILE);
        try {
            fr = new FileReader(cache);
            br = new BufferedReader(fr);
            String buffer;
            while ((buffer = br.readLine()) != null)
                result.append(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result.toString();
    }

    /**
     * Inputstram image url to file
     *
     * @param inputStream imageUrl http connection to inputStream
     * @param parentPath  Parent fiile name
     * @param filePath    Webtoon episode
     * @param fileName    Save file name
     * @return Success
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public boolean writeImage(InputStream inputStream, String parentPath, int filePath, String fileName) {
        File target = new File(System.getProperty(NaverWebtoonConstants.File.HOME_DIRECTORY) +
                File.separator + NaverWebtoonConstants.File.DESKTOP_DIRECTORY + File.separator + parentPath);
        try {
            if (!target.exists())
                target.mkdir();
            target = new File(System.getProperty(NaverWebtoonConstants.File.HOME_DIRECTORY) +
                    File.separator + NaverWebtoonConstants.File.DESKTOP_DIRECTORY + File.separator + parentPath + File.separator + filePath);
            if (!target.exists()) {
                target.mkdir();
                target = new File(System.getProperty(NaverWebtoonConstants.File.HOME_DIRECTORY) +
                        File.separator + NaverWebtoonConstants.File.DESKTOP_DIRECTORY + File.separator + parentPath + File.separator + filePath + File.separator + fileName);
            } else {
                target = new File(System.getProperty(NaverWebtoonConstants.File.HOME_DIRECTORY) +
                        File.separator + NaverWebtoonConstants.File.DESKTOP_DIRECTORY + File.separator + parentPath + File.separator + filePath + File.separator + fileName);
            }
            Files.copy(inputStream, Paths.get(target.toURI()));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Write webtoon view html
     *
     * @param parentPath      Webtoon title
     * @param filePath        Webtoon episode
     * @param webtoonListSize Count of webtoon image
     * @return Success
     */
    public boolean writeHtml(String parentPath, int filePath, int webtoonListSize) {
        File target = new File(System.getProperty(NaverWebtoonConstants.File.HOME_DIRECTORY) +
                File.separator + NaverWebtoonConstants.File.DESKTOP_DIRECTORY +
                File.separator + parentPath + File.separator + filePath + File.separator + NaverWebtoonConstants.File.WEBTOON_HTML);
        try {
            FileWriter fw = new FileWriter(target);
            fw.write(NaverWebtoonConstants.File.HTML_START);
            fw.write(parentPath + " " + filePath + "화");
            fw.write(NaverWebtoonConstants.File.HTML_TITLE_END);

            for (int i = 1; i <= webtoonListSize; i++) {
                fw.write(NaverWebtoonConstants.File.IMG_START);
                fw.write(i + NaverWebtoonConstants.File.HTML_JPG);
                fw.write(NaverWebtoonConstants.File.IMG_END);
            }
            fw.write(NaverWebtoonConstants.File.PREV_START);
            fw.write(filePath - 1 + "");
            fw.write(NaverWebtoonConstants.File.PREV_END);
            fw.write(NaverWebtoonConstants.File.NEXT_START);
            fw.write(filePath + 1 + "");
            fw.write(NaverWebtoonConstants.File.NEXT_END);
            fw.write(NaverWebtoonConstants.File.HTML_END);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
