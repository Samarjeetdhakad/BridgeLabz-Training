import java.util.Scanner;

public class BinarySearch{

    public static int search(int[]nums,int target){
        int low=0;
        int high=nums.length-1;

        while(low<high){
            int mid =(low+high)/2;
            if (nums[mid]<target){
                low=mid+1;
            } 
			else{
                high=mid;
         }
        }

        return(nums.length>0 &&nums[low]==target)?low:-1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] nums=new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
}

        int target=sc.nextInt();
        int result=search(nums, target);
        if(result!=-1){
            System.out.println("Target found " + result);
        }
		else {
            System.out.println("Target not found");
      }
    }
}