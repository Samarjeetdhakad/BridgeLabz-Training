package com.sorting.selectionsort;

import java.util.Scanner;

public class ExamScores {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Input size
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        // Input array
        System.out.println("Enter exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // Selection Sort Logic
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap minimum with first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }

        // Output
        System.out.println("Sorted Exam Scores (Ascending Order):");
        for (int s : scores) {
            System.out.print(s + " ");
        }
    }
}