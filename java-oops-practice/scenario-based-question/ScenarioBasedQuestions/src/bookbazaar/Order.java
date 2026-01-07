package bookbazaar;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String userName;
    private List<Book> books = new ArrayList<>();
    private double totalAmount;

    private String orderStatus; 

    public Order(String userName) {
        this.userName = userName;
        this.orderStatus = "CREATED";
    }

    public void addBook(Book book, int quantity) {
        if (book.reduceStock(quantity)) {
            books.add(book);
            totalAmount += book.calculateCost(quantity);
        } else {
            System.out.println("Insufficient stock for" + book.getTitle());
        }
    }

    
    protected void updateStatus(String status) {
        this.orderStatus = status;
    }

    public void confirmOrder() {
        updateStatus("CONFIRMED");
    }

    public void showOrderSummary() {
        System.out.println("User: " + userName);
        System.out.println("Order Status:" + orderStatus);
        System.out.println("Total Amount:" + totalAmount);
        System.out.println();
    }
}
