package medistore;

import java.time.LocalDate;

public class Injection extends Medicine {

    public Injection(String name, double price, LocalDate expiryDate, int quantity) {
        super(name, price, expiryDate, quantity);
    }

    @Override
    public boolean checkExpiry() {
        // Very sensitive medicines
        return LocalDate.now().isAfter(expiryDate.minusDays(15));
    }
}
