package bowlingexercise3;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bowling {

    //Determines the number of rolls and limits the frames to 10
    private int turn = 0;
    //limits the frames
    private int[] turns = new int[24];
    private Pattern pattern;
    private Matcher matcher;
    private Pattern patterns;
    private Pattern patternss;
    //"(([-123456789][-123456789/]|[X])\\|){10}";
    private static String REGEX_SPARES_STRIKES = "(([-1-9X][-1-9/]|[X])\\|){10}\\|";
    private static Pattern REGEX_VALID_FULL = Pattern.compile(REGEX_SPARES_STRIKES);


    //Private Boolean created to keep track of pointers which correctly add scores
    private boolean strike(int cursor) {
        return turns[cursor] == 10;
    }

    private boolean spare(int cursor) {
        return turns[cursor] + turns[cursor + 1] == 10;
    }

    //Reads string input
    public void turns(String total) throws IllegalArgumentException {

        validateInput(total);


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

    private void validateInput(String input) throws IllegalArgumentException {

        //should have 10 frames
        // List<String> frames = Arrays.asList(input.split("\\|"));
        Matcher matcherInput = REGEX_VALID_FULL.matcher(input);

        if (!matcherInput.matches()) {

            throw new IllegalArgumentException("Input isn't valid");
        }
//            else {
//                throw new IllegalArgumentException("Input isn't valid");
//            }

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
                score += 10 + turns[cursor + 1] + turns[cursor + 2];
                cursor++;
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


//        if (frames.size() != 12) {
//            throw new IllegalArgumentException("incomplete frames");
//        } else {
//            frames.forEach(frame -> {
//                if (frame.startsWith("X")) {
//
//                } else if (frame.length() != 0 && frame.length() != 2 && frame.length() != 1 && frame.length() != 3 ) {
//                    throw new IllegalArgumentException("incorrect number of turns");
//                }
//                else {
//                    frame.chars().forEach(ball -> {
//                        pattern = Pattern.compile(REGEX_NO_STRIKES);
//                        patterns = Pattern.compile(REGEX_STRIKES);
//                        patternss = Pattern.compile(REGEX_TENTH_FRAME_STRIKE);
//                        matcher = pattern.matcher(frame);
//
//                        if (!matcher.matches()) {
//                            throw new IllegalArgumentException(frame + " input must be one of " + REGEX_NO_STRIKES);
//                        }
//
//                    });
//                }
//
//
//            });
//        }

//        if (total.contains(" ")) {
//            throw new IllegalArgumentException( "Nothing is not allowed, need to enter a valid score");
//        }


}