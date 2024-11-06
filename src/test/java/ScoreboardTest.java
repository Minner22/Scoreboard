import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreboardTest {

    private Scoreboard scoreboard;

    @BeforeEach
    public void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    public void testStartGame() {
        scoreboard.startGame("Mexico", "Canada");

        assertEquals(1, scoreboard.getSummary().size());

        Game game = scoreboard.getSummary().getFirst();

        assertEquals("Mexico", game.getHomeTeam());
        assertEquals("Canada", game.getAwayTeam());
        assertEquals(0, game.getHomeScore());
        assertEquals(0, game.getAwayScore());
    }

    @Test
    public void testUpdateScore() {
        int homeScore = 2;
        int awayScore = 3;

        scoreboard.startGame("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", homeScore, awayScore);

        assertEquals(1, scoreboard.getSummary().size());

        Game game = scoreboard.getSummary().getFirst();

        assertEquals(homeScore, game.getHomeScore());
        assertEquals(awayScore, game.getAwayScore());
        assertEquals("Mexico 2 - Canada 3", game.toString());
    }

    @Test
    public void testFinishGame() {
        scoreboard.startGame("Mexico", "Canada");

        List<Game> games = scoreboard.getSummary();

        assertFalse(games.isEmpty());

        scoreboard.finishGame("Mexico", "Canada");

        games = scoreboard.getSummary();

        assertTrue(games.isEmpty());
    }

}
