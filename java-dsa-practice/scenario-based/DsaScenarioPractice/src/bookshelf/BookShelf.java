package bookshelf;

import java.util.*;

class BookShelf {

    // Genre  List of Books
    private Map<String, LinkedList<Book>> catalog = new HashMap<>();

    // to avoid duplicates across library
    private Set<Book> bookSet = new HashSet<>();

    // Add book
    public void addBook(String genre, Book book) {
        // Avoid duplicate book
        if (!bookSet.add(book)) {
            System.out.println("Duplicate book not allowed: " + book);
            return;
        }

        // Get or create LinkedList for genre
        catalog.computeIfAbsent(genre, g -> new LinkedList<>())
               .add(book);

        System.out.println("Book added: " + book);
    }

    // Borrow book (remove)
    public void borrowBook(String genre, String isbn) {
        LinkedList<Book> books = catalog.get(genre);

        if (books == null) {
            System.out.println("Genre not found");
            return;
        }

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();      // LinkedList efficient delete
                bookSet.remove(book);
                System.out.println("Book borrowed: " + book);
                return;
            }
        }

        System.out.println("Book not available");
    }

    // Display catalog
    public void displayCatalog() {
        for (Map.Entry<String, LinkedList<Book>> entry : catalog.entrySet()) {
            System.out.println("Genre: " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println("  - " + book);
            }
        }
    }
}
