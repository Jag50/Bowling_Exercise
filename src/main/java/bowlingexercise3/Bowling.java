package bowlingexercise3;



public class Bowling {
    //Determines the number of rolls and limits the frames to 10
    private int turn = 0;
    private int[] turns = new int[24];
    //Reads string input
    public void turns(String total) {

        for (int i=0; i< total.length(); i++) {
            //Incorporates the addition/separation of the pipe (|) symbol
            if (total.charAt(i) == '|') {

            //Incorporates the addition of a spare (/) symbol
            } else if (total.charAt(i) == '/') {
                turns[turn++] = 10;
            //Incorporates the addition of a miss (-) symbol
            }  else if (total.charAt(i) == '-') {
                turns[turn++] = 0;
            }
        }
    }

    public int score() {
        int score = 0;
        int cursor = 0;
        for (int frame = 0; frame < 10; frame++) {
            score += turns[cursor] + turns[cursor+1];
            cursor += 2;
        }
        return score;
    }
}