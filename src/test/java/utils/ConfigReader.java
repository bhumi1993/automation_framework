package test.java.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";
    private static Properties properties;

    static {
        try {
            FileInputStream configFile = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(configFile);
            configFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
