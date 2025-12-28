import java.util.Scanner;

class BuyAndSell {

    public static int maxProfit(int[] prices){
        int min=Integer.MAX_VALUE;
        int maxProfit=0;

        for (int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }

            int currProfit=prices[i]-min;
            if (currProfit>maxProfit){
                maxProfit=currProfit;
         }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] prices=new int[n];
        for (int i=0; i<n;i++) {
            prices[i]=sc.nextInt();
        }

        int profit=maxProfit(prices);
        System.out.println( profit);
    }
}
