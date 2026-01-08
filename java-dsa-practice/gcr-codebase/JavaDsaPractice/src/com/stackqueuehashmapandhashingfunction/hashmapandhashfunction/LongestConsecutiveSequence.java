package com.stackqueuehashmapandhashingfunction.hashmapandhashfunction;

import java.util.*;

class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            // Start sequence only if previous number is absent
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);

         System.out.print("Enter size of array: ");
         int n = sc.nextInt();

         int[] nums = new int[n];
         System.out.println("Enter array elements:");
         for (int i = 0; i < n; i++) {
             nums[i] = sc.nextInt();
         }

         System.out.println("Longest Consecutive Length: " + longestConsecutive(nums));
    }
}