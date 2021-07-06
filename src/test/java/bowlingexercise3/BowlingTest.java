package bowlingexercise3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BowlingTest {


    @Test
    public void score_spare() {
        Bowling game = new Bowling();
        game.throwws("/0|00");
        assertThat(game.score(), is(10));
    }



}