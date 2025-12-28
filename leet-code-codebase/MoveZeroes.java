 import java.util.Scanner;

public class MoveZeroes{

    public static void moveZeroes(int[] nums){
        int nonZero=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[nonZeronums[i];
                nonZero++;
        }
        }
        for(int i=nonZero;i<nums.length;i++){
            nums[i]=0;
      }
    } 
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] nums=new int[n];
        for(int i=0; i<n;i++){
            nums[i]=sc.nextInt();
        }
        moveZeroes(nums);
        for(int num:nums){
            System.out.print(num + " ");
     }
    }
}
    
