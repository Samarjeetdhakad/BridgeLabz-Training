package com.annotations.advancedlevel.cache;

public class TestCache {
    public static void main(String[] args) {
        MathService service = new MathService();

        System.out.println(CacheExecuter.execute(service, "expensiveCalculation", 5));
        System.out.println(CacheExecuter.execute(service, "expensiveCalculation", 5)); // cached
        System.out.println(CacheExecuter.execute(service, "expensiveCalculation", 7));
        System.out.println(CacheExecuter.execute(service, "expensiveCalculation", 7)); // cached
    }
}