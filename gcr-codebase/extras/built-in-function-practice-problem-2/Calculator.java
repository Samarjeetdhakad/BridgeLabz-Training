import java.util.Scanner;
public class Calculator{
public static int addition(int a,int b){

return a+b;
}
public static int subtraction(int a,int b){

return a-b;
}
public static int multiplication(int a,int b){

return a*b;
}
public static double division(int a,int b){
	if(b==0)  {
          System.out.println("invalid ");
            return 0;
     }
        return (double) a/b; 
  }

  public static void main(String[]args){
   Scanner sc=new Scanner(System.in);
   int a=sc.nextInt();
   int b=sc.nextInt();
   System.out.println("Addition of 2 numbers" + addition(a,b));
    System.out.println("Subtraction of 2 numbers" + subtraction(a,b));
	 System.out.println("Multiplication of 2 numbers" + multiplication(a,b));
	  System.out.println("Division of 2 numbers" + division(a,b));
	  }
	  }
   