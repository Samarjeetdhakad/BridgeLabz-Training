package com.reflection.intermediatelevel.accessmodifystaticfields;
public class Configuration {
    private static String API_KEY = "DEFAULT_KEY";
    public static void showKey() {
        System.out.println("API_KEY " + API_KEY);
    }
}