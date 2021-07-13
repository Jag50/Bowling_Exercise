package bowlingexercise3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    @ParameterizedTest
    @CsvSource(value = {
            //Some combinations of numbers to 10
            "--|, 0", "1-|, 1", "11|, 2", "12|, 3",
            "4-|, 4", "32|, 5", "33|, 6", "61|, 7",
            "44|, 8", "45|, 9", "44|2-, 10"})

    public void testBowling1to9(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

    @ParameterizedTest
    @CsvSource(value = {

            //testing numbers 10 and greater
            "54|1-, 10",
            "54|72|81|22|53|36|22|33|62, 66",
            "54|18|62, 26",
            "54|8-|52|54|8-|52, 48",
            "53|61|62|63|54, 41"})

    public void testBowling10AndMore(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

    @ParameterizedTest
    @CsvSource(value = {

            //Spare tests frames 1-9
            "-/, 10",
            "-/|-/, 20",
            "-/|-/|-/, 30",
            "-/|-/|-/|-/, 40",
            "-/|43|-8|25|53|-4|45|-7|-/, 74",
            "-/|43|-/|-/|-/|-/|45|-/|-/, 94",
            "-/|9/|-/|-/|5/|-/|45|-/|-/, 107",
            "-/|9/|-/|-/|5/|-7|45|9/|-/, 100",
            "-/|-/|-/|-/|-/|-/|-/|7/|-/, 97",
            "1/|-/|4/|9/|, 53"})

    public void testBowlingSpares(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

    @ParameterizedTest
    @CsvSource(value = {

            //Strike tests frames 1-9
            "X, 10",
            "X|--, 10",
            "X|11|, 14",
            "X|5/|1-, 32",
            "X|X|X|22, 70",
            "X|43|-8|X|53|-4|45|-7|X, 88",
            "X|43|X|X|X|X|45|X|X, 166",
            "X|9/|X|X|52|X|45|X|X, 147",
            "-/|17|X|-/|5/|X|X|9/|X, 153",
            "-/|X|X|-/|-/|X|-/|7/|-/, 147",
            "X|X|X|X|X|X|X|X|X, 240"})

    public void testBowlingStrikes(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

}