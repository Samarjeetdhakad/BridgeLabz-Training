package medistore;

import java.time.LocalDate;

public class Syrup extends Medicine {

    public Syrup(String name, double price, LocalDate expiryDate) {
        super(name, price, expiryDate);
    }

    @Override
    public boolean checkExpiry() {
        // Liquids degrade earlier
        return LocalDate.now().isAfter(expiryDate.minusDays(7));
    }
}
