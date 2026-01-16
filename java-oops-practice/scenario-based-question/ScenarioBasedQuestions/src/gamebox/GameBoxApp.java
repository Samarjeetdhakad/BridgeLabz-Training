package gamebox;

public class GameBoxApp {
    public static void main(String[] args) {

        User user = new User("PlayerOne");

        Game g1 = new ArcadeGame("Subway Runner", 500, 4.5);
        Game g2 = new StrategyGame("Empire Builder", 800, 4.7);

       
        g1.applyDiscount(20);  

        user.addGame(g1);
        user.addGame(g2);

        user.showLibrary();
        IDownloadable d1 = new ArcadeGame("Ninja Dash", 300, 4.2);
        IDownloadable d2 = new StrategyGame("War Tactics", 900, 4.8);

        d1.playDemo();
        d2.playDemo();
    }
}
