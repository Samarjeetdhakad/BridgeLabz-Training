import java.util.Scanner;
public class GcdLcm{
    public static int findGCD(int a,int b) 
	{
        while(b!=0) {
            int temp=b;
            b=a%b;
            a=temp;
     }
        return a;
 }
    public static int findLCM(int a,int b){
        return (a*b)/findGCD(a, b);
      }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();

        int gcd=findGCD(num1, num2);
        int lcm=findLCM(num1, num2);
        System.out.println( gcd);
        System.out.println( lcm);
  }
}
