import java.util.Scanner;
public class Duplicate{
    public static int removeDuplicates(int[] nums){
int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[j]!=nums[i]){
                nums[++j]=nums[i];
            }
        }
        return j+1;

        
    }
	public static void main(String[]args){
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int nums[]=new int[n];
	     for (int i=0;i<n;i++) {
            nums[i]=sc.nextInt();
        }

        int k =removeDuplicates(nums);
        System.out.println("Number of unique elements " + k);
   
        for(int i=0;i<k;i++){
            System.out.print(nums[i]+ " ");
       
    }
}
	
}