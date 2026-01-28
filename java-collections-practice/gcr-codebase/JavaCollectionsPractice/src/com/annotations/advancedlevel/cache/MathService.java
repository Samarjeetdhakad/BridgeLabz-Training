package com.annotations.advancedlevel.cache;

public class MathService {
    @CacheResult
    public int expensiveCalculation(int n) {
        System.out.println("Computing result for " + n);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return n * n;
    }
}