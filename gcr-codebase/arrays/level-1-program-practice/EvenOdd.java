//Create a program to save odd and even numbers into odd and even arrays between 1 to the number entered by the user. Finally, print the odd and even numbers array
import java.util.Scanner;
public class EvenOdd{
   public static void main(String[]args){
   
    Scanner sc=new Scanner(System.in);
	int number=sc.nextInt();
	if(number<0){
	System.out.println("error");
	}
	
	//create two arrays for odd numbers and even numbers
	int  oddNumbers[]=new int[number / 2 + 1];
	int evenNumbers[]=new int[number / 2 + 1];
	
	//create two indexes
	int oddIndex=0;
	int evenIndex=0;
	
	for(int i=1;i<=number;i++){
	if(i%2==0){
	evenNumbers[evenIndex]=i;
	evenIndex++;
	}
	else{
	oddNumbers[oddIndex]=i;
	oddIndex++;
	  }
	}
	
	        
        
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();

       
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();
   }
}   