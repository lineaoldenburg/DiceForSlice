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
        System.out.println("DICE FOR SLICE");
        System.out.println("2 players, 2 rounds, 1 Dice. Highest score wins a Pizza-slice");
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
            renderer.renderPlayers();
            game(scanner);
        }

    /*GAME BEGINS*/
    public void game(Scanner scanner) {
        Random random = new Random();
        int diceRoll = 0;

        for (int i = 0; i < 2; i++) {
        System.out.println(playerOne.getFirstName() + " PRESS ONE TO ROLL THE DICE");
        int playInput = Integer.parseInt(scanner.nextLine());
        if (playInput == 1) {
            diceRoll = random.nextInt(1, 7);
            int score = playerOne.getScore() + diceRoll;
            playerOne.setScore(score);
        } else {
            System.out.println("You need to press 1");
        }

        renderer.renderPlayers();


            System.out.println(playerTwo.getFirstName() + " PRESS ONE TO ROLL THE DICE");
            playInput = Integer.parseInt(scanner.nextLine());
            if (playInput == 1) {
                diceRoll = random.nextInt(1, 7); // roll again for player two
                int score = playerTwo.getScore() + diceRoll;
                playerTwo.setScore(score);
            } else {
                System.out.println("You need to press 1");
            }

            renderer.renderPlayers();
        }
    }
}
