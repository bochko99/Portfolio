package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Environment {

    private static Properties props = new Properties();

    static {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties")) {
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Cannot parse application.properties", e);
        }
    }

    static String getProp(String key) {
        return props.getProperty(key);
    }

    public static final String BASE_PATH = props.getProperty("basePath", ConstantHelper.MOBILE);
    public static final String BASE_URL = props.getProperty("baseUrl", ConstantHelper.BETA);
    public static final String BASE_LOGIN = props.getProperty("login", ConstantHelper.DEFAULT_LOGIN);
    public static final String BASE_PASSWORD = props.getProperty("password", ConstantHelper.DEFAULT_PASSWORD);
}
