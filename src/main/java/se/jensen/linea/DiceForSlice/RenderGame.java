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
        boolean isTie = winningScore == loserScore;

        // ASCII art: pizza for winner, tie art for tie
        String[] art;
        if (isTie) {
            art = new String[]{
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠿⠿⠿⠿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣶⣶⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣙⣉⣉⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢉⣉⣠⣤⣴⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⠿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⣉⣭⣤⣤⣶⣶⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⠿⠿⠛⠛⢉⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣉⣠⣤⣴⣶⣾⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠚⢿⣿⣿⠿⠿⠛⠋⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠶⡶⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
            };
        } else {
            art = new String[]{
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣉⡙⠛⠿⣿⣶⣦⣤⣄⣀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡌⢻⣿⣿⣷⣶⣤⣉⡙⠛⠿⣿⣿⣶⠆⡀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⢃⣼⣿⣿⣿⣿⣿⣿⣿⣷⣶⣤⣌⣉⠀⣿⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⠟⠛⠛⠿⣿⣿⣿⣿⣿⡿⠟⢋⣥⡶⠟⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣇⠰⣿⣿⣦⡈⣿⠟⢋⣡⡴⠞⠋⠁⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⢼⣿⣿⣿⣿⣿⣦⣌⡉⠉⣠⡴⠞⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠲⠆⢹⣿⣿⠿⠛⣉⡥⠖⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⣰⣿⣿⠿⠛⣉⣤⠶⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⡰⠟⢋⣤⠶⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⡴⠞⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
            };
        }

        // Build table strings
        String heading = isTie ? "IT'S A TIE! " : "THE SLICE GOES TO: " + winningPlayer.getFullName();
        String pointsLine = isTie ? "" : "You won with: " + (winningScore - loserScore) + " POINTS";
        String row1 = winningPlayer.getFullName() + ": [" + winningScore + "]";
        String row2 = losingPlayer.getFullName() + ": [" + loserScore + "]";

        // Table width (twice as long)
        int leftWidth = 60;

        // Print table with ASCII art
        System.out.printf("%-" + leftWidth + "s | %s%n", "_".repeat(50), art[0]);
        System.out.printf("%-" + leftWidth + "s | %s%n", heading, art[1]);
        if (!pointsLine.isEmpty()) {
            System.out.printf("%-" + leftWidth + "s | %s%n", pointsLine, art[2]);
        } else {
            System.out.printf("%-" + leftWidth + "s | %s%n", "", art[2]);
        }
        System.out.printf("%-" + leftWidth + "s | %s%n", "_".repeat(50), art[3]);
        System.out.printf("%-" + leftWidth + "s | %s%n", row1, art.length > 4 ? art[4] : "");
        System.out.printf("%-" + leftWidth + "s | %s%n", row2, art.length > 5 ? art[5] : "");
        for (int i = 6; i < art.length; i++) {
            System.out.printf("%-" + leftWidth + "s | %s%n", "", art[i]);
        }
        System.out.printf("%-" + leftWidth + "s | %s%n", "_".repeat(50), "");
    }
}