package cropmonitor;

public class Main {

	public static void main(String[] args) {
		int temperature [] = {23, 12, 43, 54, 34, 21 };
		
		int low = 0;
		int high = temperature.length - 1;
		CropMonitor.quickSort(temperature, low, high);
		
		for(int x: temperature) {
			System.out.print(x+" ");
		}
	}

}
