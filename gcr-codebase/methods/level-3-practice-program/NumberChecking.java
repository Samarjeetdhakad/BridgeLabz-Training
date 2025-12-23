import java.util.Scanner;
public NumberChecking{
  public static int digitCount(int number){
  if(number==0) return 1;
   int count=0;
   number=Math.abs(number);
   while(number>0){
   count++;
 number=number/10;
 }
 return count;
 }
  public static int[] digitArray(int number){
  int count=digitCount(number);
  int digits[]=new int[count];
  
  number=Math.abs(number);
  for(int i=count-1;i>=0;i--){
  digits[i]=number%10;
 number/=10;
 }
 return digits;
 }
   public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }
 public static int sumSquare(int[]digits){
 int sum=0;
 for(int d:digits){
 sum+=(int) Math.pow(d,2);
 }
 return sum;
 }
 public static boolean harshadNumber(int number,int[]digits){
 int sum=sumDigits(digits);
 return sum!=0 && number%sum==0;
 
 }
 public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
            freq[i][1] = 0;
        }

        for (int d : digits) {
            freq[d][1]++;
      }
        return freq;
    }

   
   public static void main(String[]args){
   
   Scanner sc = new Scanner(System.in);

      
        int number = sc.nextInt();
        int digitCount = countDigits(number);
        int[] digits = getDigitsArray(number);

        System.out.print("Digits array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println("\nSum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(digits));

        if (isHarshadNumber(number, digits)) {
            System.out.println(number + " is a Harshad Number");
        }
		else {
            System.out.println(number + " is NOT a Harshad Number");
        }
        int[][] frequency = digitFrequency(digits);
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println("  " + frequency[i][0] + "        " + frequency[i][1]);
          }
      }
    }
}
