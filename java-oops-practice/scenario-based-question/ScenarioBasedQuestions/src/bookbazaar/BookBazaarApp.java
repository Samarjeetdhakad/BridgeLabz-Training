package bookbazaar;

public class BookBazaarApp {

    public static void main(String[] args) {
        Book ebook = new EBook(
                "Java Mastery",
                "James Gosling",
                500,
                100
        );
        Book printedBook = new PrintedBook(
                "Clean Code",
                "Robert Martin",
                800,
                20
        );

        Order order = new Order("Samarjeet");

        order.addBook(ebook, 2);
        order.addBook(printedBook, 3);

        order.confirmOrder();
        order.showOrderSummary();
    }
}
