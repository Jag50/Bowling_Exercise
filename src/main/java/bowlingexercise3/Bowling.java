package bowlingexercise3;


public class Bowling {
    //Determines the number of rolls and limits the frames to 10
    private int turn = 0;
    //limits the frames
    private int[] turns = new int[24];


    //Reads string input
    public void turns(String total) {


        for (int i = 0; i < total.length(); i++) {
            //Incorporates the addition/separation of the pipe (|) symbol
            if (total.charAt(i) == '|') {

                //Incorporates the addition of a spare (/) symbol
//            } else if (total.charAt(i) == '/') {
//                turns[turn++] = 10;
                //Incorporates the addition of a miss (-) symbol
            } else if (total.charAt(i) == '-') {
                turns[turn++] = 0;

            } else if (total.charAt(i) == '/') {
                int diff = 10 - turns[turn - 1];
                turns[turn++] = diff;
            }
            //Ensures numbers are added corrected
            else {
                int x = total.charAt(i);
                turns[turn++] = x - '0';
            }
        }

    }

    //Keeps the overall score
    public int score() {

        //Initialising variable
        int score = 0;
        //Initialising the pointer
        int cursor = 0;

        //Keeping score by utilising the pointer and adding to the score and
        // distinguishing it between a spare
        for (int frame = 0; frame < 10; frame++) {

            if (spare(cursor)) {
                score += 10 + turns[cursor + 2];
                cursor += 2;
            } else {
                score += turns[cursor] + turns[cursor + 1];
                cursor += 2;
            }
        }
        return score;
    }

    private boolean spare(int cursor) {
        return turns[cursor] + turns[cursor + 1] == 10;
    }
}