package bookshelf;

public class LibraryApp {
    public static void main(String[] args) {

        BookShelf shelf = new BookShelf();

        Book b1 = new Book("1984", "George Orwell", "ISBN001");
        Book b2 = new Book("Brave New World", "Aldous Huxley", "ISBN002");
        Book b3 = new Book("A Brief History of Time", "Stephen Hawking", "ISBN003");

        shelf.addBook("Fiction", b1);
        shelf.addBook("Fiction", b2);
        shelf.addBook("Science", b3);

        shelf.displayCatalog();

        shelf.borrowBook("Fiction", "ISBN001");

        shelf.displayCatalog();
    }
}
