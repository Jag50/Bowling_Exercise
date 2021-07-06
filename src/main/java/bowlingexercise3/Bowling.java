package bowlingexercise3;



public class Bowling {
    //Determines the number of rolls and limits the frames to 10
    private int throww = 0;
    private int[] throwws = new int[24];
    //Reads string input
    public void throwws(String total) {

        for (int i=0; i< total.length(); i++) {
            //Incorporates the addition/separation of the pipe (|) symbol
            if (total.charAt(i) == '|') {

            //Incorporates the addition of a spare (/) symbol
            } else if (total.charAt(i) == '/') {
                throwws[throww++] = 10;
            }  else {
                int x = total.charAt(i);
                throwws[throww++] = x - '0';
            }
        }
    }

    public int score() {
        int score = 0;
        int cursor = 0;
        for (int frame = 0; frame < 10; frame++) {
            score += throwws[cursor] + throwws[cursor+1];
            cursor += 2;
        }

        return score;
    }

}