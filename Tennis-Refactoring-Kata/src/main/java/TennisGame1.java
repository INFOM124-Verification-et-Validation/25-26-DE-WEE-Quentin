import java.util.ArrayList;
import java.util.List;

public class TennisGame1 implements TennisGame {
    
    private final Player player1;
    private final Player player2;
    ArrayList<String> scores = new ArrayList<>(List.of("Love","Fifteen","Thirty","Forty", "Win"));

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            if (player2.getScore().equals("Avg")) {
                player2.setScore("Forty");
            }
            else {
                player1.incrementScore(scores);
            }
        } else {
            if (player1.getScore().equals("Avg")) {
                player1.setScore("Forty");
            }
            else {
                player2.incrementScore(scores);
            }
        }
        if (player1.getScore().equals("Forty") && player2.getScore().equals("Forty")) {
            scores =  new ArrayList<>(List.of("Forty", "Avg", "Win"));
        }
    }

    public String getScore() {
        if (player1.getScore().equals(player2.getScore())) {
            if (player1.getScore().equals("Forty")) {
                return "Deuce";
            } else {
                return player1.getScore() + "-All";
            }
        }
        else if (player1.getScore().equals("Win")) {
            return "Win for player1";
        } else if (player2.getScore().equals("Win")) {
            return "Win for player2";
        }
        else if (player1.getScore().equals("Avg")) {
            return "Advantage player1";
        } else if (player2.getScore().equals("Avg")) {
            return "Advantage player2";
        }
        else {
            return player1.getScore() + "-" + player2.getScore();
        }
    }
}
