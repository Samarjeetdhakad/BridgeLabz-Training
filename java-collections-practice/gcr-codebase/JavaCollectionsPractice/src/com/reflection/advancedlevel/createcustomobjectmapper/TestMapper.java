package com.reflection.advancedlevel.createcustomobjectmapper;
import java.util.HashMap;
import java.util.Map;

public class TestMapper {
    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", 101);
        data.put("name", "samarjeet");
        data.put("email", "samarjeet@example.com");
        User user = ObjectMapperUtil.toObject(User.class, data);
        user.display();
    }
}