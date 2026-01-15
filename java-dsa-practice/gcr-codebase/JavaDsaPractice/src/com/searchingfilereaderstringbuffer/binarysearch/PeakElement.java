package com.searchingfilereaderstringbuffer.binarysearch;

import java.util.*;
public class PeakElement {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) {
        	arr[i]=sc.nextInt();
        }
        int peak=0;;
        int left=0,right=arr.length-1;
        while(left<right) {
        	int mid=(left+right)/2;
        	 if( (arr[mid] > arr[mid - 1]) && (arr[mid] > arr[mid + 1])) {
        		 peak=arr[mid];
        			
        			break;
        	}
        	else if(arr[mid] < arr[mid - 1]){
        		right=mid;
        	}
        	 
        	else {
        		left=mid;
        	}
        }
        System.out.println(peak);
	}

}