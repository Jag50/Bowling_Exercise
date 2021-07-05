package bowlingexercise3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BowlingTest {

    @Test
    public void scoreZero() {
        Bowling game = new Bowling();
        game.throwws("00|00");
        assertThat(game.score(), is(0));
    }


    @Test
    public void score_7() {
        Bowling game = new Bowling();
        game.throwws("10|10|10|10|10|10|10|00|00|00");
        assertThat(game.score(), is(7));
    }

    @Test
    public void score_8() {
        Bowling game = new Bowling();
        game.throwws("80|00");
        assertThat(game.score(), is(8));
    }

    @Test
    public void score_spare() {
        Bowling game = new Bowling();
        game.throwws("/0|00");
        assertThat(game.score(), is(10));
    }

}