import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scoreboard {

    private final List<Game> games;

    public Scoreboard() {
        games = new ArrayList<>();
    }

    public void startGame(String homeTeam, String awayTeam) {
        games.add(new Game(homeTeam, awayTeam, 0, 0));
    }

    public List<Game> getSummary() {
        return games.stream()
                .sorted(new GameComparator())
                .collect(Collectors.toList());
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        games.stream()
                .filter(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam))
                .findFirst()
                .ifPresent(game -> {
                    game.setHomeScore(homeScore);
                    game.setAwayScore(awayScore);
                });
    }

    public void finishGame(String homeTeam, String awayTeam) {
        games.removeIf(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam));
    }
}
