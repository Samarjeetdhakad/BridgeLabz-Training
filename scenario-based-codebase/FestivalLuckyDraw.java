import java.util.Scanner;

public class FestivalLuckyDraw {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        char moreVisitors ='y';

        while(moreVisitors=='y'||moreVisitors=='Y') {

            System.out.print("Enter your lucky draw number:");
            int number=sc.nextInt();

            if(number <= 0){
                System.out.println("Invalid number Try again");
                continue; 
            }

            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println(" Congratulations You won a gift");
            } else {
                System.out.println("Sorry Better luck next time.");
            }

            System.out.print("Is there another visitor? (y/n): ");
            moreVisitors = sc.next().charAt(0);
        }

        System.out.println("Lucky draw ended");
        
    }
}
