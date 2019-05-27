package com.crypterium.cryptApi;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Auth {

    private static final String DEFAULT_FINGERPRINT = UUID.randomUUID().toString();

    private static Map<Class<? extends AuthProvider>, Map<String, AuthProvider>> cache = new HashMap<>();

    private static AuthType defaultType = AuthType.EXWAL;

    public Auth() {

    }

    public static <T extends AuthProvider> T service() {
        return service(DEFAULT_FINGERPRINT);
    }

    @SuppressWarnings("all")
    public static <T extends AuthProvider> T service(String fingerprint) {
        return service(fingerprint, defaultType);
    }

    @SuppressWarnings("all")
    public static <T extends AuthProvider> T service(AuthType type) {
        return (T) getService(DEFAULT_FINGERPRINT, type.service);
    }

    @SuppressWarnings("all")
    public static <T extends AuthProvider> T service(String fingerprint, AuthType type) {
        return (T) getService(fingerprint, type.service);
    }

    private static <T extends AuthProvider> T getService(String fingerprint, Class<T> clazz) {
        Map<String, AuthProvider> serviceCache = cache.getOrDefault(clazz, new HashMap<>());
        AuthProvider service = serviceCache.get(fingerprint);
        if (service == null) {
            try {
                service = clazz.newInstance();
                serviceCache.put(fingerprint, service);
                cache.put(clazz, serviceCache);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("Cannot create service", e);
            }
        }

        return (T) service;
    }

    public static void basic(AuthType type) {
        defaultType = type;
    }

    public enum AuthType {
        EXWAL(ExwalAuth.class),
        EXWAL_V1(ExwalAuthV1.class);

        AuthType(Class<? extends AuthProvider> service) {
            this.service = service;
        }

        private Class<? extends AuthProvider> service;

        public Class<? extends AuthProvider> getService() {
            return service;
        }
    }


}
