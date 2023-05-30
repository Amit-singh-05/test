import game.Game;
import player.Player;

public class MainClass {

	public static void main(String[] args) {

		// Create players
        Player player1 = new Player(1, "Player 1");
        Player player2 = new Player(2, "Player 2");

        // Create game
        Game game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Start the game
        game.startGame();
	}

}
