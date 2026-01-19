package zipzipmart;

public class Main {

    public static void main(String[] args) {

        Transaction[] sales = {
            new Transaction("2024-05-02", 1200),
            new Transaction("2024-05-01", 500),
            new Transaction("2024-05-01", 1500),
            new Transaction("2024-05-03", 700),
            new Transaction("2024-05-02", 1200)
        };

        System.out.println("Before Sorting:");
        ZipZipMart.printTransactions(sales);

        ZipZipMart.mergeSort(sales, 0, sales.length - 1);

        System.out.println("\nAfter Sorting (Date + Amount):");
        ZipZipMart.printTransactions(sales);
    }
}