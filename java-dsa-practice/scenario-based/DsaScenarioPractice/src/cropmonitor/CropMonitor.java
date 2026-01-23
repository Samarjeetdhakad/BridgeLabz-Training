package cropmonitor;

public class CropMonitor {
	
	public static void quickSort(int[] temperature, int low, int high) {
		if(low<high) {
			int pivotIndex = partition (temperature, low, high);
			quickSort(temperature, low, pivotIndex-1);
			quickSort(temperature, pivotIndex+1,high);			
		}
		
	}
	public static int partition(int[] temperature , int low, int high){
		
			int index = low-1;
			int pivot = temperature[high];
			
			for(int i = low; i<high; i++) {
				if(temperature[i] <= pivot) {
					index++;
					int temp = temperature[index];
					temperature[index] = temperature[i];
					temperature[i] = temp;
				}
			}
			int temp = temperature[index+1];
			temperature[index+1 ] = temperature[high];
			temperature[high] = temp;
			return index+1;
		}
	
}
	
	

