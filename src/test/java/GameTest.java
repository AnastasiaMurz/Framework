import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void tesOneVictory() {
        Game game = new Game();
        Player player1 = new Player(1, "Askold", 500);
        Player player2 = new Player(2, "Moll", 300);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Askold", "Moll");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testVictory() {
        Game game = new Game();
        Player player1 = new Player(1, "Askold", 500);
        Player player2 = new Player(2, "Moll", 500);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Askold", "Moll");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundNoPlayer2() {
        Game game = new Game();
        Player player1 = new Player(1, "Askold", 300);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Askold", "Moll");
        });
    }

    @Test
    public void testRoundNoPlayer1() {
        Game game = new Game();
        Player player2 = new Player(2, "Moll", 300);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Askold", "Moll");
        });
    }

    @Test
    public void testRoundNoPlayers() {
        Game game = new Game();
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Askold", "Moll");
        });
    }

    @Test
    public void tesTwoVictory() {
        Game game = new Game();
        Player player1 = new Player(1, "Askold", 500);
        Player player2 = new Player(2, "Moll", 700);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Askold", "Moll");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }
}
