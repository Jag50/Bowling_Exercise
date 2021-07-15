package bowlingexercise3;


public class Bowling {

    //Determines the number of rolls and limits the frames to 10
    private int turn = 0;
    //limits the frames
    private int[] turns = new int[24];

    //Private Boolean created to keep track of pointers which correctly add scores
    private boolean strike(int cursor) {
        return turns[cursor] == 10;
    }

    private boolean spare(int cursor) {
        return turns[cursor] + turns[cursor + 1] == 10;
    }



    //Reads string input
    public void turns(String total) throws IllegalArgumentException {

        if (total.contains("///")) {
            throw new IllegalArgumentException( "/// is not allowed");
        }

        if (total.contains("//")) {
            throw new IllegalArgumentException( "// is not allowed");
        }
        if (total.contains("XXXX")){
            throw new IllegalArgumentException("XXXX is not allowed");
        }

        if (total.contains("X/")) {
            throw new IllegalArgumentException( "X/ is not allowed");
        }

        if (total.contains(",")) {
            throw new IllegalArgumentException( ", is an invalid character");
        }

        if (total.contains(".")) {
            throw new IllegalArgumentException( ". is an invalid character");
        }

        if (total.contains("")) {
            throw new IllegalArgumentException( "Nothing is not allowed, need to enter a valid score");
        }

        for (int i = 0; i < total.length(); i++) {
                //Incorporates the addition of a Strike (/) symbol
            if (total.charAt(i) == 'X') {
                turns[turn++] = 10;
                //Incorporates the addition/separation of the pipe (|) symbol
            } else if (total.charAt(i) == '|') {
                //Incorporates the addition of a miss (-) symbol
            } else if (total.charAt(i) == '-') {
                turns[turn++] = 0;
                //Incorporates the addition of a spare (/) symbol
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

        //Keeping score by utilising the pointer and adding to the score as it is
        // distinguishing between a spare and strike
        for (int frame = 0; frame < 10; frame++) {

            if (strike(cursor)) {
                score += 10 + turns[cursor+1] + turns[cursor+2];
                cursor ++;
            } else if (spare(cursor)) {
                score += 10 + turns[cursor + 2];
                cursor += 2;
            } else {
                score += turns[cursor] + turns[cursor + 1];
                cursor += 2;
            }
        }
        return score;
    }

}