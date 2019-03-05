package com.crypterium.cryptApi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Environment {

    private static Properties props = new Properties();
    private static final Map<String, CredentialEntry> CREDENTIALS_INIT = new HashMap<>();

    static {
        try (InputStream is = Environment.class.getClassLoader().getResourceAsStream("application.properties")) {
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
                CredentialEntry crnt = CREDENTIALS_INIT.getOrDefault(type, new CredentialEntry());
                if ("login".equalsIgnoreCase(keyword)) {
                    crnt.setLogin(value);
                } else if ("password".equalsIgnoreCase(keyword)) {
                    crnt.setPassword(value);
                }
                crnt.setType(type);
                CREDENTIALS_INIT.put(type, crnt);
            });

        } catch (IOException e) {
            throw new RuntimeException("Cannot parse application.properties", e);
        }
    }

    static String getProp(String key) {
        return props.getProperty(key);
    }

    public static final Map<String, CredentialEntry> CREDENTIALS = Collections.unmodifiableMap(CREDENTIALS_INIT);
    public static final String TARGET = props.getProperty("target", "BETA");
    public static final String FINANCE_OPERATIONS_ALLOWED = props.getProperty("allowFinanceOperations", "false");
    public static final String BASE_PATH = props.getProperty("basePath", Constants.MOBILE);
    public static final String BASE_URL = props.getProperty("baseUrl", Constants.BETA);
    public static final String MANAGEMENT_URL = props.getProperty("managementUrl", BASE_URL);
    public static final String KYC_URL = props.getProperty("kycUrl", "https://kyc.crypterium.io");
    public static final String CARD_PREORDER = props.getProperty("cardPreorderUrl", "https://crpt-back-develop.testessential.net");
    public static final String EXWAL_BASE_URL = props.getProperty("exwalUrl",Constants.EXWAL);

    public static final String GL_URL = props.getProperty("gl.url", "");
    public static final String GL_TOKEN = props.getProperty("gl.token", "");
    public static final String GL_EXPECTED_ACCOUNT_COUNT = props.getProperty("gl.account_count", "40");
    public static void main(String[] args) {
        System.out.println("123");
    }
}
