package se.jensen.linea.DiceForSlice;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(null, null);
        game.introGame();

        RenderGame renderGame = new RenderGame(game.getPlayerOne(), game.getPlayerTwo());
    }
}
