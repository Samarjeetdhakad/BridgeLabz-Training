package artify;

public class DigitalArt extends Artwork {

    DigitalArt(String title, String artist, double price, String licenseType) {
        super(title, artist, price, licenseType);
    }

    @Override
    public void purchase(User user) {
        user.deductBalance(price);
        System.out.println("Digital artwork purchased: " + title);
    }

    @Override
    public void license(User user) {
        System.out.println("Digital license applied: " + licenseType);
    }
}
