package error;

public class InvalidStringForWordSquareException extends Exception{

    public InvalidStringForWordSquareException(String errorMessage) {
        super("Unable to create word square from given string: " + errorMessage);
    }
}
