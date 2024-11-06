import java.util.ArrayList;
import java.util.List;

public class Scoreboard {

    private final List<Game> games;

    public Scoreboard() {
        games = new ArrayList<>();
    }

    public void startGame(String homeTeam, String awayTeam) {
    }

    public List<Game> getSummary() {
        return games;
    }
}
