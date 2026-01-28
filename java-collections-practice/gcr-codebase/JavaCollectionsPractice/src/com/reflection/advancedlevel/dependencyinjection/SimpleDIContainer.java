package com.reflection.advancedlevel.dependencyinjection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleDIContainer {
    private Map<Class<?>, Object> objectPool = new HashMap<>();
    public <T> T getBean(Class<T> clazz) {
        try {
            // Create object if not exists
            if (!objectPool.containsKey(clazz)) {
                objectPool.put(clazz, clazz.getDeclaredConstructor().newInstance());
            }
            T obj = clazz.cast(objectPool.get(clazz));

            // Inject dependencies
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> dependencyType = field.getType();

                    // Create dependency if not exists
                    if (!objectPool.containsKey(dependencyType)) {
                        objectPool.put(dependencyType,
                                dependencyType.getDeclaredConstructor().newInstance());
                    }
                    field.setAccessible(true);
                    field.set(obj, objectPool.get(dependencyType));
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Dependency Injection failed", e);
        }
    }
}