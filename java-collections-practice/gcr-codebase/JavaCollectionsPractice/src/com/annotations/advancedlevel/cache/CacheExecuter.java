package com.annotations.advancedlevel.cache;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheExecuter {
    // Simple in-memory cache
    private static final Map<String, Object> cache = new HashMap<>();
    public static Object execute(Object obj, String methodName, Object... args) {
        try {
            Class<?> cls = obj.getClass();
            Method method = cls.getMethod(methodName, int.class);

            // Build cache key 
            String cacheKey = methodName + "_" + args[0];
            if (method.isAnnotationPresent(CacheResult.class)) {
                // If cached value exists
                if (cache.containsKey(cacheKey)) {
                    System.out.println("Returning cached result for " + args[0]);
                    return cache.get(cacheKey);
                }
                // Compute & cache result
                Object result = method.invoke(obj, args);
                cache.put(cacheKey, result);
                return result;
            }
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}