import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    private String score;

    public Player(String name) {
        this.name = name;
        this.score = "Love";
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public void incrementScore(ArrayList<String> scores) {
        score = scores.get(scores.indexOf(score) + 1);
    }

    public void setScore(String score) {
        this.score = score;
    }
}