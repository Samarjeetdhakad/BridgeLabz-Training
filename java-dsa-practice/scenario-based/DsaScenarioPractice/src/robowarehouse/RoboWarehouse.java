package robowarehouse;

public class RoboWarehouse {
	
	public static void insertionSort(int[] arr) {
		
		int number = arr.length;
		
		for(int i=1; i<number; i++) {
			
			int currentPackage = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j] > currentPackage) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = currentPackage;
		}
		
	}
	
	public static void main(String[] args) {
		
		int [] packages =  { 4,3,5,7,6 } ;
		insertionSort(packages);
		
		for(int weight: packages ) {
			System.out.print(weight + " ");
		}
		
	}

}
