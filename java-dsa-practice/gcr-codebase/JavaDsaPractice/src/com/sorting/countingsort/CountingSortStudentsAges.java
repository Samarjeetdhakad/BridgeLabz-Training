package com.sorting.countingsort;

import java.util.*;

public class CountingSortStudentsAges {
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int size = sc.nextInt();
        int[] ages = new int[size];
        
        for (int i = 0; i < size; i++) {
            ages[i] = sc.nextInt();
        }


        int minAge = 10;
        int maxAge = 18;

        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        //  Count frequency
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        //  Build output array
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        System.out.println(Arrays.toString(output));
    }
}
