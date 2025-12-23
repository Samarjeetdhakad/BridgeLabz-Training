import java.util.Scanner;
public class Factors {
    // find factors of a number and return them as an array
    public static int[] findFactors(int number) {
        int count = 0;
      for(int i = 1; i <= number; i++) {
          if (number % i == 0) {
              count++;
        }
        }
      int[]factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
				index++;
        }
        }
        return factors;
       }

    //greatest factor using factors array
    public static int GreatestFactor(int[] factors) {
        int greatest = factors[0];
        for(int factor:factors) {
            if(factor > greatest) {
                greatest = factor;
         }
        }
        return greatest;
    }

    //find the sum of factors
    public static int SumFactors(int[] factors) {
        int sum = 0;
        for(int i=0;i<factors.length;i++) {
            sum += factors[i];
        }
        return sum;
    }

    // find the product of factors
    public static long ProductFactors(int[] factors) {
        long product = 1;
        for(int factor: factors) {
            product *= factor;
        }
    return product;
    }
    //cube factors
    public static double CubeFactors(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int[] factors = findFactors(number);
        for(int factor : factors) {
            System.out.print(factor + " ");
		}
        System.out.println(GreatestFactor(factors));
        System.out.println(SumFactors(factors));
        System.out.println(ProductFactors(factors));
        System.out.println(CubeFactors(factors));
  }
}
