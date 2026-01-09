package artify;

public abstract class Artwork implements IPurchasable {

    protected String title;
    protected String artist;
    protected double price;

    // Licensing details hidden
    protected String licenseType;

    // Constructor without preview
    Artwork(String title, String artist, double price, String licenseType) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.licenseType = licenseType;
    }

    // Constructor with preview
     Artwork(String title, String artist, double price,String licenseType, boolean hasPreview) {
        this(title, artist, price, licenseType);
        System.out.println("Preview available: " + hasPreview);
    }
}
