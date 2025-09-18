package se.jensen.linea.DiceForSlice;

import java.util.Random;

public class Dice {
    private int diceRoll;

    public Dice() {
        roll();
    }

    public void roll() {
        Random random = new Random();
        this.diceRoll = random.nextInt(1, 7);
    }

    public int getDiceRoll() {
        return diceRoll;
    }
}
