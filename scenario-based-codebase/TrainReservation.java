// writte a program of basic train ticket booking system
 
 import java.util.Scanner;
 
 public class TrainReservation{
	 public static void main(String[]args){
		 
		 Scanner sc = new Scanner (System.in);
		 
		 int availableSeats = 50;
		 int seats ;
		 int choice;
		 while(true){
			 
			 if(availableSeats == 0){
				 System.out.println("all seats are booked");
				 break;
			 }
			 System.out.println("choose the reservation and enter number of seats");
			 System.out.println("1. sleeper class");
			 System.out.println("2. Check Available Seats");
			 System.out.println("3. Exit ");			 
			 
			 choice = sc.nextInt();			 
			 
			 switch(choice){
				 case 1:
				 System.out.println("how many seats you want to reserve in sleeper : " );
				 seats = sc.nextInt();
				 if(seats <= availableSeats){
					  availableSeats -= seats;
					  System.out.println("successfully done");
					  System.out.println("remaining seats are : " + availableSeats);
				 }
				 else{
					System.out.println("seats are not available enough"); 					
				 }				 
				break;
				
				case 2:
				System.out.println("available seats are :" + availableSeats );
				break;
				
				case 3:
				System.out.println("thankyou have a nice day ");
				return ;
				
				default :
				System.out.println("invalid choice try again" );
				
				
			 }
			 
		 }
		 
		 
	 }
 }