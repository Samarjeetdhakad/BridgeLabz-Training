package com.linkedlist.singlylinkedlist.studentrecordmanagementsystem;

import java.util.Scanner;

public class StudentMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        int choice;

        do {
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at Last");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll: ");
                    int r1 = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String n1 = sc.next();
                    System.out.print("Enter Age: ");
                    int a1 = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char g1 = sc.next().charAt(0);

                    list.addAtBeginning(r1, n1, a1, g1);
                    break;

                case 2:
                    System.out.print("Enter Roll: ");
                    int r2 = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String n2 = sc.next();
                    System.out.print("Enter Age: ");
                    int a2 = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char g2 = sc.next().charAt(0);

                    list.addAtEnd(r2, n2, a2, g2);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter Roll: ");
                    int r3 = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String n3 = sc.next();
                    System.out.print("Enter Age: ");
                    int a3 = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char g3 = sc.next().charAt(0);

                    list.addAtPosition(pos, r3, n3, a3, g3);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    int delRoll = sc.nextInt();
                    list.deleteByRollNumber(delRoll);
                    break;

                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = sc.nextInt();
                    list.search(searchRoll);
                    break;

                case 6:
                    System.out.print("Enter Roll Number: ");
                    int updRoll = sc.nextInt();
                    System.out.print("Enter New Grade: ");
                    char newGrade = sc.next().charAt(0);
                    list.updateGrade(updRoll, newGrade);
                    break;

                case 7:
                    list.display();
                    break;

                case 0:
                    System.out.println("Exiting Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

    }
}