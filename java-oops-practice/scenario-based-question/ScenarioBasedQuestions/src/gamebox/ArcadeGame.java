package gamebox;

class ArcadeGame extends Game implements IDownloadable {

     ArcadeGame(String title,double price,double rating) {
        super(title, "Arcade", price,rating);
    }

    @Override
    public void download() {
        System.out.println("Downloading Arcade Game"+getTitle());
    }

    @Override
    public void playDemo() {
        System.out.println("Playing fast-action 2 minute Arcade demo");
    }

    @Override
    public void displayGameType() {
        System.out.println("This is an Arcade Game");
    }
}
