package com.sorting.bubblesort;

import java.util.*;

public class StudentMarks {

    public static void main(String[] args) {
        
    	 Scanner sc = new Scanner(System.in);

         // Input size
         System.out.print("Enter number of students: ");
         int n = sc.nextInt();

         int[] marks = new int[n];

         // Input array elements
         System.out.println("Enter student marks:");
         for (int i = 0; i < n; i++) {
             marks[i] = sc.nextInt();
         }

        // Bubble Sort Logic
        for (int i = 0; i < marks.length - 1; i++) {
            for (int j = 0; j < marks.length - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }

        // Print sorted marks
        System.out.println("Sorted Student Marks:");
        for (int m : marks) {
            System.out.print(m + " ");
        }
    }
}