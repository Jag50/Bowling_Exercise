package bowlingexercise3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class BowlingTest {


//    @Test
//    public void score_spare() {
//        Bowling game = new Bowling();
//        game.throwws("/0|-0");
//        assertThat(game.score(), is(10));
//    }
//
//    @Test
//    public void score_miss() {
//        Bowling game = new Bowling();
//        game.throwws("--|--");
//        assertThat(game.score(), is(00));
//    }
//
//    @Test
//    public void score_missPlus8() {
//        Bowling game = new Bowling();
//        game.throwws("-8|--");
//        assertThat(game.score(), is(8));
//    }
//





    @ParameterizedTest

    @CsvSource(value = {"/0|00,10", "/0|-0,10", "--|--,0"})

    public void testNumberToRoman1(String throwss, int score) {
        Bowling game = new Bowling();
        game.throwws(throwss);
        assertEquals(score, game.score());
    }


}