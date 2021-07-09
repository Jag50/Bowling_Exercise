package bowlingexercise3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class BowlingTest {



    @ParameterizedTest

    @CsvSource(value = {
            //Some combinations of numbers to 10
            "--|, 0", "1-|, 1", "11|, 2", "12|, 3", "4-|, 4","32|, 5","33|, 6",
            "61|, 7","44|, 8","45|, 9","44|2-, 10", "-/|--, 10"})

    public void testBowling(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }


    @ParameterizedTest

    @CsvSource(value = {

            //testing of numbers greater than 10, including spare tests
            "9-|2-, 11",
            "-/|43|-8|25|53|-4|45|-7|-/, 74",
            "-/|43|-/|-/|-/|-/|45|-/|-/, 94",
            "-/|9/|-/|-/|5/|-/|45|-/|-/, 107",
            "-/|9/|-/|-/|5/|-7|45|9/|-/, 100",
            "-/|-/|-/|-/|-/|-/|-/|7/|-/, 97",
            "1/|-/|4/|9/|, 53"})

    public void testBowlingSpare(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

}