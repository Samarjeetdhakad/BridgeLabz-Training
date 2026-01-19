package hospitalqueue;

import java.util.Scanner;


public class Main {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n =5;
		
		Patient[]  patients = new Patient[5];
		
		for(int i=0; i<5; i++) {
			System.out.println("Enter patient name : ");
			String name = sc.nextLine();
			System.out.println("Enter the criticality");
			int criticality = sc.nextInt();
			
			sc.nextLine();
			
			patients[i] = new Patient (name,criticality);
		}
		
		 System.out.println("Before Sorting:");
	        HospitalQueue.printPatients(patients, n);

	        HospitalQueue.criticalitySort(patients, n);

	        System.out.println("\nAfter Sorting:");
	        HospitalQueue.printPatients(patients, n);
	        
	        sc.close();
	}

}