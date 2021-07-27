package bowlingexercise3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//branch from master and making changes, another branch merging into master where changing lines of code in the same place, see what  happens

public class BowlingTest {

    @ParameterizedTest
    @CsvSource(value = {
            //Some combinations of numbers to 10
            "--|--|--|--|--|--|--|--|--|--||, 0",
            "1-|--|--|--|--|--|--|--|--|--||, 1",
            "11|--|--|--|--|--|--|--|--|--||, 2",
            "12|--|--|--|--|--|--|--|--|--||, 3",
            "4-|--|--|--|--|--|--|--|--|--||, 4",
            "32|--|--|--|--|--|--|--|--|--||, 5",
            "33|--|--|--|--|--|--|--|--|--||, 6",
            "61|--|--|--|--|--|--|--|--|--||, 7",
            "44|--|--|--|--|--|--|--|--|--||, 8",
            "45|--|--|--|--|--|--|--|--|--||, 9",
            "44|2-|--|--|--|--|--|--|--|--||, 10"
    })

    public void testBowling1to9(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

    @ParameterizedTest
    @CsvSource(value = {

            //testing numbers 10 and greater
            "54|1-|--|--|--|--|--|--|--|--||, 10",
            "54|72|81|22|53|36|22|33|62|--||, 66",
            "54|18|62|--|--|--|--|--|--|--||, 26",
            "54|8-|52|54|8-|52|--|--|--|--||, 48",
            "53|61|62|63|54|52|91|--|--|--||, 58",
            "53|61|62|63|54|9-|7-|8-|2-|--||, 67",
            "53|61|62|63|54|--|-2|-3|-6|-1||, 53",
            "53|61|62|63|54|81|9-|7-|8-|-9||, 83"

    })

    public void testBowlingScore10AndMoreInNormal10Frames(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

    @ParameterizedTest
    @CsvSource(value = {

            //Spare tests frames 1-9
            "-/|--|--|--|--|--|--|--|--|--||, 10",
            "-/|-/|--|--|--|--|--|--|--|--||, 20",
            "-/|-/|-/|--|--|--|--|--|--|--||, 30",
            "-/|-/|-/|-/|--|--|--|--|--|--||, 40",
            "-/|43|-8|25|53|-4|45|-7|-/|--||, 74",
            "-/|43|-/|-/|-/|-/|45|-/|-/|--||, 94",
            "-/|9/|-/|-/|5/|-/|45|-/|-/|--||, 107",
            "-/|9/|-/|-/|5/|-7|45|9/|-/|--||, 100",
            "-/|-/|-/|-/|-/|-/|-/|7/|-/|--||, 97",
            "1/|-/|4/|9/|--|--|--|--|--|--||, 53"

    })

    public void testBowlingSparesFramesOneToNine(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

    @ParameterizedTest
    @CsvSource(value = {

            //Strike tests frames 1-9
            "X|--|--|--|--|--|--|--|--|--||, 10",
            "X|X|--|--|--|--|--|--|--|--||, 30",
            "X|11|--|--|--|--|--|--|--|--||, 14",
            "X|5/|1-|--|--|--|--|--|--|--||, 32",
            "X|X|X|22|--|--|--|--|--|--||, 70",
            "X|43|-8|X|53|-4|45|-7|X|--||, 88",
            "X|43|X|X|X|X|45|X|X|--||, 166",
            "X|9/|X|X|52|X|45|X|X|--||, 147",
            "-/|17|X|-/|5/|X|X|9/|X|--||, 153",
            "-/|X|X|-/|-/|X|-/|7/|-/|--||, 147",
            "X|X|X|X|X|X|X|X|X|--||, 240"
    })

    public void testBowlingStrikesFramesOneToNine(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

    @ParameterizedTest
    @CsvSource(value = {

            //Testing strikes and spares for all 10 frames including bonus ball
            //Spare test with and without bonus ball
            "-/|-/|-/|-/|-/|-/|-/|-/|-/|-/||8, 108",
            "-/|-/|-/|-/|-/|-/|-/|-/|-/|-/||-, 100",
            //Strike test with and without bonus ball
            "X|X|X|X|X|X|X|X|X|X||X-, 290",
            "X|X|X|X|X|X|X|X|X|X||XX, 300",
            //Strike, spare and random number test
            "-/|X|-/|X|-/|X|-/|X|-/|5/||X, 195",
            "X|-/|X|-/|X|-/|X|-/|X|-/||X, 200",
            "X|-/|X|45|8/|X|X|7/|X|9/||X, 195",

    })

    public void testBowlingStrikeSpareScoreBonusFrames(String turns, int score) {
        Bowling game = new Bowling();
        game.turns(turns);
        assertEquals(score, game.score());
    }

    @ParameterizedTest
    @CsvSource(value = {

            //Testing boundary conditions for spare bonus

            "--|--|--|--|--|--|--|--|--|-/||-",
            "--|--|--|--|--|--|--|--|--|-/||1",
            "--|--|--|--|--|--|--|--|--|-/||2",
            "--|--|--|--|--|--|--|--|--|-/||3",
            "--|--|--|--|--|--|--|--|--|-/||4",
            "--|--|--|--|--|--|--|--|--|-/||6",
            "--|--|--|--|--|--|--|--|--|-/||7",
            "--|--|--|--|--|--|--|--|--|-/||8",
            "--|--|--|--|--|--|--|--|--|-/||9",
            "--|--|--|--|--|--|--|--|--|-/||X",
            "--|--|--|--|--|--|--|--|--|-/||5",
    })

    public void assertValidInputForSpareBonusBallTest(String turns) {
        Bowling game = new Bowling();
        Assertions.assertDoesNotThrow(() -> game.turns(turns));
    }

    @ParameterizedTest
    @CsvSource(value = {

            "X|//////|X|45|8/|X|X||X||9/|33||",
            "X|///|X|45|8/|X|X||X||9/|11||",
            "X|XXXX|X|45|8/|X|X||X||9||/||",
            "X|X/|X|45|8/|X|X||X||9/||X",
            "X||X|45|8/|X|X||X|9/|X|X|9-||",
            "X|81|X|45|8/|X|X||X|9/X||",
            "11|11|11|11|11|/1|11|11|11||",
            "11|11|11|11|11|1X|11|11|11||",
            "1111888|11|11|11|11|11|11|11|11||",
            "1X?X|11|11|11|11|11|11|11|11||",
            "00|11|11|11|11|11|11|11|11|11||",
            "10|11|11|11|11|11|11|11|11|11||",
            "11|11|11|11|11|11|11|11|11|1//||",
            "H1|11|11|11|11|11|11|11|11|1/||",
            "11|11|11|11|11|11|11|11|1X2|11||",
            "11|11|11|11|11|11|11|11|11|1X2||",
            "11|11|11|11|11|11|11|11|11|1X||",
            "11|/1|11|11|11|11|11|11|11|1/||",
            "11|11|11|11|11|11|11|11|11|/1||",
            "11|11|11|11|11|11|11|11|11|1X||",
            "11|11|11|11|11|11|11|11|11|X/||",
            "/",
            "|",
            "||||||||||",
            "------------------",
            "1|11|11|11|11|11|11|11|11|11||",
            "a1|11|11|11|11|11|11|11|11|11||",
            "1a|11|11|11|11|11|11|11|11|11||",
            "/2|11|11|11|11|11|11|11|11|11||",
            "11|11|11|11|11|11|11|11|11||",
            "11|11|11|11|11|11|11|11|11|11|11||",
            "11|%1|11|11|11|11|11|11|11|11||",
            "1+|11|11|11|11|11|11|11|11|11||",
            "111|11|11|11|11|11|11|11|11|11||",
            "11|11|11|11|11|11|11|11|11|111||",
            "11|11||11|11|11|11|11|11|11|11|||",
            "11|11|11|11|11|1X|11|11|11|11||",
            "X1|11|11|11|11|11|11|11|11|11||",
            "11|11|10|11|11|11|11|11|11|11||",
            "//|11|11|11|11|//|11|11|11|11||",
            "11|11|11|11|11|11|11|11|-X|11||",
            "///|11|22|11|11|//|11|11|11|11||",
            "11|11|45|11|11|11|11|11|-X|11||",

    })

    public void testInvalidInputForFrames1to10(String turns) {

        Bowling game = new Bowling();
        Exception e = assertThrows(IllegalArgumentException.class, () -> game.turns(turns));
        assertEquals("Input isn't valid", e.getMessage());
    }

    @ParameterizedTest
    @EmptySource
    @CsvSource(value = {

            "X|X|X|X|X|X|X|X|X|XX||",
            "X|X|X|X|X|X|X|X|X|XXX||",
            "5|X|X|X|X|X|X|X|X|X||",
            "X|X|X|X|X|X|X|X|X|/||",
            "X|X|X|X|X|X|X|X|X|6||XX",
            "X|X|X|X|X|X|X|X|X|?||35",
            "X|X|X|X|X|X|X|X|X|X||81-",
            "9|X|X|X|X|X|2X|X|X|X||",
            "9|X|X|X|X|X|X|X|X|X||",
            "/X|X|X|X|X|X|X|X|X|X||",
            "-/|X|X|X|X|X|X|X|X|X||-X",

    })
    public void furtherTestingOfInvalidInputContainingStrikes(String turns) {

        Bowling game = new Bowling();
        Exception e = assertThrows(IllegalArgumentException.class, () -> game.turns(turns));
        assertEquals("Input isn't valid", e.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {

            "11|11|11|11|11|11|11|11|11|11||",
            "23|32|11|11|11|11|11|11|11|11||",
            "45|54|11|11|11|11|11|11|11|11||",
            "63|36|11|11|11|11|11|11|11|11||",
            "72|27|11|11|11|11|11|11|11|11||",
            "81|18|11|11|11|11|11|11|11|11||",
            "81|18|11|11|11|11|11|11|11|11||",
            "81|1-|-1|11|11|11|11|-1|11|11||",
            "--|--|--|--|--|--|--|--|--|--||",
            "22|22|22|22|22|22|22|22|22|22||",
            "33|33|33|33|33|33|33|33|33|33||",
            "44|44|44|44|44|44|44|44|44|44||",
            "12|12|12|12|12|12|12|12|12|12||",
            "21|21|21|21|21|21|21|21|21|21||",
            "18|18|18|18|18|18|18|18|18|18||",
            "72|72|72|72|72|72|72|72|72|72||",
            "63|63|63|63|63|63|63|63|63|63||",
            "54|54|54|54|54|54|54|54|54|54||",
            "22|22|45|63|72|81|11|11|11|11||",
            "11|54|11|11|11|11|11|11|11|11||",
            "18|54|61|71|34|35|6-|-8|-4|17||",
            "54|54|55|54|55|54|54|54|54|54||",
            "45|45|45|45|45|45|45|45|45|45||",
            "18|9-|9-|9-|9-|-9|-9|9-|9-|9-||",
            "1/|1/|1/|1/|1/|1/|1/|1/|1/|1/||",
            "-/|-/|-/|-/|-/|-/|-/|-/|-/|-/||",
            "2/|2/|2/|2/|2/|2/|2/|2/|2/|2/||",
            "3/|3/|3/|3/|3/|3/|3/|3/|3/|3/||",
            "4/|4/|4/|4/|4/|4/|4/|4/|4/|4/||",
            "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||",
            "6/|6/|6/|6/|6/|6/|6/|6/|6/|6/||",
            "7/|7/|7/|7/|7/|7/|7/|7/|7/|7/||",
            "8/|8/|8/|8/|8/|8/|8/|8/|8/|8/||",
            "9/|9/|9/|9/|9/|9/|9/|9/|9/|9/||",

    })
    public void testingValidInputNormalFrames1to10(String turns) {

        Bowling game = new Bowling();
        Assertions.assertDoesNotThrow(() -> game.turns(turns));
    }

    @ParameterizedTest
    @CsvSource(value = {

            "-/|-/|-/|-/|-/|-/|-/|-/|-/|-/||3",
            "1/|-/|-/|-/|-/|-/|-/|-/|-/|-/||1",
            "1/|1/|1/|1/|1/|1/|1/|1/|1/|1/||2",
            "2/|2/|2/|2/|2/|2/|2/|2/|2/|2/||4",
            "3/|3/|3/|3/|3/|3/|3/|3/|3/|3/||5",
            "4/|4/|4/|4/|4/|4/|4/|4/|4/|4/||7",
            "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||8",
            "6/|6/|6/|6/|6/|6/|6/|6/|6/|6/||9",
            "7/|7/|7/|7/|7/|7/|7/|7/|7/|7/||6",
            "8/|8/|8/|8/|8/|8/|8/|8/|8/|8/||8",
            "9/|9/|9/|9/|9/|9/|9/|9/|9/|9/||-",
            "1/|1/|3/|4/|5/|6/|7/|7/|8/|9/||-",

    })
    public void testValidInputSpareBonus(String turns) {

        Bowling game = new Bowling();
        Assertions.assertDoesNotThrow(() -> game.turns(turns));
    }

    @ParameterizedTest
    @CsvSource(value = {

            "X|X|X|X|X|X|X|X|X|X||",
            "X|11|11|11|11|11|11|11|11|11||",
            "X|11|X|11|X|11|X|11|X|11||",
            "X|11|11|11|X|X|X|X|X|51||",
            "X|12|23|X|X|X|9-|X|X|61||",
            "X|11|11|11|11|11|11|11|X|81||",

    })
    public void testValidInputStrikeNormal10Frames(String turns) {

        Bowling game = new Bowling();
        Assertions.assertDoesNotThrow(() -> game.turns(turns));
    }

    @ParameterizedTest
    @CsvSource(value = {

            "X|-/|X|-/|X|-/|X|-/|X|--||",
            "12|-/|X|-/|X|-/|X|-/|X|--||",
            "X|34|X|-/|X|-/|X|-/|X|--||",
            "X|-/|54|-/|X|-/|X|-/|X|--||",
            "X|-/|1/|-/|X|-/|X|-/|X|--||",
            "X|-/|X|-/|X|9/|X|-/|X|--||",

    })
    public void testValidInputStrikeAndSpareNormal10Frames(String turns) {

        Bowling game = new Bowling();
        Assertions.assertDoesNotThrow(() -> game.turns(turns));
    }

    @ParameterizedTest
    @CsvSource(value = {

            "X|X|X|X|X|X|X|X|X|X||XX",
            "X|X|X|X|X|X|X|X|X|X||X-",
            "X|X|X|X|X|X|X|X|X|X||X1",
            "X|X|X|X|X|X|X|X|X|X||X2",
            "X|X|X|X|X|X|X|X|X|X||X3",
            "X|X|X|X|X|X|X|X|X|X||X4",
            "X|X|X|X|X|X|X|X|X|X||X5",
            "X|X|X|X|X|X|X|X|X|X||X6",
            "X|X|X|X|X|X|X|X|X|X||X7",
            "X|X|X|X|X|X|X|X|X|X||X8",
            "X|X|X|X|X|X|X|X|X|X||X9",
            "X|X|X|X|X|X|X|X|X|X||1-",
            "X|X|X|X|X|X|X|X|X|X||2-",
            "X|X|X|X|X|X|X|X|X|X||3-",
            "X|X|X|X|X|X|X|X|X|X||4-",
            "X|X|X|X|X|X|X|X|X|X||5-",
            "X|X|X|X|X|X|X|X|X|X||6-",
            "X|X|X|X|X|X|X|X|X|X||7-",
            "X|X|X|X|X|X|X|X|X|X||8-",
            "X|X|X|X|X|X|X|X|X|X||9-",
            "X|X|X|X|X|X|X|X|X|X||1/",
            "X|X|X|X|X|X|X|X|X|X||2/",
            "X|X|X|X|X|X|X|X|X|X||3/",
            "X|X|X|X|X|X|X|X|X|X||4/",
            "X|X|X|X|X|X|X|X|X|X||5/",
            "X|X|X|X|X|X|X|X|X|X||6/",
            "X|X|X|X|X|X|X|X|X|X||7/",
            "X|X|X|X|X|X|X|X|X|X||8/",
            "X|X|X|X|X|X|X|X|X|X||9/",
            "X|X|X|X|X|X|X|X|X|X||--",
            "X|X|X|X|X|X|X|X|X|X||-/",

    })

    public void testValidInputBonusStrike(String turns) {

        Bowling game = new Bowling();
        Assertions.assertDoesNotThrow(() -> game.turns(turns));
    }

    @ParameterizedTest
    @CsvSource(value = {

            "X|X|X|X|X|X|X|X|X|X||1xt",
            "X|X|X|X|X|X|X|X|X|X||1t",
            "X|X|X|X|X|X|X|X|X|X||%t",
            "X|X|X|X|X|X|X|X|X|X|||2",
            "X|X|X|X|X|X|X|X|X|X||1x",
            "X|X|X|X|X|X|X|X|X|X||/3",
            "X|X|X|X|X|X|X|X|X|X||/X",
            "X|X|X|X|X|X|X|X|X|X||-X",

            "-/|-/|-/|-/|-/|-/|-/|-/|-/|-/||p",
            "1/|-/|-/|-/|-/|-/|-/|-/|-/|-/||H",
            "1/|1/|1/|1/|1/|1/|1/|1/|1/|1/||%",
            "2/|2/|2/|2/|2/|2/|2/|2/|2/|2/||2p",
            "3/|3/|3/|3/|3/|3/|3/|3/|3/|3/||33",
            "4/|4/|4/|4/|4/|4/|4/|4/|4/|4/||99",
            "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||+|",
            "6/|6/|6/|6/|6/|6/|6/|6/|6/|6/|||9",
            "7/|7/|7/|7/|7/|7/|7/|7/|7/|7/||/",
            "8/|8/|8/|8/|8/|8/|8/|8/|8/|8/||£",
            "9/|9/|9/|9/|9/|9/|9/|9/|9/|9/||:",
            "1/|1/|3/|4/|5/|6/|7/|7/|8/|9/||X4",

    })
    public void testInvalidInputBonusFrames(String turns) {

        Bowling game = new Bowling();
        Exception e = assertThrows(IllegalArgumentException.class, () -> game.turns(turns));
        assertEquals("Input isn't valid", e.getMessage());
    }
}