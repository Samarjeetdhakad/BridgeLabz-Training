package com.stackqueuehashmapandhashingfunction.hashmapandhashfunction;


import java.util.HashSet;
import java.util.Scanner;

public class PairWithGivenSum {
    // hasPair in given array
    public static boolean hasPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (set.contains(complement)) {
                System.out.println("Pair found: ("+ num + "," + complement + ")");
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // take input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        // output
        System.out.println(hasPair(arr, target));
    }
}