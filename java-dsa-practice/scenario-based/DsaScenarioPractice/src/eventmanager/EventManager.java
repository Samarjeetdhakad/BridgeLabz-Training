package eventmanager;

public class EventManager {

    public static void main(String[] args) {

        int[] ticketPrices = {1200, 500, 3000, 800, 2000};

        QuickSort quickSort = new QuickSort();
        
        quickSort.quickSort(ticketPrices, 0, ticketPrices.length - 1);

        System.out.println("Sorted Ticket Prices:");
        for (int price : ticketPrices) {
            System.out.print(price + " ");
        }
    }
}