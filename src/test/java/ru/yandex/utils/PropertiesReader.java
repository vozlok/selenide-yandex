package ru.yandex.utils;

import java.io.*;
import java.util.Properties;

/**
 * Created by kai on 07.02.2017.
 */
public class PropertiesReader {

    protected final static Properties prop = new Properties();

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    public static void readPropertiesFile() throws IOException {
        InputStream inputStream = CustomExternalResource.class.getClassLoader().getResourceAsStream("dynamic.properties");
        try {
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            try {
                prop.load(reader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } finally {
            inputStream.close();
        }
    }
}
