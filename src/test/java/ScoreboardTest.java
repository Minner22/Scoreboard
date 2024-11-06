import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals("Mexico", scoreboard.getSummary().getFirst().getHomeTeam());
        assertEquals("Canada", scoreboard.getSummary().getFirst().getAwayTeam());
        assertEquals(0, scoreboard.getSummary().getFirst().getHomeScore());
        assertEquals(0, scoreboard.getSummary().getFirst().getAwayScore());
    }

}
