package se.jensen.linea.DiceForSlice;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private Player playerOne;
    private Player playerTwo;
    private RenderGame renderer;


    //Constructor
    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    // Getters
    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    //Console clearer (Fake)
    public void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /*INTRO*/
    public void introGame() {

        // ANSI color codes
        final String RESET = "\u001B[0m";
        final String BRIGHT_ORANGE = "\u001B[38;5;208m";
        final String ORANGE = "\u001B[38;5;214m";
        final String LIGHT_ORANGE = "\u001B[38;5;220m";
        final String PALE_ORANGE = "\u001B[38;5;226m";
        final String LIGHT_YELLOW = "\u001B[38;5;228m";
        final String LIGHTER_YELLOW = "\u001B[38;5;230m";

// "DICE FOR SLICE" in bright orange
        String[] printLine = {
                BRIGHT_ORANGE + "╺┳┓╻┏━╸┏━╸   ┏━╸┏━┓┏━┓   ┏━┓╻  ╻┏━╸┏━╸" + RESET,
                BRIGHT_ORANGE + " ┃┃┃┃  ┣╸    ┣╸ ┃ ┃┣┳┛   ┗━┓┃  ┃┃  ┣╸ " + RESET,
                BRIGHT_ORANGE + "╺┻┛╹┗━╸┗━╸   ╹  ┗━┛╹┗╸   ┗━┛┗━╸╹┗━╸┗━╸" + RESET
        };

        for(String line : printLine){
            System.out.println(line);
        }

// Info text with gradient fade
        String[] printInfo = {
                ORANGE + "╔╦╗╦ ╦╔═╗  ┌─┐┬  ┌─┐┬ ┬┌─┐┬─┐┌─┐" + RESET,
                ORANGE + " ║ ║║║║ ║  ├─┘│  ├─┤└┬┘├┤ ├┬┘└─┐" + RESET,
                LIGHT_ORANGE + " ╩ ╚╩╝╚═╝  ┴  ┴─┘┴ ┴ ┴ └─┘┴└─└─┘" + RESET,

                LIGHT_ORANGE + "╔╦╗╦ ╦╔═╗  ┬─┐┌─┐┬ ┬┌┐┌┌┬┐┌─┐   " + RESET,
                PALE_ORANGE + " ║ ║║║║ ║  ├┬┘│ ││ ││││ ││└─┐   " + RESET,
                PALE_ORANGE + " ╩ ╚╩╝╚═╝  ┴└─└─┘└─┘┘└┘─┴┘└─┘   " + RESET,

                PALE_ORANGE + "╔═╗╔╗╔╔═╗  ┌┬┐┬┌─┐┌─┐       ╔═╗╔╗╔╔═╗  ┌─┐┬  ┬┌─┐┌─┐" + RESET,
                LIGHT_YELLOW + "║ ║║║║║╣    ││││  ├┤   ───  ║ ║║║║║╣   └─┐│  ││  ├┤ " + RESET,
                LIGHTER_YELLOW + "╚═╝╝╚╝╚═╝  ─┴┘┴└─┘└─┘       ╚═╝╝╚╝╚═╝  └─┘┴─┘┴└─┘└─┘" + RESET
        };

        for(String line : printInfo){
            System.out.println(line);
        }

        System.out.println("Write 1 to start game, Write 2 to quit");

        while (true) {
            int start = Integer.parseInt(scanner.nextLine());

            if (start == 1) {
                clearConsole();
                CreatePlayers();
                break;
            } else if (start == 2) {
                System.exit(0);
            } else {
                System.out.println("1 or 2 are the only valid options.");
            }
        }
    }

    /*CREATE PLAYERS*/
        public void CreatePlayers() {
            System.out.println("Enter Player one first name:");
            String playerOneFirst = scanner.nextLine();

            System.out.println("Enter Player one last name:");
            String playerOneLast = scanner.nextLine();

            System.out.println("Enter Player two first name:");
            String playerTwoFirst = scanner.nextLine();

            System.out.println("Enter Player two last name:");
            String playerTwoLast = scanner.nextLine();

            this.playerOne = new Player(playerOneFirst, playerOneLast, 0);
            this.playerTwo = new Player(playerTwoFirst, playerTwoLast, 0);

            this.renderer = new RenderGame(this.playerOne, this.playerTwo);

            game(scanner);

        }

    /*GAME BEGINS*/
    public void game(Scanner scanner) {
        Random random = new Random();
        int diceRoll = 0;

        for (int round = 1; round <= 2; round++) {
            renderer.renderPlayers(round);
            final String RESET = "\u001B[0m";
            final String ORANGE = "\u001B[38;5;208m";
            final String GREEN = "\u001B[32m";

        while (true) {
            try {
                System.out.println(ORANGE + playerOne.getFirstName() + " PRESS ONE TO ROLL THE DICE" + RESET);
                int playInput = Integer.parseInt(scanner.nextLine());
                if (playInput != 1) {
                    System.err.println("You need to press 1");
                } else {
                    diceRoll = random.nextInt(1, 7);
                    int score = playerOne.getScore() + diceRoll;
                    playerOne.setScore(score);
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("You need to enter a valid number 1 or 2!");
            }
        }

        while (true) {
            try {
                System.out.println(GREEN + playerTwo.getFirstName() + " PRESS ONE TO ROLL THE DICE" + RESET);
                int playInput = Integer.parseInt(scanner.nextLine());
                if (playInput != 1) {
                    System.err.println("You need to press 1");

                } else {
                    diceRoll = random.nextInt(1, 7); // roll again for player two
                    int score = playerTwo.getScore() + diceRoll;
                    playerTwo.setScore(score);
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("You need to enter a valid number 1 or 2!");
            }
            }
        }

        determineWinner();
    }

    //Winner
    public void determineWinner() {
        int playerOneScore = playerOne.getScore();
        int playerTwoScore = playerTwo.getScore();

        if (playerOneScore > playerTwoScore) {
            renderer.renderWinner(playerOne, playerTwo);
        } else {
            renderer.renderWinner(playerTwo, playerOne);
        }
    }
}


