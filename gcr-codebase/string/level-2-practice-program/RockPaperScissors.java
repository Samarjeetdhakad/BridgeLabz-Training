import java.util.Scanner;

public class RockPaperScissors{
    public static String getComputerChoice() {
        int choice=(int) (Math.random() * 3);
		
        if(choice == 0)
             return "rock";
        else if(choice == 1)
             return "paper";
        else
            return "scissors";
      }
    public static String findWinner(String user, String computer) {

        if(user.equals(computer))
            return "Draw";

        if(user.equals("rock") && computer.equals("scissors") || user.equals("paper") && computer.equals("rock") ||
       user.equals("scissors") && computer.equals("paper")){
            return "User";
        } 
		else{
            return "Computer";
}
    }
    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {

        String[][]stats=new String[2][3];

        double userPercent=(userWins * 100.0)/totalGames;
        double computerPercent=(computerWins * 100.0)/totalGames;

        stats[0][0]="User";
        stats[0][1]=String.valueOf(userWins);
        stats[0][2]=String.format("%.2f", userPercent) + "%";

        stats[1][0]= "Computer";
        stats[1][1]= String.valueOf(computerWins);
        stats[1][2]=String.format("%.2f", computerPercent)+"%";
        return stats;
  }
    public static void displayResults(String[][] games,String[][] stats){

        for(int i = 0; i < games.length; i++){
            System.out.println((i + 1) + "\t" + games[i][0] + "\t" + games[i][1] + "\t\t" + games[i][2]);
      }

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
      }
    }
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int gamesCount= sc.nextInt();
        sc.nextLine();

        String[][]gameResults =new String[gamesCount][3];
        int userWins=0,computerWins=0;

        for(int i=0;i<gamesCount;i++){
            String userChoice = sc.nextLine().toLowerCase();
            String computerChoice =getComputerChoice();
            String winner =findWinner(userChoice,computerChoice);

             gameResults[i][0] =userChoice;
             gameResults[i][1] =computerChoice;
              gameResults[i][2] =winner;

            if(winner.equals("User"))
                userWins++;
            else if
			(winner.equals("Computer"))
                computerWins++;
     }
        String[][]stats=calculateStats(userWins,computerWins,gamesCount);
        displayResults(gameResults,stats);
  }
}

   