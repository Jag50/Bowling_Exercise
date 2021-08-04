package bowlingexercise3;

public class Ball {

    private int score;

    public Ball(int score){

        this.score = score;
        //save score javabean
        //add getter method
    }

    public int getScore() {
        return score;
    }

    public boolean isStrike() {
        return score == 10;
    }

    public boolean isSpare() {
        return score == 10;
    }
}
