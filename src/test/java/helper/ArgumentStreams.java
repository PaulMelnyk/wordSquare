package helper;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ArgumentStreams {

    public static Stream<Arguments> validArgumentsStream() {
        return Stream.of(
                Arguments.of(4, "eeeeddoonnnsssrv"),
                Arguments.of(4, "aaccdeeeemmnnnoo"),
                Arguments.of(5, "aabbeeeeeeeehmosrrrruttvv"),
                Arguments.of(7, "aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy")
        );
    }

    public static Stream<Arguments> invalidArgumentsStream() {
        return Stream.of(
                Arguments.of(" "),
                Arguments.of("aaaaa")
        );
    }
}
