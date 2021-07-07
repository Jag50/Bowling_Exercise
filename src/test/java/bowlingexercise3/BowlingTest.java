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

    @CsvSource(value = {"--|, 0", "1-|, 1", "11|, 2", "12|, 3", "4-|, 4","32|, 5","33|, 6",
            "61|, 7","44|, 8","45|, 9","44|2-, 10", "-/|--, 10",
            "-/|43|-/|-/|-/|-/|45|-/|-/, 86", "-/|-/|-/|-/|-/|-/|-/|7/|-/, 90",
            "1/|-/|4/|9/|, 40"})

    public void testNumberToRoman1(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

}