package e_walletapplication;

public class User {
	
	  String name;
	    Wallet wallet;

	    User(String name, Wallet wallet) {
	        this.name = name;
	        this.wallet = wallet;
	    }

	    void loadMoney(double amount) {
	        wallet.credit(amount);
	    }

	    void showBalance() {
	        System.out.println(name+"Balance:"+wallet.getBalance());
	    }
}