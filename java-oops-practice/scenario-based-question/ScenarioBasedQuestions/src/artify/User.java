package artify;

public class User {

    private String name;
    private double walletBalance;

     User(String name, double walletBalance) {
        this.name = name;
        this.walletBalance=walletBalance;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    // Encapsulation: balance can only be changed internally
    void deductBalance(double amount) {
        if (amount <=walletBalance) {
            walletBalance -=amount;   
        } else {
            throw new IllegalArgumentException("Insufficient wallet balance");
        }
    }
}
