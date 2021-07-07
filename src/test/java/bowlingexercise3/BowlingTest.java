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

    @CsvSource(value = {"/0|00,10", "/0|-0,10", "--|--,0"})

    public void testNumberToRoman1(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }


}