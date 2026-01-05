package e_walletapplication;

public class EWalletMain {
	public static void main(String[] args) {

        User rohan = new User("Rohan", new PersonalWallet(100));
        User shop  = new User("ShopOwner", new BusinessWallet());

        rohan.loadMoney(1000);
        shop.loadMoney(20000);

        rohan.wallet.transferTo(shop, 500);
        shop.wallet.transferTo(rohan, 3000);

        rohan.showBalance();
        shop.showBalance();

        System.out.println("\nRohan Transactions:");
        rohan.wallet.showHistory();

        System.out.println("\nShopOwner Transactions:");
        shop.wallet.showHistory();
    }
}