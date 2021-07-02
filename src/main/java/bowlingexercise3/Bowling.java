package bowlingexercise3;

public class Bowling {

    private int throww = 0;
    private int[] throwws = new int[28];

    public void throwws(String total) {

        for (int i=0; i< total.length(); i++) {

            if (total.charAt(i) == '|') {

            } else {
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




    public void roll(){

    }


    public int game(){

        return 0;
    }


}
