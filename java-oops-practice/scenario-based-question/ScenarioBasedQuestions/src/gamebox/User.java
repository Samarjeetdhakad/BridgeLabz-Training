package gamebox;

import java.util.ArrayList;

class User{
    private String username;
    private ArrayList<Game> ownedGames;   

     User(String username){
        this.username = username;
        ownedGames = new ArrayList<>();
    }

    public void addGame(Game game){
        ownedGames.add(game);
        System.out.println(game.getTitle() + " added to your library");
    }

    public void showLibrary() {
        System.out.println("Games owned by " + username + ":");
        for (Game g : ownedGames) {
            System.out.println("-" + g.getTitle());
        }
    }
}
