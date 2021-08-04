package bowlingexercise3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingValidationTest {

    private BowlingGame game = new BowlingGame();

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

        Exception e = assertThrows(IllegalArgumentException.class, () -> game.turns(turns));
        assertEquals("Input isn't valid", e.getMessage());
    }
}