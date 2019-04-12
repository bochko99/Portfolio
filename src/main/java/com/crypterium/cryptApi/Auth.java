package com.crypterium.cryptApi;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Auth {

    private static final String DEFAULT_FINGERPRINT = UUID.randomUUID().toString();

    private static Map<String, ExwalAuth> exauthCache = new HashMap<>();

    private static AuthType defaultType = AuthType.EXWAL;

    public Auth() {

    }

    public static ExwalAuth exauth() {
        return exauth(DEFAULT_FINGERPRINT);
    }

    public static ExwalAuth exauth(String fingerprint) {
        ExwalAuth instance = exauthCache.getOrDefault(fingerprint, new ExwalAuth());
        if (!exauthCache.containsKey(fingerprint)) {
            exauthCache.put(fingerprint, instance);
        }
        return instance;
    }

    public static void basic(AuthType type) {
        defaultType = type;
    }

    public static <T extends AuthProvider> T service() {
        return service(DEFAULT_FINGERPRINT);
    }

    @SuppressWarnings("all")
    public static <T extends AuthProvider> T service(String fingerprint) {
        switch (defaultType) {
            case EXWAL:
                return (T) exauth(fingerprint);
        }
        return null;
    }

    public enum AuthType {
        EXWAL, CSHARP
    }


}
