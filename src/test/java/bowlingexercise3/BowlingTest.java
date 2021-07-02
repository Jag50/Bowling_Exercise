package bowlingexercise3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class BowlingTest {

@Test
public void scoreZero(){
    Bowling game = new Bowling();
    game.throwws("00|00");
    assertThat(game.score(), is(0));
}


    @Test
    public void scoreTwo(){
        Bowling game = new Bowling();
        game.throwws("10|10|00|00|00|00|00|00|00|00");
        assertThat(game.score(), is(2));
    }

    @Test
    public void score8(){
        Bowling game = new Bowling();
        game.throwws("80|00");
        assertThat(game.score(), is(8));
    }
}

//    @Test
//    public void score8(){
//        Bowling game = new Bowling();
//        game.throwws("18|18|90|90|50|90|90|00|00|00");
//        assertThat(game.score(), is(60));
//    }