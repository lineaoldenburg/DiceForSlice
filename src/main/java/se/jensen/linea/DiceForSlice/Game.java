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
            String input = scanner.nextLine(); // could be null

            if (input == null || input.trim().isEmpty()) {
                System.out.println("You must enter a number (1 or 2)");
                continue; // go back to start of loop
            }

            try {
                int start = Integer.parseInt(input.trim());

                if (start == 1) {
                    clearConsole();
                    CreatePlayers();
                    break;
                } else if (start == 2) {
                    System.exit(0);
                } else {
                    System.out.println("1 or 2 are the only valid options.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a valid number (1 or 2)");
            }
        }
    }

    /*CREATE PLAYERS*/
    public void CreatePlayers() {
        final String ORANGE = "\u001B[38;5;214m";
        final String GREEN  = "\u001B[38;5;46m";
        final String RESET  = "\u001B[0m";
        this.playerOne = new Player("", "", 0);
        this.playerTwo = new Player("", "", 0);

        while (true) {
            System.out.println(ORANGE + "Enter Player one first name:" + RESET);
            String playerOneFirst = scanner.nextLine();
            try {
                playerOne.setFirstName(playerOneFirst);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println(ORANGE + "Enter Player one last name:" + RESET);
            String playerOneLast = scanner.nextLine();
            try {
                playerOne.setLastName(playerOneLast);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println(GREEN + "Enter Player two first name:" + RESET);
            String playerTwoFirst = scanner.nextLine();
            try {
                playerTwo.setFirstName(playerTwoFirst);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println(GREEN + "Enter Player two last name:" + RESET);
            String playerTwoLast = scanner.nextLine();
            try {
                playerTwo.setLastName(playerTwoLast);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        clearConsole();
        this.renderer = new RenderGame(this.playerOne, this.playerTwo);

        game(scanner);

        while (true) {
            System.out.println("REMATCH???");
            System.out.println("press 1 for yes, 2 for no");
            int input = Integer.parseInt(scanner.nextLine());
            if (input == 1) {
                playerOne.setScore(0);
                playerTwo.setScore(0);
                clearConsole();
                game(scanner);
            }
            else {
                System.out.println("Game Ends");
                break;
            }
        }
    }

    /*GAME BEGINS*/
    public void game(Scanner scanner) {
        Dice dice = new Dice();

        for (int round = 1; round <= 2; round++) {
            renderer.renderPlayers(round);
            final String ORANGE = "\u001B[38;5;214m";
            final String GREEN  = "\u001B[38;5;46m";
            final String RESET  = "\u001B[0m";
            while (true) {
                try {
                    System.out.println(ORANGE + playerOne.getFirstName() + " PRESS ONE TO ROLL THE DICE" + RESET);
                    int playInput = Integer.parseInt(scanner.nextLine());
                    if (playInput != 1) {
                        System.out.println("You need to press 1");
                    } else {
                        dice.roll();
                        int diceRoll = dice.getDiceRoll();
                        int score = playerOne.getScore() + diceRoll;
                        playerOne.setScore(score);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You need to enter a valid number (1)!");
                }
            }

            while (true) {
                try {
                    System.out.println(GREEN + playerTwo.getFirstName() + " PRESS ONE TO ROLL THE DICE" + RESET);
                    int playInput = Integer.parseInt(scanner.nextLine());
                    if (playInput != 1) {
                        System.out.println("You need to press 1");
                    } else {
                        dice.roll();
                        int diceRoll = dice.getDiceRoll();
                        int score = playerTwo.getScore() + diceRoll;
                        playerTwo.setScore(score);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You need to enter a valid number (1)!");
                }
            }
        }

        determineWinner();
    }

    //Winner
    public void determineWinner() {
        clearConsole();
        int playerOneScore = playerOne.getScore();
        int playerTwoScore = playerTwo.getScore();

        if (playerOneScore > playerTwoScore) {
            renderer.renderWinner(playerOne, playerTwo);
        } else {
            renderer.renderWinner(playerTwo, playerOne);
        }
    }
}
