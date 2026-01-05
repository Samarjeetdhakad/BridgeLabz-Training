package e_walletapplication;

public class BusinessWallet extends Wallet {

    double transactionLimit = 50000;

    BusinessWallet() {
        super();
    }

    @Override
    void transferTo(User receiver, double amount) {

        if (amount > transactionLimit) {
            System.out.println("Transaction limit exceeded!");
            return;
        }

        double tax = amount * 0.05; 
        double total = amount + tax;

        if (debit(total)) {
            receiver.wallet.credit(amount);
            history.add(new Transaction(
                "Business Transfer to " + receiver.name, amount
            ));
        } else {
            System.out.println("Insufficient balance in Business Wallet");
        }
    }
}