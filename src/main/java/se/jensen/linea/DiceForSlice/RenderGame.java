package se.jensen.linea.DiceForSlice;

public class RenderGame extends Game {
    // ANSI
    final String ORANGE = "\u001B[38;5;214m";
    final String GREEN = "\u001B[38;5;46m";
    final String RESET = "\u001B[0m";


    public RenderGame(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
    }

    int round = 0;

    public void renderPlayers(int round) {
        Player p1 = getPlayerOne();
        Player p2 = getPlayerTwo();

        this.round = round;

        if (p1 == null || p2 == null) {
            System.out.println("Players not created yet!");
            return;
        }

        System.out.println("===========================================");
        System.out.printf("                    ROUND %s               %n", round);
        System.out.println("===========================================");
        System.out.printf(ORANGE + "Player 1: %s %s (Score: %d)" + RESET + "%n",
                p1.getFirstName(), p1.getLastName(), p1.getScore());
        System.out.printf(GREEN + "Player 2: %s %s (Score: %d)" + RESET + "%n",
                p2.getFirstName(), p2.getLastName(), p2.getScore());
        System.out.println("===========================================");
    }

    public void renderWinner(Player winningPlayer, Player losingPlayer) {
        int winningScore = winningPlayer.getScore();
        int loserScore = losingPlayer.getScore();

        if (winningScore > loserScore) {
            System.out.println("THE WINNER IS:");
            System.out.println(winningPlayer.getFullName());
            int scoreAmount = winningScore - loserScore;
            System.out.println("YOU WON WITH: " + scoreAmount + " POINTS");
            System.out.println(winningPlayer.getFullName() + ": [" + winningScore + "]");
            System.out.println(losingPlayer.getFullName() + ": [" + loserScore + "]");
        } else if (winningScore == loserScore) {
            System.out.println("IT'S A TIE!");
            System.out.println(winningPlayer.getFullName() + ": [" + winningScore + "]");
            System.out.println(losingPlayer.getFullName() + ": [" + loserScore + "]");
        }
    }
}
