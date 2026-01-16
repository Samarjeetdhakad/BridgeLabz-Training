package gamebox;

class StrategyGame extends Game implements IDownloadable {

    StrategyGame(String title, double price, double rating) {
        super(title, "Strategy", price, rating);
    }

    @Override
    public void download() {
        System.out.println("Downloading Strategy Game" + getTitle());
    }

    @Override
    public void playDemo() {
        System.out.println("Playing tactical 5 minute Strategy demo");
    }

    @Override
    public void displayGameType() {
        System.out.println("This is a Strategy Game");
    }
}
