package com.searchingfilereaderstringbuffer.binarysearch;

import java.util.*;
public class FirstAndLastOccurance {
	public static int firstOccurence(int arr[],int target) {
	
		int left=0,right=arr.length-1,ans=-1;
		while(left<=right) {
			int mid=left+right/2;
			if(arr[mid]==target) {
				ans=mid;
				right=mid-1;
			}
			else if(arr[mid]<target) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}
		return ans;
	}
	public static int lastOccurence(int arr[],int target) {
		
		int left=0, right=arr.length-1, ans=-1;

        while (left<=right) {
            int mid =left+(right-left)/2;

            if (arr[mid]==target) {
                ans=mid;        
                left=mid+1;   
            }
            else if (arr[mid]<target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
System.out.println("enter input");
int n=sc.nextInt();
System.out.println("enter array elements");
int arr[]=new int [n];
for(int i=0;i<n;i++) {
	arr[i]=sc.nextInt();
}
int target=sc.nextInt();
System.out.println("first occurence :"+ firstOccurence(arr,target));
System.out.println("last occurence : "+ lastOccurence(arr,target));
	}

}