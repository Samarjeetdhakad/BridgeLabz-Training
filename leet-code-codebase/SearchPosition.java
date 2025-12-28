import java.util.Scanner;

public class SearchPosition{

    public static int searchInsert(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        int mid;

        while(left<=right){
            mid=left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
              } 
            else if(nums[mid]>target){
                right=mid-1;
            } 
            else{
                left=mid+1;
         }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] nums=new int[n];
   
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int target=sc.nextInt();

        int result=searchInsert(nums, target);
        System.out.println( result);
    }
}
