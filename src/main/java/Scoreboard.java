import java.util.ArrayList;
import java.util.List;

public class Scoreboard {

    private final List<Game> games;

    public Scoreboard() {
        games = new ArrayList<>();
    }

    public void startGame(String homeTeam, String awayTeam) {
        games.add(new Game(homeTeam, awayTeam, 0, 0));
    }

    public List<Game> getSummary() {
        return games;
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
    }
}
