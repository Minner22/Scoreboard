import java.util.Comparator;

public class GameComparator implements Comparator<Game> {

    @Override
    public int compare(Game game1, Game game2) {
        int totalScore1 = game1.getHomeScore() + game1.getAwayScore();
        int totalScore2 = game2.getHomeScore() + game2.getAwayScore();

        if (totalScore1 != totalScore2) {
            return Integer.compare(totalScore2, totalScore1); // desc
        }
        // in case of equal total score, most recent game must be higher
        return -1;
    }
}
