package icecreamrush;

public class BubbleSortProvider {
    
    public static void sortFlavors(Flavor[] flavors) {
        int n = flavors.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Comparing adjacent sales figures
                if (flavors[j].sales > flavors[j + 1].sales) {
                    // Swap
                    Flavor temp = flavors[j];
                    flavors[j] = flavors[j + 1];
                    flavors[j + 1] = temp;
                }
            }
        }
    }
}