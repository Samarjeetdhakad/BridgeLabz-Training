package com.annotations.advancedlevel.jsonfield;
import java.lang.reflect.Field;

public class JsonSerializer{
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        boolean first = true;

        try {
            for (Field field:fields){
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    JsonField jf = field.getAnnotation(JsonField.class);

                    if (!first) {
                        json.append(", ");
                    }
                    json.append("\"")
                        .append(jf.name())
                        .append("\": ");

                    Object value = field.get(obj);
                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }
                    first = false;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        json.append("}");
        return json.toString();
    }
}