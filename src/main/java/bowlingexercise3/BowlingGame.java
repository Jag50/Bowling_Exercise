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
        return turns.get(cursor).getScore() + turns.get(cursor + 1).getScore() == 10;
    }


    public void turns(String total) throws IllegalArgumentException {

        BowlingValidation.validateInput(total);

        for (int i = 0; i < total.length(); i++) {
            //Incorporates the addition of a Strike (/) symbol
            if (total.charAt(i) == 'X') {
                turns.add(new Ball(10));
                turn++;
                //Incorporates the addition/separation of the pipe (|) symbol
            } else if (total.charAt(i) == '|') {
                //Incorporates the addition of a miss (-) symbol
            } else if (total.charAt(i) == '-') {
                turns.add(new Ball(0));
                turn++;
                //Incorporates the addition of a spare (/) symbol
            } else if (total.charAt(i) == '/') {
                int diff = 10 - (turns.get(turn - 1).getScore());
                //turns[turn++] = diff;
                turns.add(new Ball(diff));
                turn++;
            }
            //Ensures numbers are added corrected
            else {
                int x = total.charAt(i);
                turns.add(new Ball(x - '0'));
                turn++;
//                turns.get(turns.size() - 2).getScore();
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

