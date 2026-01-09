package medistore;

import java.time.LocalDate;

public class MediStoreApp {
    public static void main(String[] args) {

        Medicine m1 = new Tablet("Paracetamol", 5.0,LocalDate.of(2026, 3, 10), 100);

        Medicine m2 = new Syrup("Cough Syrup", 120.0, LocalDate.of(2025, 2, 5));

        System.out.println("Total Bill:" + m1.sell(20));
        System.out.println("Tablet Expired" + m1.checkExpiry());
        System.out.println("Syrup Expired" + m2.checkExpiry());
    }
}
