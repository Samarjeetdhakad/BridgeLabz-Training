package com.annotations.deprecated;

public class TestLegacyAPI {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();   
        api.newFeature();   
    }
}