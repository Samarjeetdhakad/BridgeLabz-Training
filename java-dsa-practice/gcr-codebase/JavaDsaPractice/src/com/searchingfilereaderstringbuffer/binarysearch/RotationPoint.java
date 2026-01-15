package com.searchingfilereaderstringbuffer.binarysearch;

import java.util.*;
public class RotationPoint {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			
		}
		int left=0,right=arr.length-1;
		while(left<right) {
			int mid=(left+right)/2;
			if (arr[mid]>arr[right]) {
				left = mid + 1;
			}
			else if( arr[mid] < arr[right]) {
				right = mid;
			}
			else {
				
			}
		}
		System.out.println(arr[left]);
	}

}