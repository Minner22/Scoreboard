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

        scoreboard.finishGame("Mexico", "England");
        games = scoreboard.getSummary();
        assertFalse(games.isEmpty());

        scoreboard.finishGame("Mexico", "Canada");
        games = scoreboard.getSummary();
        assertTrue(games.isEmpty());
    }

    @Test
    public void testGetSummary() {
        scoreboard.startGame("Mexico", "Canada");
        scoreboard.startGame("Spain", "Brazil");
        scoreboard.startGame("Germany", "France");
        scoreboard.startGame("Uruguay", "Italy");
        scoreboard.startGame("Argentina", "Australia");

        scoreboard.updateScore("Mexico", "Canada", 0, 5);
        scoreboard.updateScore("Spain", "Brazil", 10, 2);
        scoreboard.updateScore("Germany", "France", 2, 2);
        scoreboard.updateScore("Uruguay", "Italy", 6, 6);
        scoreboard.updateScore("Argentina", "Australia", 3, 1);

        List<Game> gameSummaries = scoreboard.getSummary();

        assertFalse(gameSummaries.isEmpty());
        assertEquals("Uruguay 6 - Italy 6", gameSummaries.get(0).toString());
        assertEquals("Spain 10 - Brazil 2", gameSummaries.get(1).toString());
        assertEquals("Mexico 0 - Canada 5", gameSummaries.get(2).toString());
        assertEquals("Argentina 3 - Australia 1", gameSummaries.get(3).toString());
        assertEquals("Germany 2 - France 2", gameSummaries.get(4).toString());
    }

}
