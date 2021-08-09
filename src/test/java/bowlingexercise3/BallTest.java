package bowlingexercise3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BallTest {


    @ParameterizedTest
    @CsvSource(value = {

            "X, 0, 10",
            "/, 1, 9",
            "/, 2, 8",
            "/, 3, 7",
            "/, 4, 6",
            "/, 5, 5",
            "/, 6, 4",
            "/, 7, 3",
            "/, 8, 2",
            "/, 9, 1",
            "-, 0, 0",
            "-, 1, 0",
            "-, 2, 0",
            "-, 3, 0",
            "-, 4, 0",
            "-, 5, 0",
            "-, 6, 0",
            "-, 7, 0",
            "-, 8, 0",
            "-, 9, 0",
    })

    public void testGetScore(char input, int priorScore, int expectedScore) {

        assertEquals(expectedScore, Ball.createBall(input, priorScore).getScore());
    }

    @Test
    void testIsStrikeTrue() {

        assertTrue(Ball.createBall('X', 10).isStrike());
    }

    @Test
    void testIsStrikeFalse() {

        assertFalse(Ball.createBall('L',0).isStrike());
        assertFalse(Ball.createBall('-',0).isStrike());
        assertFalse(Ball.createBall('1',0).isStrike());
        assertFalse(Ball.createBall('2',0).isStrike());
        assertFalse(Ball.createBall('3',0).isStrike());
        assertFalse(Ball.createBall('4',0).isStrike());
        assertFalse(Ball.createBall('5',0).isStrike());
        assertFalse(Ball.createBall('6',0).isStrike());
        assertFalse(Ball.createBall('7',0).isStrike());
        assertFalse(Ball.createBall('8',0).isStrike());
        assertFalse(Ball.createBall('9',0).isStrike());
        assertFalse(Ball.createBall('+',0).isStrike());
        assertFalse(Ball.createBall('@',0).isStrike());
        assertFalse(Ball.createBall('?',0).isStrike());
        assertFalse(Ball.createBall('o',0).isStrike());
        assertFalse(Ball.createBall('y',0).isStrike());
        assertFalse(Ball.createBall('/',0).isStrike());

    }

    @Test
    void testIsSpareTrue() {

        assertTrue(Ball.createBall('/', 10).isSpare());
    }

    @Test
    void testIsSpareFalse() {

        assertFalse(Ball.createBall('L',0).isSpare());
        assertFalse(Ball.createBall('X',0).isSpare());
        assertFalse(Ball.createBall('-',0).isSpare());
        assertFalse(Ball.createBall('1',0).isSpare());
        assertFalse(Ball.createBall('2',0).isSpare());
        assertFalse(Ball.createBall('3',0).isSpare());
        assertFalse(Ball.createBall('4',0).isSpare());
        assertFalse(Ball.createBall('5',0).isSpare());
        assertFalse(Ball.createBall('6',0).isSpare());
        assertFalse(Ball.createBall('7',0).isSpare());
        assertFalse(Ball.createBall('8',0).isSpare());
        assertFalse(Ball.createBall('9',0).isSpare());
        assertFalse(Ball.createBall('+',0).isSpare());
        assertFalse(Ball.createBall('@',0).isSpare());
        assertFalse(Ball.createBall('?',0).isSpare());
        assertFalse(Ball.createBall('o',0).isSpare());
        assertFalse(Ball.createBall('y',0).isSpare());
    }
}