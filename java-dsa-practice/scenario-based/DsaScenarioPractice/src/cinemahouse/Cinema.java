package cinemahouse;

public class Cinema {
	
	public static void bubbleSort(int[] showTime) {
		
		int n = showTime.length;
		
		for(int i=0; i<n-1;i++) {
			boolean swap = false;
			for(int j=0; j<n-1-i; j++) {
				
				if(showTime[j]>showTime[j+1]) {
					    int temp = showTime[j];
					    showTime[j] = showTime[j + 1]; 
					    showTime[j + 1] = temp;          
					    swap = true;
				}
				
			}
			if(!swap) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int showTime[] =  {23,21,76,43,44 };
		 
		bubbleSort(showTime);
		
		for(int time: showTime) {
			System.out.print(time +  " ");
		}
	}

}
