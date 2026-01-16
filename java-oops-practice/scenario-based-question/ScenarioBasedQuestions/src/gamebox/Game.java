package gamebox;

abstract class Game {
    private String title;
    private String genre;
    protected double price;
    protected double rating;

    Game(String title, String genre, double price, double rating) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

   
    public double applyDiscount(double percent) {
        price = price - (price * percent / 100);
        return price;
    }

    public abstract void displayGameType();
}
