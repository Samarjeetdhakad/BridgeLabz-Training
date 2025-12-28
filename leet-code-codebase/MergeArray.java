import java.util.Scanner;
public class MergeArray{
    public static void merge(int[]nums1,int m, int[]nums2, int n){
        int p1 =m-1, p2=n-1,i=m+n-1;

        while (p2 >= 0) {
            if(p1 >=0 && nums1[p1]>nums2[p2]){
                nums1[i--] = nums1[p1--];
            }
			else{
                nums1[i--]=nums2[p2--];
        }
      }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] nums1=new int[m+n];
        for(int i =0;i<m;i++){
            nums1[i]=sc.nextInt();
          }

        int[] nums2 = new int[n];
        for(int i=0;i<n;i++) {
            nums2[i]=sc.nextInt();
           }

        merge(nums1, m, nums2, n);
        for (int i=0;i<m+n; i++) {
            System.out.print(nums1[i]+ " ");
      }
    }
}
