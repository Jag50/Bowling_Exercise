package bowlingexercise3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class BowlingTest {


    //private Game game;

    @Test
    public void createGame() {
        Bowling game = new Bowling();

    }

    @Test
    public void noScore(){
        Bowling game = new Bowling();
        game.throww("00|00|00|00|00|00|00|00|00|00");
        assertThat(game.score(), is(0));
    }

}