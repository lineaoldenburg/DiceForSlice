package se.jensen.linea.DiceForSlice;

public class RenderGame extends Game {
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
        System.out.printf("Player 1: %s %s (Score: %d)%n",
                p1.getFirstName(), p1.getLastName(), p1.getScore());
        System.out.printf("Player 2: %s %s (Score: %d)%n",
                p2.getFirstName(), p2.getLastName(), p2.getScore());
        System.out.println("===========================================");
    }

    public void renderWinner(Player winningPlayer, Player losingPlayer) {
        System.out.println("VINNAREN ÄR:");
        System.out.println(winningPlayer.getFullName());

        int winningScore = winningPlayer.getScore();
        int loserScore = losingPlayer.getScore();
        int scoreAmount = winningScore - loserScore;

        System.out.println("Du vann med: " + scoreAmount + " poäng" );
    }
}