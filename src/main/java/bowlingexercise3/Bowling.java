package bowlingexercise3;

public class Bowling {

    private int throww = 0;
    private int[] throwws = new int[28];

    public void throww(String s) {
    }

    public void throwws(String totalScore) {

        for (int i=0; i< totalScore.length(); i++) {

            if (totalScore.charAt(i) == '|') {

            } else {
                int x = totalScore.charAt(i);
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




    public void roll(){

    }


    public int game(){

        return 0;
    }


}
