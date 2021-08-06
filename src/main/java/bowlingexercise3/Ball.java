package bowlingexercise3;

public class Ball {

    private int score;
    private boolean isSpare;

    private Ball(int score){

        this.score = score;
        this.isSpare = false;
    }

    private Ball(int score, boolean isSpare){

        this.score = score;
        this.isSpare = isSpare;
    }

    public int getScore() {
        return score;
    }

    public boolean isStrike() {
        return score == 10;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public static Ball createBall (char input, int priorScore) {
        if (input == 'X') {
            return new Ball(10);
            //Incorporates the addition/separation of the pipe (|) symbol
        } else if (input == '-') {
            return new Ball(0);
            //Incorporates the addition of a spare (/) symbol
        } else if (input == '/') {
            int diff = 10 - priorScore;
            return new Ball(diff, true);
        }
        //Ensures numbers are added corrected
        else {
            return new Ball(input - '0');

        }
    }
}
