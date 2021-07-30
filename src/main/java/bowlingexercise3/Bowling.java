package bowlingexercise3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bowling {

    // Regular Expressions
    private static String REGEX_SPARES_STRIKES = "(([-1-9][-1-9/]|[X])\\|){10}\\|";
    private static String REGEX_BONUS = "$";
    private static String REGEX_BONUS_SPARE = "(?<=/\\|\\|)([- 1-9X])";
    private static String REGEX_BONUS_STRIKE = "(?<=X\\|\\|)(XX|X[- 1-9]|[- 1-9][- 1-9/])";
    private static String REGEX_VALID_FULL = REGEX_SPARES_STRIKES + "(" + REGEX_BONUS + "|" + REGEX_BONUS_SPARE + "|" + REGEX_BONUS_STRIKE + ")";
    private static Pattern REGEX_VALID_EXP = Pattern.compile(REGEX_VALID_FULL);


    public static void validateInput(String input) throws IllegalArgumentException {

        Matcher matcherInput = REGEX_VALID_EXP.matcher(input);

        if (!matcherInput.matches()) {
            throw new IllegalArgumentException("Input isn't valid");
        }
    }
}