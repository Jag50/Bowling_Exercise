package bowlingexercise3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @ParameterizedTest
    @CsvSource(value = {

            //Testing strikes and spares for all 10 frames including bonus ball
            //Spare test with and without bonus ball
            "-/|-/|-/|-/|-/|-/|-/|-/|-/|-/, 100",
            "-/|-/|-/|-/|-/|-/|-/|-/|-/|-/-, 100",
            //Strike test with and without bonus ball
            "X|X|X|X|X|X|X|X|X|XX, 290",
            "X|X|X|X|X|X|X|X|X|XXX, 300",
            //Strike, spare and random number test
            "-/|X|-/|X|-/|X|-/|X|-/|5/X, 195",
            "X|-/|X|-/|X|-/|X|-/|X|-/X, 200",
            "X|-/|X|45|8/|X|X|7/|X|9/X, 195",
    })

    public void testBowlingStrikeSpare10Frames(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

    @ParameterizedTest
    @CsvSource(value = {

            //Testing boundary conditions

            "--|--|--|--|--|--|--|--|--|-/, 10",
            "--|--|--|--|--|--|--|--|--|-/X, 20",
            "--|--|--|--|--|--|--|--|--|-/5, 15",


    })

    public void boundaryConditions(String turns, Integer score) {
        Bowling game = new Bowling();
        try {
            game.turns(turns);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            assertEquals("incomplete frames", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "",
            "/",
            "|",
            "||||||||||",
            "--------------------",
    })
    public void testInvalidFrames(String turns) {
        Bowling game = new Bowling();
        try {
            game.turns(turns);
            fail("test should have failed");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            assertEquals("incomplete frames", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource(value = {

            "X|//////|X|45|8/|X|X||X|9/X, 183",
            "X|///|X|45|8/|X|X||X|9/X, 183",
            "X|XXXX|X|45|8/|X|X||X|9/X, 183",
            "X|X/|X|45|8/|X|X||X|9/X, 183",
            "X||X|45|8/|X|X||X|9/X, 183",
            "X|81|X|45|8/|X|X||X|9/X, 183",
            "01|11|11|11|11|11|11|11|11|11, 19",
            "00|11|11|11|11|11|11|11|11|11, 18",
            "10|11|11|11|11|11|11|11|11|11, 19",
            "11|11|11|11|11|11|11|11|11|1//, 19",
            "11|11|11|11|11|11|11|11|11|1X2, 19",
            "11|11|11|11|11|11|11|11|11|1X/, 19",
            "11|/1|11|11|11|11|11|11|11|1//, 19",
            "11|11|11|11|11|11|11|11|11|/1, 19",
            "11|11|11|11|11|11|11|11|11|1X, 19",
            "11|11|11|11|11|11|11|11|11|X/1, 19",

    })
    public void testInvalidTurns(String turns) {
        Bowling game = new Bowling();
        try {
            game.turns(turns);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            assertEquals("incomplete turns", e.getMessage());
        }
    }
}