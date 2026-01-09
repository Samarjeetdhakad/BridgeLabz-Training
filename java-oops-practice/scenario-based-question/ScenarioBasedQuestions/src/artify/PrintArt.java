package artify;

public class PrintArt extends Artwork {

    public PrintArt(String title, String artist, double price, String licenseType) {
        super(title, artist, price, licenseType);
    }

    @Override
    public void purchase(User user) {
        user.deductBalance(price + 200); 
        System.out.println("Print artwork purchased: " + title);
    }

    @Override
    public void license(User user) {
        System.out.println("Limited print license applied");
    }
}
