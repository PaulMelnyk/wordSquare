import error.InvalidStringForWordSquareException;
import helper.ExpectedWordList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProducerTest {

    Producer testSubject = new Producer();
    ExpectedWordList expectedWordList = new ExpectedWordList();

    @DisplayName("Should create wordSquare using given string")
    @ParameterizedTest(name = "{index} => wordCount={0}, value={1}")
    @MethodSource("helper.ArgumentStreams#validArgumentsStream")
    void validWordSquare_Test(int count, String value) throws IOException, InvalidStringForWordSquareException {
        // given
        char[][] expectedResult = getExpectedResult(count, value);

        // when
        char[][] actualResult = testSubject.getSquare(count, value);

        // then
        assertArrayEquals(expectedResult, actualResult);
    }


    @DisplayName("Should fail to create wordSquare using given string")
    @ParameterizedTest(name = "{index} => wordCount={0}, value={1}")
    @MethodSource("helper.ArgumentStreams#invalidArgumentsStream")
    @NullSource
    @EmptySource
    void invalidWordSquare_Test(String invalidArg) {
        // when
        Exception exception = assertThrows(InvalidStringForWordSquareException.class, () -> {
            testSubject.getSquare(4, invalidArg);
        });

        String expectedMessage = "Unable to create word square from given string: " + invalidArg;
        String actualMessage = exception.getMessage();

        // then
        assertTrue(actualMessage.contains(expectedMessage));
    }

    private char[][] getExpectedResult(int count, String value) {
        char[][] test = new char[count][count];
        ArrayList<String> expectedValues = expectedWordList.getWordArrayList(value);

        return setExpectedArray(count, test, expectedValues);
    }

    private char[][] setExpectedArray(int count, char[][] values, ArrayList value) {
        for (int j = 0; j < count; j++)
            for (int k = 0; k < count; k++) {
                values[j][k] = value.get(j).toString().charAt(k);
            }

        return values;
    }
}