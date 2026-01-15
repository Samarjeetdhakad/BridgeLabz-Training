package com.searchingfilereaderstringbuffer.binarysearch;

import java.util.*;
public class ChallengeProblem {
	public static int firstPositive(int []arr) {
		int index=-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				index=i;
				break;
			}
		}
		return index;
	}
	public static int targetIndex(int []arr,int target) {
		int index=-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				index=i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int arr[]=new int[n];
for(int i=0;i<arr.length;i++) {
	arr[i]=sc.nextInt();
}
System.out.println("enter target value");
int target=sc.nextInt();

System.out.println("first Positive :" +firstPositive(arr));
System.out.println("target index :" +targetIndex(arr,target));

	}

}