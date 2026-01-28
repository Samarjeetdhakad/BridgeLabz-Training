package com.reflection.advancedlevel.jsonrepresentation;

public class TestJson {

    public static void main(String[] args) {

        Person p = new Person(101, "samarjeet", true);

        String json = JsonUtil.toJson(p);
        System.out.println(json);
    }
}