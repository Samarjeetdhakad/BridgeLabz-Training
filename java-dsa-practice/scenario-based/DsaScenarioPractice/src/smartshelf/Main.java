package smartshelf;

public class Main {

    public static void main(String[] args) {

        Book[] books = new Book[6];

        books[0] = new Book("Algorithms");
        books[1] = new Book("Data Structures");
        books[2] = new Book("Java Programming");
        books[3] = new Book("Artificial Intelligence");
        books[4] = new Book("Operating Systems");
        books[5] = new Book("Computer Networks");

        int n = 6;

        System.out.println("Before Sorting:");
        SmartShelf.printBooks(books, n);

        SmartShelf.insertionSort(books, n);

        System.out.println("\nAfter Sorting:");
        SmartShelf.printBooks(books, n);
    }
}