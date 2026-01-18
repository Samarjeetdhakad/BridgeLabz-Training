package com.searchcomparision;

public class Fibonacci{
	
    public static void main(String[] args){
        int n1=10;
        int n2=30;
        int n3=40;
        test(n1);
        test(n2);
        test(n3);
    }
    public static void test(int n){
        long startIter=System.nanoTime();
        int fibIter=fibonacciIterative(n);
        long endIter=System.nanoTime();
        System.out.println("Iterative Result"+fibIter + " Time: " + (endIter - startIter) / 1_000_000.0 + " ms");
        if (n <= 40) {
            long startRec=System.nanoTime();
            int fibRec=fibonacciRecursive(n);
            long endRec=System.nanoTime();
            System.out.println("Recursive Result: " + fibRec +  "Time"+(endRec - startRec) / 1_000_000.0 + " ms");
        }
        else {
            System.out.println("Recursive Result: Not computed (too slow)");
    }
    }
    public static int fibonacciRecursive(int n) {
        if (n<=1) return n;
        return fibonacciRecursive(n-1) +fibonacciRecursive(n-2);
    }
    public static int fibonacciIterative(int n) {
        if (n<=1) return n;

        int a=0, b=1, sum;
        for (int i=2; i<=n;i++) {
            sum=a+b;
            a=b;
            b=sum;
        }
        return b;
 }
}