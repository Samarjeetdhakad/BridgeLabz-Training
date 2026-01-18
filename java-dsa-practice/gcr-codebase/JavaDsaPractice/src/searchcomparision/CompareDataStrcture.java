package searchcomparision;

import java.util.*;
public class CompareDataStrcture{
	    public static void main(String[] args){
	        Scanner sc=new Scanner(System.in);
	        int n=sc.nextInt();
	        int target=sc.nextInt();
	        int[] arr=new int[n];
	        HashSet<Integer>hashSet=new HashSet<>();
	        TreeSet<Integer>treeSet=new TreeSet<>();

	        for(int i=0;i<n;i++){
	            arr[i]=i;
	            hashSet.add(i);
	            treeSet.add(i);
	           }
	       
	      long start=System.nanoTime();
	      boolean foundArray=linearSearch(arr, target);
	     long end=System.nanoTime();
	    long arrayTime=end-start;
	        // hashset search
	        start=System.nanoTime();
	        boolean foundHash=hashSet.contains(target);
	        end=System.nanoTime();
	        long hashTime=end-start;
	        // treeset search
	        start=System.nanoTime();
	        boolean foundTree=treeSet.contains(target);
	        end=System.nanoTime();
	        long treeTime=end-start;

	 
	        System.out.println("Array Found: " + foundArray + " Time: " + arrayTime + " ns");
	        System.out.println("HashSet Found: " + foundHash + " Time: " + hashTime + " ns");
	        System.out.println("TreeSet Found: " + foundTree + "Time: " +treeTime + " ns");
	        System.out.println("Array Search: " + (arrayTime / 1_000_000.0) +"ms");
	        System.out.println("HashSet Search: " + (hashTime / 1_000_000.0) +" ms");
	        System.out.println("TreeSet Search: " + (treeTime / 1_000_000.0) +" ms");

	    }
	    public static boolean linearSearch(int[] arr, int target) {
	        for(int x : arr) {
	            if(x == target) return true;
	        }
	        return false;
	    }
	}