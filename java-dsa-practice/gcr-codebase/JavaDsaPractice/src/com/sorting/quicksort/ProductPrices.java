package com.sorting.quicksort;

import java.util.*;

public class ProductPrices {
	// Performing sorting
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    // find and return pivot element
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Scanner Object
    	Scanner sc = new Scanner(System.in);
    	
    	// Take user input
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int prices[] = new int[n];
        for(int i=0;i<n;i++) {
        	System.out.println("Enter "+ (i+1) +" Price:");
        	prices[i] = sc.nextInt();
        }
        
        System.out.println("\nBefore sorting:");
        System.out.println(Arrays.toString(prices));
        quickSort(prices, 0, prices.length - 1);
        System.out.println("Sorted Price (ascending order):");
        System.out.println(Arrays.toString(prices));
    }
}