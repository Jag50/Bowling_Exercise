package bowlingexercise3;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    //Determines the number of rolls and limits the frames to 10
    private int turn = 0;
    //limits the frames
    private List<Ball> turns = new ArrayList<>();

    //Private Boolean created to keep track of pointers which correctly add scores
    private boolean strike(int cursor) {
        return turns.get(cursor).isStrike();
    }

    private boolean spare(int cursor) {

        return turns.get(cursor + 1).isSpare();
    }

    public void turns(String total) throws IllegalArgumentException {

        BowlingValidation.validateInput(total);

        turns.add(Ball.createBall(total.charAt(0), 0));
        for (int i = 1; i < total.length(); i++) {
            if (total.charAt(i) != '|') {
                turns.add(Ball.createBall(total.charAt(i), turns.get(turns.size() - 1).getScore()));
            }
        }
    }

    public int score() {

        //Initialising variable
        int score = 0;
        //Initialising the pointer
        int cursor = 0;

        //Keeping score by utilising the pointer and adding to the score as it is
        // distinguishing between a spare and strike
        for (int frame = 0; frame < 10; frame++) {

            if (strike(cursor)) {
                score += 10 + turns.get(cursor + 1).getScore() + turns.get(cursor + 2).getScore();
                cursor++;
            } else if (spare(cursor)) {
                score += 10 + turns.get(cursor + 2).getScore();
                cursor += 2;
            } else {
                score += turns.get(cursor).getScore() + turns.get(cursor + 1).getScore();
                cursor += 2;
            }
        }
        return score;
    }
}