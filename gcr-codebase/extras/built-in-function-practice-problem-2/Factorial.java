import java.util.Scanner;
public class Factorial{
public static int factorialRecursion(int number){
if(number<1){
return 1;
}
return number* factorialRecursion(number-1);
}
   public static void main(String []args){
   Scanner sc=new Scanner(System.in);
   int number=sc.nextInt();
   int result=factorialRecursion(number);
   System.out.println(result);
   }
   }