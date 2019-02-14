package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Environment {

    private static Properties props = new Properties();
    public static final Map<String, CredentialEntry> CREDENTIALS = new HashMap<>();

    static {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties")) {
            props.load(is);

            props.entrySet().stream().filter(e -> e.getKey().toString().startsWith("credentials")).forEach(e -> {
                String key = e.getKey().toString();
                String value = e.getValue().toString();

                String[] parts = key.split("\\.");
                String type;
                String keyword;
                // like credentials.login = qwe, type = default, keyword = login
                if (parts.length == 2) {
                    type = "default";
                    keyword = parts[1];
                } else {
                    //like credentials.au.login, type = au, keyword = login
                    type = parts[1];
                    keyword = parts[2];
                }
                CredentialEntry crnt = CREDENTIALS.getOrDefault(type, new CredentialEntry());
                if ("login".equalsIgnoreCase(keyword)) {
                    crnt.setLogin(value);
                } else if ("password".equalsIgnoreCase(keyword)) {
                    crnt.setPassword(value);
                }
                crnt.setType(type);
                CREDENTIALS.put(type, crnt);
            });

        } catch (IOException e) {
            throw new RuntimeException("Cannot parse application.properties", e);
        }
    }

    static String getProp(String key) {
        return props.getProperty(key);
    }


    public static final String TARGET = props.getProperty("target", "BETA");
    public static final String FINANCE_OPERATIONS_ALLOWED = props.getProperty("allowFinanceOperations", "false");
    public static final String BASE_PATH = props.getProperty("basePath", Constants.MOBILE);
    public static final String BASE_URL = props.getProperty("baseUrl", Constants.BETA);
    public static final String MANAGEMENT_URL = props.getProperty("managementUrl", BASE_URL);
    public static final String KYC_URL = props.getProperty("kycUrl", "https://kyc.crypterium.io");
    public static final String GL_URL = props.getProperty("gl.url", "");
    public static final String GL_TOKEN = props.getProperty("gl.token", "");
    public static final String GL_EXPECTED_ACCOUNT_COUNT = props.getProperty("gl.account_count", "40");
    public static void main(String[] args) {
        System.out.println("123");
    }
}
