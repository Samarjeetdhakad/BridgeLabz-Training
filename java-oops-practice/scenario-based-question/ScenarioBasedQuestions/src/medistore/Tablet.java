package medistore;

import java.time.LocalDate;

public class Tablet extends Medicine {

    public Tablet(String name, double price, LocalDate expiryDate, int quantity) {
        super(name, price, expiryDate, quantity);
    }

    @Override
    public boolean checkExpiry() {
        // Tablets are preserved, expire strictly on date
        return LocalDate.now().isAfter(expiryDate);
    }
}
