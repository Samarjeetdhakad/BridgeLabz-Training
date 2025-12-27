import java.util.Scanner;
public class  Remove {
    public static int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }
	 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int[] nums=new int[n];
		
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();   
          }
        int val=sc.nextInt();
         
        int k = obj.removeElement(nums, val);
        System.out.println("Number of elements after removal " + k);

        for(int i = 0; i < k; i++){
            System.out.print(nums[i] + " ");
    }
    
}
}