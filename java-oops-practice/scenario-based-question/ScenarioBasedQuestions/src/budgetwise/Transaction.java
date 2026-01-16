package budgetwise;
import java.time.LocalDate;

class Transaction {
    private double amount;
    private String type;      
    private LocalDate date;
    private String category;

     Transaction(double amount, String type, LocalDate date, String category) {
        this.amount =amount;
        this.type=type;
        this.date=date;
        this.category=category;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }
}
