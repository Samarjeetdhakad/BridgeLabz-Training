package artify;

public class ArtifyApp {
    public static void main(String[] args) {

        User buyer = new User("Aman", 5000);

        Artwork art1 = new DigitalArt( "Sunset Bliss", "Ravi", 1500, "Commercial");

        Artwork art2 = new PrintArt("Mountain View", "Neha", 2000, "Personal");

        art1.purchase(buyer);
        art1.license(buyer);

        art2.purchase(buyer);
        art2.license(buyer);
    }
}
